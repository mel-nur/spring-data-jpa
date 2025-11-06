# spring-data-jpa (kısa)

Basit bir Spring Boot + Spring Data JPA örneği.

Gereksinimler
- Java 17+
- Maven (veya proje içindeki `mvnw.cmd`)
- PostgreSQL

Hızlı çalıştırma (PowerShell):

```powershell
.\mvnw.cmd -DskipTests package
java -jar target\spring-data-jpa-0.0.1-SNAPSHOT.jar
```

Hızlı notlar
- Konfigürasyon: `src/main/resources/application.properties` (JDBC URL, kullanıcı, şifre).
- Eğer startup'ta "schema \"student\" does not exist" hatası alırsanız ya DB'de `student` şemasını oluşturun ya da `spring.jpa.properties.hibernate.default_schema` değerini `public` yapın.
- Eğer "No qualifying bean of type 'com.melikenur.services.IHomeService'" hatası alırsanız, `SpringDataJpaApplication` içine `@SpringBootApplication(scanBasePackages = "com.melikenur")` ekleyin veya ana sınıfı `com.melikenur` paketine taşıyın.

