package com.melikenur.repository;

import com.melikenur.entites.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}

/**
 * Address repository: Spring Data JPA aracılığıyla `Address` entity'si
 * üzerinde CRUD işlemleri sağlar. JpaRepository'nin tüm hazır metotlarını
 * (save, findById, findAll, delete vb.) kullanır. Özel sorgular gerekiyorsa
 * burada metot bildirimleri veya @Query ile eklenebilir.
 */
