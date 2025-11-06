package com.melikenur.services;

import com.melikenur.dto.DtoAddress;

public interface IAddressService {
    /**
     * Verilen id'ye göre adres bilgisini DTO olarak döner.
     * Service katmanı repository ile iletişime geçer ve gerektiğinde
     * DTO dönüşümlerini yapar.
     *
     * @param id adresin benzersiz kimliği
     * @return DtoAddress bulunursa DTO, bulunmazsa null (daha iyi hata
     *         yönetimi için özel exception fırlatılabilir)
     */
    public DtoAddress findAddressById(Long id);
}
