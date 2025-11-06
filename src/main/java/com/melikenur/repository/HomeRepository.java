package com.melikenur.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.melikenur.entites.Home;

@Repository
public interface HomeRepository extends JpaRepository<Home, Long>{

}

/**
 * Home repository: `Home` entity'si için CRUD desteği sağlar.
 * Not: Home ile Room arasındaki ilişki yönetimi burada repository tarafından
 * kontrol edilmez; ilişkiler entity tanımlarına (cascade, mappedBy vb.) göre
 * çalışır.
 */
