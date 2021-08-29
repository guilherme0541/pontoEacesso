package com.dio.guilherme.pontoeacesso.controller;

import java.util.List;

import com.dio.guilherme.pontoeacesso.model.TipoData;
import com.dio.guilherme.pontoeacesso.service.TipoDataService;
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
@RequestMapping("/tipodata")
public class TipoDataController {
    
    @Autowired
    private TipoDataService tipoDataService;

    @PostMapping
    @ResponseStatus( HttpStatus.CREATED)
    public TipoData createTipoData(@RequestBody TipoData tipoData) {
        return tipoDataService.saveTipoData(tipoData);
    }

    @GetMapping
    @ResponseStatus( HttpStatus.OK)
    public List<TipoData> listAllTipoData() {
        return tipoDataService.getAll();
    }
    
    @GetMapping("/{id}")
    @ResponseStatus( HttpStatus.OK)
    public TipoData getTipoDataById(@PathVariable("id") Long id) throws Exception {
        return tipoDataService.getById(id);
    }

    @PutMapping
    @ResponseStatus( HttpStatus.OK)
    public TipoData updateTipoData(@RequestBody TipoData tipoData) throws Exception {
        return tipoDataService.updateTipoData(tipoData);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus( HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id) throws Exception {
        tipoDataService.deleteTipoData(id);
        
    }
}
