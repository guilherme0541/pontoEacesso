package com.dio.guilherme.pontoeacesso.controller;

import java.util.List;

import com.dio.guilherme.pontoeacesso.model.Ocorrencia;
import com.dio.guilherme.pontoeacesso.service.OcorrenciaService;
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
@RequestMapping("/ocorrencia")
public class OcorrenciaController {
    
    @Autowired
    private OcorrenciaService ocorrenciaService;

    @PostMapping
    @ResponseStatus( HttpStatus.CREATED)
    public Ocorrencia createOcorrencia(@RequestBody Ocorrencia ocorrencia) {
        return ocorrenciaService.saveOcorrencia(ocorrencia);
    }

    @GetMapping
    @ResponseStatus( HttpStatus.OK)
    public List<Ocorrencia> listAllOcorrencia() {
        return ocorrenciaService.getAll();
    }
    
    @GetMapping("/{id}")
    @ResponseStatus( HttpStatus.OK)
    public Ocorrencia getOcorrenciaById(@PathVariable("id") Long id) throws Exception {
        return ocorrenciaService.getById(id);
    }

    @PutMapping
    @ResponseStatus( HttpStatus.OK)
    public Ocorrencia updateOcorrencia(@RequestBody Ocorrencia ocorrencia) throws Exception {
        return ocorrenciaService.updateOcorrencia(ocorrencia);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus( HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id) throws Exception {
        ocorrenciaService.deleteOcorrencia(id);
        
    }
}
