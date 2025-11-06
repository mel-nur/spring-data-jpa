package com.melikenur.configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DataSource {
    /**
     * Veritabanı bağlantısı için kullanılacak URL (jdbc bağlantı dizesi).
     * Örnek: jdbc:postgresql://localhost:5432/postgres
     */
    private String url;

    /**
     * Veritabanı kullanıcı adı.
     * application.properties veya environment üzerinden sağlanır.
     */
    private String username;

    /**
     * Veritabanı kullanıcı şifresi.
     * Gerçek bir üretim uygulamasında bu tür hassas bilgiler
     * şifrelenmiş/sekret yönetimi ile tutulmalıdır (Vault, Azure KeyVault vb.).
     */
    private String password;
}
