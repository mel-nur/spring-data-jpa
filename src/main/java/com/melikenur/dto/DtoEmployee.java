package com.melikenur.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoEmployee {

    /**
     * Çalışanın benzersiz kimliği
     */
    private Long id;

    /**
     * Çalışanın adı
     */
    private String name;

    /**
     * Çalışanın çalıştığı departmanın DTO'su
     */
    private DtoDepartment department;
}

