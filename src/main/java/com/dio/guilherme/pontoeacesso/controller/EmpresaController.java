package com.dio.guilherme.pontoeacesso.controller;

import java.util.List;

import com.dio.guilherme.pontoeacesso.model.Empresa;
import com.dio.guilherme.pontoeacesso.service.EmpresaService;
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
@RequestMapping("/empresa")
public class EmpresaController {
    
    @Autowired
    private EmpresaService empresaService;

    @PostMapping
    @ResponseStatus( HttpStatus.CREATED)
    public Empresa createEmpresa(@RequestBody Empresa empresa) {
        return empresaService.saveEmpresa(empresa);
    }

    @GetMapping
    @ResponseStatus( HttpStatus.OK)
    public List<Empresa> listAllEmpresa() {
        return empresaService.getAll();
    }
    
    @GetMapping("/{id}")
    @ResponseStatus( HttpStatus.OK)
    public Empresa getEmpresaById(@PathVariable("id") Long id) throws Exception {
        return empresaService.getById(id);
    }

    @PutMapping
    @ResponseStatus( HttpStatus.OK)
    public Empresa updateEmpresa(@RequestBody Empresa empresa) throws Exception {
        return empresaService.updateEmpresa(empresa);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus( HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id) throws Exception {
        empresaService.deleteEmpresa(id);
        
    }
}
