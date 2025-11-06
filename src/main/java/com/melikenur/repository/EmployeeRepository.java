package com.melikenur.repository;

import com.melikenur.entites.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

/**
 * Employee repository: `Employee` entity'si için JpaRepository tabanlı arayüz.
 * Temel CRUD fonksiyonları hazırdır. Gerektiğinde departman bazlı veya isim
 * bazlı aramalar gibi özel sorgular @Query veya method name convention ile eklenebilir.
 */
