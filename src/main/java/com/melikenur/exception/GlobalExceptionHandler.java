package com.melikenur.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;
import java.util.UUID;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Genel amaçlı global exception handler sınıfı. ControllerAdvice ile
    // uygulama genelinde fırlatılan belirli exception türlerini yakalayıp
    // standart bir API hata cevabı (ApiError) üretir.

    /**
     * Map içindeki bir anahtarın değer listesine yeni bir mesaj ekler ve listeyi döner.
     * Küçük yardımcı metot: eğer anahtar daha önce yoksa yeni liste oluşturup ekleriz.
     *
     * @param list mevcut mesaj listesi (boş bir liste ile başlayabilir)
     * @param newValue eklenecek yeni mesaj
     * @return güncellenmiş liste
     */
    private List<String> addMapValue(List<String> list , String newValue){
        list.add(newValue);
        return list;
    }


    /**
     * MethodArgumentNotValidException tipindeki hataları yakalar (bean validation hataları)
     * ve her alan için oluşan doğrulama mesajlarını toplayıp client'a 400 Bad Request
     * ile birlikte `ApiError` formatında döner.
     *
     * @param ex fırlatılan MethodArgumentNotValidException
     * @return ResponseEntity içinde ApiError (field -> [mesajlar] şeklinde map)
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError<Map<String, List<String>>>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, List<String>> errorsMap  = new HashMap<>();

        for (ObjectError objError : ex.getBindingResult().getAllErrors()) {
            // ObjectError genelde FieldError tipindedir; alan ismini alıyoruz
            String fieldName = ((FieldError) objError).getField();
            if (errorsMap.containsKey(fieldName)) {
                errorsMap.put(fieldName, addMapValue(errorsMap.get(fieldName), objError.getDefaultMessage()));
            } else {
                errorsMap.put(fieldName, addMapValue(new ArrayList<>(), objError.getDefaultMessage()));
            }
        }

        // Hata map'ini ApiError içinde paketleyip 400 döneriz
        return ResponseEntity.badRequest().body(createApiError(errorsMap));

    }

    /**
     * ApiError oluşturucu yardımcı metot.
     * @param errors herhangi bir tipteki hata içeriği (map, liste, string vb.)
     * @param <T> errors tipi
     * @return oluşturulmuş ApiError
     */
    private <T> ApiError<T> createApiError(T errors) {
        ApiError<T> apiError = new ApiError<T>();
        apiError.setId(UUID.randomUUID().toString());
        apiError.setErrorTime(new Date());
        apiError.setErrors(errors);

        return apiError;
    }

}
