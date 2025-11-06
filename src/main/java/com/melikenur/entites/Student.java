package com.melikenur.entites;

import java.util.List;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    /**
     * Öğrencinin benzersiz kimliği (PK)
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Öğrencinin adı (zorunlu alan)
     */
    @Column(name = "first_name" , nullable = false)
    private String firstName;

    /**
     * Öğrencinin soyadı (zorunlu alan)
     */
    @Column(name = "last_name" , nullable = false)
    private String lastName;

    /**
     * Doğum tarihi. ISO tarih formatı beklenir.
     */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "birth_of_date" , nullable = true)
    private Date birthOfDate;

    /**
     * Öğrenci ile dersler arasında many-to-many ilişki. Ara tablo adı: student_course
     * joinColumns.student_id -> student.id
     * inverseJoinColumns.course_id -> course.id
     */
    @ManyToMany
    @JoinTable(name = "student_course",
            joinColumns = @JoinColumn(name="student_id"),
            inverseJoinColumns =@JoinColumn(name="course_id") )
    private List<Course> courses;

}

