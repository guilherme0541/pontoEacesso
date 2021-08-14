package com.dio.guilherme.pontoeacesso.controller;

import java.util.List;

import com.dio.guilherme.pontoeacesso.model.Localidade;
import com.dio.guilherme.pontoeacesso.service.LocalidadeService;
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
@RequestMapping("/localidade")
public class LocalidadeController {
    
    @Autowired
    private LocalidadeService localidadeService;

    @PostMapping
    @ResponseStatus( HttpStatus.CREATED)
    public Localidade createLocalidade(@RequestBody Localidade localidade) {
        return localidadeService.saveLocalidade(localidade);
    }

    @GetMapping
    @ResponseStatus( HttpStatus.OK)
    public List<Localidade> listAllLocalidade() {
        return localidadeService.getAll();
    }
    
    @GetMapping("/{id}")
    @ResponseStatus( HttpStatus.OK)
    public Localidade getLocalidadeById(@PathVariable("id") Long id) throws Exception {
        return localidadeService.getById(id);
    }

    @PutMapping
    @ResponseStatus( HttpStatus.OK)
    public Localidade updateLocalidade(@RequestBody Localidade localidade) throws Exception {
        return localidadeService.updateLocalidade(localidade);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus( HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id) throws Exception {
        localidadeService.deleteLocalidade(id);
        
    }
}
