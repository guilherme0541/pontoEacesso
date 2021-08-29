package com.dio.guilherme.pontoeacesso.service;

import java.util.List;
import com.dio.guilherme.pontoeacesso.exception.CustomException;
import com.dio.guilherme.pontoeacesso.model.Usuario;
import com.dio.guilherme.pontoeacesso.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    public Usuario getById(Long id) throws Exception {
        return usuarioExists(id);
    }

    public Usuario updateUsuario(Usuario usuario) throws Exception {
        usuarioExists(usuario.getId());
        return usuarioRepository.save(usuario);
    }

    public void deleteUsuario(Long id) throws Exception {
        usuarioRepository.delete(usuarioExists(id));;
    }

    private Usuario usuarioExists(Long id) throws Exception {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new CustomException("Usuario", id));
    }
}