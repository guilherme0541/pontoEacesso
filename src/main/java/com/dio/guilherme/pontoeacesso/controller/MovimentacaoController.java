package com.dio.guilherme.pontoeacesso.controller;

import java.util.List;

import com.dio.guilherme.pontoeacesso.model.Movimentacao;
import com.dio.guilherme.pontoeacesso.service.MovimentacaoService;
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
@RequestMapping("/movimentacao")
public class MovimentacaoController {
    
    @Autowired
    private MovimentacaoService movimentacaoService;

    @PostMapping
    @ResponseStatus( HttpStatus.CREATED)
    public Movimentacao createMovimentacao(@RequestBody Movimentacao movimentacao) {
        return movimentacaoService.saveMovimentacao(movimentacao);
    }

    @GetMapping
    @ResponseStatus( HttpStatus.OK)
    public List<Movimentacao> listAllMovimentacao() {
        return movimentacaoService.getAll();
    }
    
    @GetMapping("/{id}")
    @ResponseStatus( HttpStatus.OK)
    public Movimentacao getMovimentacaoById(@PathVariable("id") Long id) throws Exception {
        return movimentacaoService.getById(id);
    }

    @PutMapping
    @ResponseStatus( HttpStatus.OK)
    public Movimentacao updateMovimentacao(@RequestBody Movimentacao movimentacao) throws Exception {
        return movimentacaoService.updateMovimentacao(movimentacao);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus( HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id) throws Exception {
        movimentacaoService.deleteMovimentacao(id);
        
    }
}
