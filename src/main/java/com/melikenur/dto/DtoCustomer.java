package com.melikenur.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class DtoCustomer {
    /**
     * Müşterinin benzersiz kimliği
     */
    private Long id;

    /**
     * Müşteri adı
     */
    private String name;

    /**
     * Müşterinin adres bilgisi DTO'su. @JsonInclude ile null alanlar serileştirilmez.
     */
    private DtoAddress address;
}
