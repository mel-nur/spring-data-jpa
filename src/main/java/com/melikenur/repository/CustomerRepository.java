package com.melikenur.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.melikenur.entites.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

/**
 * Customer repository: `Customer` entity'si için temel CRUD operasyonlarını sağlar.
 * Spring Data JPA'nin sağladığı hazır metotlar yeterli olduğunda ekstra kod yazmaya
 * gerek yoktur; özel filtreleme/gelişmiş sorgular için burada yeni metotlar veya
 * @Query ile tanımlamalar eklenebilir.
 */
