package com.dio.guilherme.pontoeacesso.repository;

import com.dio.guilherme.pontoeacesso.model.Movimentacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {
    
}
