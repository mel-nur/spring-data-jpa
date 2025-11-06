package com.melikenur.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Server {
    /**
     * Sunucunun IP adresi. application.properties içindeki app.servers[].ip ile eşleşir.
     */
    private String ip;

    /**
     * Sunucunun fiziksel ya da mantıksal konumu (örn. ülke veya şehir).
     */
    private String location;
}
