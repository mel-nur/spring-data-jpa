package com.melikenur.controller;

import com.melikenur.dto.DtoCustomer;
public interface ICustomerController {
    /**
     * Belirtilen id'ye sahip müşteriyi döner.
     * Controller implementasyonları bu arayüzü REST endpoint'leriyle
     * eşleştirirler.
     *
     * @param id müşteri id
     * @return DtoCustomer veya null
     */
    public DtoCustomer findCustomerById(Long id);

}
