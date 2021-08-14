package com.dio.guilherme.pontoeacesso.controller;

import java.util.List;

import com.dio.guilherme.pontoeacesso.model.NivelAcesso;
import com.dio.guilherme.pontoeacesso.service.NivelAcessoService;
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
@RequestMapping("/nivelacesso")
public class NivelAcessoController {
    
    @Autowired
    private NivelAcessoService nivelAcessoService;

    @PostMapping
    @ResponseStatus( HttpStatus.CREATED)
    public NivelAcesso createNivelAcesso(@RequestBody NivelAcesso nivelAcesso) {
        return nivelAcessoService.saveNivelAcesso(nivelAcesso);
    }

    @GetMapping
    @ResponseStatus( HttpStatus.OK)
    public List<NivelAcesso> listAllNivelAcesso() {
        return nivelAcessoService.getAll();
    }
    
    @GetMapping("/{id}")
    @ResponseStatus( HttpStatus.OK)
    public NivelAcesso getNivelAcessoById(@PathVariable("id") Long id) throws Exception {
        return nivelAcessoService.getById(id);
    }

    @PutMapping
    @ResponseStatus( HttpStatus.OK)
    public NivelAcesso updateNivelAcesso(@RequestBody NivelAcesso nivelAcesso) throws Exception {
        return nivelAcessoService.updateNivelAcesso(nivelAcesso);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus( HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id) throws Exception {
        nivelAcessoService.deleteNivelAcesso(id);
        
    }
}
