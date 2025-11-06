package com.melikenur.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiError<T> {
    /**
     * Her hata cevabı için benzersiz bir id oluşturulur (izleme, loglama için).
     */
    private String id;

    /**
     * Hatanın oluştuğu zaman (sunucu saati).
     */
    private Date errorTime;

    /**
     * Hata içeriği. Tip parametresi sayesinde farklı tipte hata nesneleri
     * (String mesajlar, Map, List vb.) taşınabilir.
     */
    private T errors;
}
