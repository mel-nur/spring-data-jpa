package com.melikenur.controller;

import java.util.List;
import com.melikenur.dto.DtoEmployee;

public interface IEmployeeController {
    /**
     * Tüm çalışanları DTO listesi olarak döner.
     * Controller implementasyonları bu metodu HTTP GET endpoint'ine
     * bağlayarak istemcilere tüm çalışan listesini sunar.
     *
     * @return çalışan DTO listesi (boş liste dönebilir)
     */
    public List<DtoEmployee> findAllEmployees();
}
