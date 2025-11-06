package com.melikenur.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "app")
public class GlobalProperties {
    /**
     * application.properties içinde tanımlı "app.servers" listesine karşılık gelir.
     * Bu yapı, uygulamanın konfigürasyon ile dışarıdan aldığı sunucu listesi gibi
     * yapılandırmaları temsil etmek için kullanılır. Örnek application.properties:
     * app.servers[0].ip = 192.168.1.2
     * app.servers[0].location = Almanya
     */
    private List<Server> servers;

    /**
     * Basit bir örnek anahtar değerini alır. @Value ile injection yapılır.
     * Not: @ConfigurationProperties ile birlikte kullanımı bazen karışıklık yaratabilir;
     * tutarlılık için tüm app.* konfigürasyonlarını ConfigurationProperties ile
     * almak ve hassas bilgileri @Value yerine gavvalt/secret manager ile sağlamak
     * daha iyidir.
     */
    @Value("${key}")
    private String key;

}
