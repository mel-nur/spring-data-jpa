package com.melikenur.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoRoom {

    /**
     * Odaların benzersiz kimliği
     */
    private Long id;

    /**
     * Oda adı veya tanımı (ör. "Salon", "Yatak Odası")
     */
    private String name;
}
