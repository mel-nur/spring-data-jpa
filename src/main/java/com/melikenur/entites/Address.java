package com.melikenur.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "address")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * Adresin benzersiz kimliği (PK)
     */
    private long id;

    /**
     * Adres açıklaması (cadde, sokak, şehir vb.)
     */
    @Column(name = "description")
    private String description;

    /**
     * Bu adresle ilişkili müşteri (Customer).
     * mappedBy = "address" olduğu için ilişki sahibi Customer sınıfıdır;
     * Address burada ilişkinin inverse (ters) tarafıdır.
     */
    @OneToOne(mappedBy = "address")
    private Customer customer;

}
