package com.melikenur.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoHome {

    private Long id;

    /**
     * Ev için fiyat bilgisi. Veritabanındaki BigDecimal tipini DTO'ya aynen taşır.
     */
    private BigDecimal price;

    /**
     * Bu eve bağlı odaların DTO listesi. Boş liste ile başlatılmıştır
     * böylece null kontrolüne gerek kalmadan ekleme yapılabilir.
     */
    private List<DtoRoom> rooms = new ArrayList<>();
}
