package com.melikenur.services;

import com.melikenur.dto.DtoEmployee;

import java.util.List;

public interface IEmployeeService {
    /**
     * Tüm çalışanları DTO listesi olarak döndürür.
     * Servis katmanı, repository çağrısı yapıp entity'leri DTO'ya çevirir.
     *
     * @return çalışan DTO listesi (boş liste dönebilir)
     */
    public List<DtoEmployee> findAllEmployees();
}
