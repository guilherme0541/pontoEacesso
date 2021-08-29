package com.dio.guilherme.pontoeacesso.controller;

import java.util.List;

import com.dio.guilherme.pontoeacesso.model.Calendario;
import com.dio.guilherme.pontoeacesso.service.CalendarioService;
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
@RequestMapping("/calendario")
public class CalendarioController {
    
    @Autowired
    private CalendarioService calendarioService;

    @PostMapping
    @ResponseStatus( HttpStatus.CREATED)
    public Calendario createCalendario(@RequestBody Calendario calendario) {
        return calendarioService.saveCalendario(calendario);
    }

    @GetMapping
    @ResponseStatus( HttpStatus.OK)
    public List<Calendario> listAllCalendario() {
        return calendarioService.getAll();
    }
    
    @GetMapping("/{id}")
    @ResponseStatus( HttpStatus.OK)
    public Calendario getCalendarioById(@PathVariable("id") Long id) throws Exception {
        return calendarioService.getById(id);
    }

    @PutMapping
    @ResponseStatus( HttpStatus.OK)
    public Calendario updateCalendario(@RequestBody Calendario calendario) throws Exception {
        return calendarioService.updateCalendario(calendario);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus( HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id) throws Exception {
        calendarioService.deleteCalendario(id);
        
    }
}
