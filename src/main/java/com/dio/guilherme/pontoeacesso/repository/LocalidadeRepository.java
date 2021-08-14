package com.dio.guilherme.pontoeacesso.repository;

import com.dio.guilherme.pontoeacesso.model.Localidade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalidadeRepository extends JpaRepository<Localidade, Long> {
    
}
