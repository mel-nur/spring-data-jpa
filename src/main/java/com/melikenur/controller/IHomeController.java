package com.melikenur.controller;

import com.melikenur.dto.DtoHome;

public interface IHomeController {
    /**
     * Belirtilen id'ye sahip evi DTO (Data Transfer Object) şeklinde döner.
     * Controller arayüzü olarak REST uç noktalarını uygulayan sınıflar
     * bu metodu gerçekleştirecektir.
     *
     * @param id  evin veritabanındaki benzersiz kimliği
     * @return DtoHome   mevcutsa ev verisi, yoksa null (uygulama katmanında
     *         daha iyi hata yönetimi kullanılması önerilir)
     */
    public DtoHome findHomeById(Long id);
}
