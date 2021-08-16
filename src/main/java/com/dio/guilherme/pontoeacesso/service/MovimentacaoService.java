package com.dio.guilherme.pontoeacesso.service;


import java.util.List;
import com.dio.guilherme.pontoeacesso.exception.CustomException;
import com.dio.guilherme.pontoeacesso.model.Movimentacao;
import com.dio.guilherme.pontoeacesso.repository.MovimentacaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class MovimentacaoService {
    
    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    public Movimentacao saveMovimentacao(Movimentacao movimentacao) {
        return movimentacaoRepository.save(movimentacao);
    }

    public List<Movimentacao> getAll() {
        return movimentacaoRepository.findAll();
    }

    public Movimentacao getById(Long id) throws Exception {
        return movimentacaoExists(id);
    }

    public Movimentacao updateMovimentacao(Movimentacao movimentacao) throws Exception {
        movimentacaoExists(movimentacao.getId());
        return movimentacaoRepository.save(movimentacao);
    }

    public void deleteMovimentacao(Long id) throws Exception {
        movimentacaoRepository.delete(movimentacaoExists(id));;
    }

    private Movimentacao movimentacaoExists(Long id) throws Exception {
        return movimentacaoRepository.findById(id)
                .orElseThrow(() -> new CustomException("Movimentacao", id));
    }
}