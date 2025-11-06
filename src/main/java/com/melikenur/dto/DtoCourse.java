package com.melikenur.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoCourse {
    /**
     * Dersin/verilen kursun benzersiz kimliği
     */
    private Long id;

    /**
     * Dersin adı
     */
    private String name;
}
