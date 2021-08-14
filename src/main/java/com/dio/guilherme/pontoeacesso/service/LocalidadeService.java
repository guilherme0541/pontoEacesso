package com.dio.guilherme.pontoeacesso.service;

import java.util.List;
import com.dio.guilherme.pontoeacesso.exception.CustomException;
import com.dio.guilherme.pontoeacesso.model.Localidade;
import com.dio.guilherme.pontoeacesso.repository.LocalidadeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class LocalidadeService {
    
    @Autowired
    private LocalidadeRepository localidadeRepository;

    public Localidade saveLocalidade(Localidade localidade) {
        return localidadeRepository.save(localidade);
    }

    public List<Localidade> getAll() {
        return localidadeRepository.findAll();
    }

    public Localidade getById(Long id) throws Exception {
        return localidadeExists(id);
    }

    public Localidade updateLocalidade(Localidade localidade) throws Exception {
        localidadeExists(localidade.getId());
        return localidadeRepository.save(localidade);
    }

    public void deleteLocalidade(Long id) throws Exception {
        localidadeRepository.delete(localidadeExists(id));;
    }

    private Localidade localidadeExists(Long id) throws Exception {
        return localidadeRepository.findById(id)
                .orElseThrow(() -> new CustomException("Localidade", id));
    }
}