package com.dio.guilherme.pontoeacesso.repository;

import com.dio.guilherme.pontoeacesso.model.Ocorrencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Long> {
    
}
