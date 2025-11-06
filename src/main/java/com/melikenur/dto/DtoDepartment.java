package com.melikenur.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoDepartment {

    /**
     * Departmanın benzersiz kimliği
     */
    private Long id;

    /**
     * Departman adı (ör. "IT", "Muhasebe")
     */
    private String departmentName;
}