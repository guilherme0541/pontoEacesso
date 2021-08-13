package com.dio.guilherme.pontoeacesso.controller;

import java.util.List;

import com.dio.guilherme.pontoeacesso.model.JornadaTrabalho;
import com.dio.guilherme.pontoeacesso.service.JornadaService;
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
@RequestMapping("/jornada")
public class JornadaTrabalhoController {
    
    @Autowired
    private JornadaService jornadaService;

    @PostMapping
    @ResponseStatus( HttpStatus.CREATED)
    public JornadaTrabalho createJornada(@RequestBody JornadaTrabalho jornadaTrabalho) {
        return jornadaService.saveJornada(jornadaTrabalho);
    }

    @GetMapping
    @ResponseStatus( HttpStatus.OK)
    public List<JornadaTrabalho> listAllJornada() {
        return jornadaService.getAll();
    }
    
    @GetMapping("/{id}")
    @ResponseStatus( HttpStatus.OK)
    public JornadaTrabalho getJornadaById(@PathVariable("id") Long id) throws Exception {
        return jornadaService.getById(id);
    }

    @PutMapping
    @ResponseStatus( HttpStatus.OK)
    public JornadaTrabalho updateJornada(@RequestBody JornadaTrabalho jornadaTrabalho) throws Exception {
        return jornadaService.updateJornada(jornadaTrabalho);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus( HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id) throws Exception {
        jornadaService.deleteJornada(id);
        
    }
}
