package com.dio.guilherme.pontoeacesso.controller;

import java.util.List;

import com.dio.guilherme.pontoeacesso.model.CategoriaUsuario;
import com.dio.guilherme.pontoeacesso.service.CategoriaUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categoriausuario")
public class CategoriaUsuarioController {
    
    @Autowired
    private CategoriaUsuarioService categoriaUsuarioService;

    @PostMapping
    @ResponseStatus( HttpStatus.CREATED)
    public CategoriaUsuario createCategoriaUsuario(@RequestBody CategoriaUsuario categoriaUsuario) {
        return categoriaUsuarioService.saveCategoriaUsuario(categoriaUsuario);
    }

    @GetMapping
    @ResponseStatus( HttpStatus.OK)
    public List<CategoriaUsuario> listAllCategoriaUsuario() {
        return categoriaUsuarioService.getAll();
    }
    
    @GetMapping("/{id}")
    @ResponseStatus( HttpStatus.OK)
    public CategoriaUsuario getCategoriaUsuarioById(@PathVariable("id") Long id) throws Exception {
        return categoriaUsuarioService.getById(id);
    }

    @PutMapping
    @ResponseStatus( HttpStatus.OK)
    public CategoriaUsuario updateCategoriaUsuario(@RequestBody CategoriaUsuario categoriaUsuario) throws Exception {
        return categoriaUsuarioService.updateCategoriaUsuario(categoriaUsuario);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus( HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id) throws Exception {
        categoriaUsuarioService.deleteCategoriaUsuario(id);
        
    }
}
