package com.melikenur.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    /**
     * Müşterinin benzersiz kimliği (PK)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Müşterinin adı
     */
    @Column(name = "name")
    private String name;

    /**
     * Müşterinin adresi. Customer ilişki sahibi (owner) tarafıdır;
     * Address sınıfında mappedBy = "address" şeklinde inverse taraf tanımlıdır.
     * Cascade ve fetch davranışları gerektiğinde burada yapılandırılmalıdır.
     */
    @OneToOne
    private Address address;
}
