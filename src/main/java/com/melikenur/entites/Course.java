package com.melikenur.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "course")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    /**
     * Dersin benzersiz kimliği (ID). Bu örnekte manuel setleniyor gibi duruyor.
     */
    @Id
    private Long id;

    /**
     * Ders adı
     */
    private String name;

}
