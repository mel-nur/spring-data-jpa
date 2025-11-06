package com.melikenur.services.impl;

import com.melikenur.dto.DtoAddress;
import com.melikenur.dto.DtoCustomer;
import com.melikenur.entites.Address;
import com.melikenur.repository.AddressRepository;
import com.melikenur.services.IAddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImpl implements IAddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public DtoAddress findAddressById(Long id) {
        // Service: repository'den Address alır, DTO'ya dönüştürür ve döner.
        // Basit mapping için BeanUtils kullanılıyor; ilişki (customer) elle
        // dönüştürülerek DTO'ya ekleniyor. Bulunamazsa null döndürülüyor.
        DtoAddress dtoAddress = new DtoAddress();
        Optional<Address> optional = addressRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }

        Address address = optional.get();
        BeanUtils.copyProperties(address, dtoAddress);

        // İlişkili müşteri bilgisi doğrudan entity'den alınarak DTO'ya set ediliyor.
        // Döngüsel bağımlılıklar veya null kontrolü gerekli olabilir.
        DtoCustomer dtoCustomer = new DtoCustomer();
        if (address.getCustomer() != null) {
            dtoCustomer.setId(address.getCustomer().getId());
            dtoCustomer.setName(address.getCustomer().getName());
            dtoAddress.setCustomer(dtoCustomer);
        }

        return dtoAddress;
    }
}
