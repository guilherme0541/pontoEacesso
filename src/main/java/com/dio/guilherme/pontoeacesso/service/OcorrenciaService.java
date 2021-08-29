package com.dio.guilherme.pontoeacesso.service;

import java.util.List;
import com.dio.guilherme.pontoeacesso.exception.CustomException;
import com.dio.guilherme.pontoeacesso.model.Ocorrencia;
import com.dio.guilherme.pontoeacesso.repository.OcorrenciaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class OcorrenciaService {
    
    @Autowired
    private OcorrenciaRepository ocorrenciaRepository;

    public Ocorrencia saveOcorrencia(Ocorrencia ocorrencia) {
        return ocorrenciaRepository.save(ocorrencia);
    }

    public List<Ocorrencia> getAll() {
        return ocorrenciaRepository.findAll();
    }

    public Ocorrencia getById(Long id) throws Exception {
        return ocorrenciaExists(id);
    }

    public Ocorrencia updateOcorrencia(Ocorrencia ocorrencia) throws Exception {
        ocorrenciaExists(ocorrencia.getId());
        return ocorrenciaRepository.save(ocorrencia);
    }

    public void deleteOcorrencia(Long id) throws Exception {
        ocorrenciaRepository.delete(ocorrenciaExists(id));;
    }

    private Ocorrencia ocorrenciaExists(Long id) throws Exception {
        return ocorrenciaRepository.findById(id)
                .orElseThrow(() -> new CustomException("Ocorrencia", id));
    }
}