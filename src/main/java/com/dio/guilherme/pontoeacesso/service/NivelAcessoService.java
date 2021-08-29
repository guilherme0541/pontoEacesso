package com.dio.guilherme.pontoeacesso.service;

import java.util.List;
import com.dio.guilherme.pontoeacesso.exception.CustomException;
import com.dio.guilherme.pontoeacesso.model.NivelAcesso;
import com.dio.guilherme.pontoeacesso.repository.NivelAcessoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class NivelAcessoService {
    
    @Autowired
    private NivelAcessoRepository nivelAcessoRepository;

    public NivelAcesso saveNivelAcesso(NivelAcesso nivelAcesso) {
        return nivelAcessoRepository.save(nivelAcesso);
    }

    public List<NivelAcesso> getAll() {
        return nivelAcessoRepository.findAll();
    }

    public NivelAcesso getById(Long id) throws Exception {
        return nivelAcessoExists(id);
    }

    public NivelAcesso updateNivelAcesso(NivelAcesso nivelAcesso) throws Exception {
        nivelAcessoExists(nivelAcesso.getId());
        return nivelAcessoRepository.save(nivelAcesso);
    }

    public void deleteNivelAcesso(Long id) throws Exception {
        nivelAcessoRepository.delete(nivelAcessoExists(id));;
    }

    private NivelAcesso nivelAcessoExists(Long id) throws Exception {
        return nivelAcessoRepository.findById(id)
                .orElseThrow(() -> new CustomException("NivelAcesso", id));
    }
}