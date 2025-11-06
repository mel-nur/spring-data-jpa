package com.melikenur.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    /**
     * Çalışanın benzersiz kimliği (PK)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Çalışanın adı
     */
    @Column(name = "name")
    private String name;

    /**
     * Çalışanın bağlı olduğu departman. Many-to-one ilişkisidir.
     */
    @ManyToOne
    private Department department;
}
