package com.melikenur.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudent {
    /**
     * Öğrencinin benzersiz kimliği
     */
    private Integer id;

    /**
     * Öğrencinin adı
     */
    private String firstName;

    /**
     * Öğrencinin soyadı
     */
    private String lastName;

    /**
     * Öğrenciye ait derslerin DTO listesi. Boş liste ile başlatılır.
     */
    private List<DtoCourse> courses = new ArrayList<>();
}
