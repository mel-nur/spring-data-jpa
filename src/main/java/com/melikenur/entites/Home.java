package com.melikenur.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "home")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Home {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    /**
     * Ev fiyatı. Veritabanında price sütununa karşılık gelir.
     */
    @Column(name = "price")
    private BigDecimal price;

    /**
     * Ev ile ilişkili odalar (one-to-many). Varsayılan olarak LAZY yükleme
     * davranışı tercih edilmelidir; burada anotasyonda fetch türü belirtilmemiştir.
     * Ayrıca, ilişki tarafında (Room) mappedBy, cascade gibi seçenekler belirlenmelidir
     * gerçek uygulamalarda ilişki yönetimi için.
     */
    @OneToMany
    private List<Room> room;



}
