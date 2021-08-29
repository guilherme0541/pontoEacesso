package com.dio.guilherme.pontoeacesso.repository;

import com.dio.guilherme.pontoeacesso.model.BancoHoras;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BancoHorasRepository extends JpaRepository<BancoHoras, Long> {
    
}
