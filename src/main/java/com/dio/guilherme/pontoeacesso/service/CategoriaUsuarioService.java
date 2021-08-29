package com.dio.guilherme.pontoeacesso.service;

import java.util.List;
import com.dio.guilherme.pontoeacesso.exception.CustomException;
import com.dio.guilherme.pontoeacesso.model.CategoriaUsuario;
import com.dio.guilherme.pontoeacesso.repository.CategoriaUsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaUsuarioService {
    
    @Autowired
    private CategoriaUsuarioRepository categoriaUsuarioRepository;

    public CategoriaUsuario saveCategoriaUsuario(CategoriaUsuario categoriaUsuario) {
        return categoriaUsuarioRepository.save(categoriaUsuario);
    }

    public List<CategoriaUsuario> getAll() {
        return categoriaUsuarioRepository.findAll();
    }

    public CategoriaUsuario getById(Long id) throws Exception {
        return categoriaUsuarioExists(id);
    }

    public CategoriaUsuario updateCategoriaUsuario(CategoriaUsuario categoriaUsuario) throws Exception {
        categoriaUsuarioExists(categoriaUsuario.getId());
        return categoriaUsuarioRepository.save(categoriaUsuario);
    }

    public void deleteCategoriaUsuario(Long id) throws Exception {
        categoriaUsuarioRepository.delete(categoriaUsuarioExists(id));;
    }

    private CategoriaUsuario categoriaUsuarioExists(Long id) throws Exception {
        return categoriaUsuarioRepository.findById(id)
                .orElseThrow(() -> new CustomException("CategoriaUsuario", id));
    }
}