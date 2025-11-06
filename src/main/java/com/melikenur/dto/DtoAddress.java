package com.melikenur.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoAddress {
    /**
     * Adresin benzersiz kimliği (veritabanındaki id'ye karşılık gelebilir)
     */
    private Long id;

    /**
     * Adresin açıklama/detay metni (cadde, sokak vb.).
     */
    private String description;

    /**
     * Bu adrese ait müşteri bilgisi (iloji: many-to-one ilişkisini temsil eden DTO).
     * Döngüsel referanslar oluşabileceği için JSON serileştirmede dikkatli olun.
     */
    private DtoCustomer customer;

}
