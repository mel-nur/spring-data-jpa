package com.melikenur.services.impl;

import com.melikenur.dto.DtoHome;
import com.melikenur.dto.DtoRoom;
import com.melikenur.entites.Home;
import com.melikenur.entites.Room;
import com.melikenur.repository.HomeRepository;
import com.melikenur.services.IHomeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HomeServiceImpl implements IHomeService {

    @Autowired
    private HomeRepository homeRepository;

    @Override
    public DtoHome findHomeById(Long id) {
        // Service katmanı: repository'den Home nesnesi alır ve DTO'ya dönüştürür.
        DtoHome dtoHome = new DtoHome();
        Optional<Home> optional = homeRepository.findById(id);

        // Kayıt bulunamazsa null döndürülüyor. (Daha iyi: özel bir exception fırlatılabilir)
        if (optional.isEmpty()) {
            // Hiçbir şey yok
            return null;
        }

        Home dbHome = optional.get();
        List<Room> dbRooms = dbHome.getRoom();

    // Kaynaktaki entity alanlarını DTO'ya kopyala.
    // Önceden yanlışlıkla dbHome -> dbHome kopyalanıyordu; doğru hedef dtoHome olmalı.
    BeanUtils.copyProperties(dbHome, dtoHome);

        // Odaları DTO'ya çevirmek
        if (dbRooms != null && !dbRooms.isEmpty()) {
            for (Room room : dbRooms) {
                DtoRoom dtoRoom = new DtoRoom();
                BeanUtils.copyProperties(room, dtoRoom);
                dtoHome.getRooms().add(dtoRoom);
            }
        }

        return dtoHome;
    }
}
