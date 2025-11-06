package com.melikenur.controller;

import com.melikenur.dto.DtoAddress;

public interface IAddressController {
    /**
     * Verilen id'ye göre adres bilgisi döner.
     * Controller arayüzü olarak implementasyonlar bu metoda uygun
     * REST endpoint'leri bağlar.
     *
     * @param id adresin benzersiz kimliği
     * @return DtoAddress bulunursa DTO, bulunmazsa null (controller katmanında
     *         uygun HTTP yanıtı verilmelidir)
     */
    public DtoAddress findAddressById(Long id);

}
