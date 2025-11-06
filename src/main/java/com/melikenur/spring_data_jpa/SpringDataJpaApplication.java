package com.melikenur.spring_data_jpa;

import com.melikenur.configuration.GlobalProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.melikenur"})
@ComponentScan(basePackages = {"com.melikenur"})
@EnableJpaRepositories(basePackages = {"com.melikenur"})
@EnableConfigurationProperties(value = GlobalProperties.class)
public class SpringDataJpaApplication {

	/**
	 * Uygulama giriş noktası.
	 *
	 * Açıklamalar:
	 * - @SpringBootApplication: Spring Boot uygulaması olarak başlatır ve
	 *   otomatik konfigürasyon sağlar.
	 * - @EntityScan: JPA entity'lerinin aranacağı paketleri belirtir.
	 * - @ComponentScan: Spring bileşenlerinin (Controller, Service, Repository vb.)
	 *   taranacağı ana paketleri belirtir.
	 * - @EnableJpaRepositories: Spring Data JPA repository aramasını enable eder.
	 * - @EnableConfigurationProperties: `GlobalProperties` sınıfı ile
	 *   application.properties içindeki `app.*` yapılandırmasının
	 *   tip safe olarak bağlanmasını sağlar.
	 *
	 * Not: Bu sınıfta sadece uygulamanın başlatılması için gerekli konfigürasyon
	 * bulunur; iş mantığı uygulama katmanlarındadır (controller/service/...)
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

}
