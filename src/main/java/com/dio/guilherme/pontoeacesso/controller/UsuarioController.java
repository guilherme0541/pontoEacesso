package com.dio.guilherme.pontoeacesso.controller;

import java.util.List;

import com.dio.guilherme.pontoeacesso.model.Usuario;
import com.dio.guilherme.pontoeacesso.service.UsuarioService;
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
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    @ResponseStatus( HttpStatus.CREATED)
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuarioService.saveUsuario(usuario);
    }

    @GetMapping
    @ResponseStatus( HttpStatus.OK)
    public List<Usuario> listAllUsuario() {
        return usuarioService.getAll();
    }
    
    @GetMapping("/{id}")
    @ResponseStatus( HttpStatus.OK)
    public Usuario getUsuarioById(@PathVariable("id") Long id) throws Exception {
        return usuarioService.getById(id);
    }

    @PutMapping
    @ResponseStatus( HttpStatus.OK)
    public Usuario updateUsuario(@RequestBody Usuario usuario) throws Exception {
        return usuarioService.updateUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus( HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id) throws Exception {
        usuarioService.deleteUsuario(id);
        
    }
}
