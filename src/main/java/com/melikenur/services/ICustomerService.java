package com.melikenur.services;

import com.melikenur.dto.DtoCustomer;

public interface ICustomerService {
    /**
     * Id'ye göre müşteri bilgisi döner. Service katmanı burada iş mantığını
     * uygular (ör. ilişki yükleme, güvenlik filtreleri vb.).
     *
     * @param id müşteri id
     * @return DtoCustomer veya null
     */
    public DtoCustomer findCustomerById(Long id);
}
