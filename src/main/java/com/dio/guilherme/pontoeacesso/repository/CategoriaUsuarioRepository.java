package com.dio.guilherme.pontoeacesso.repository;

import com.dio.guilherme.pontoeacesso.model.CategoriaUsuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaUsuarioRepository extends JpaRepository<CategoriaUsuario, Long> {
    
}
