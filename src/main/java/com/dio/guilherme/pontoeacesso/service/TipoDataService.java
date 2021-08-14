package com.dio.guilherme.pontoeacesso.service;

import java.util.List;
import com.dio.guilherme.pontoeacesso.exception.CustomException;
import com.dio.guilherme.pontoeacesso.model.TipoData;
import com.dio.guilherme.pontoeacesso.repository.TipoDataRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class TipoDataService {
    
    @Autowired
    private TipoDataRepository tipoDataRepository;

    public TipoData saveTipoData(TipoData tipoData) {
        return tipoDataRepository.save(tipoData);
    }

    public List<TipoData> getAll() {
        return tipoDataRepository.findAll();
    }

    public TipoData getById(Long id) throws Exception {
        return tipoDataExists(id);
    }

    public TipoData updateTipoData(TipoData tipoData) throws Exception {
        tipoDataExists(tipoData.getId());
        return tipoDataRepository.save(tipoData);
    }

    public void deleteTipoData(Long id) throws Exception {
        tipoDataRepository.delete(tipoDataExists(id));;
    }

    private TipoData tipoDataExists(Long id) throws Exception {
        return tipoDataRepository.findById(id)
                .orElseThrow(() -> new CustomException("TipoData", id));
    }
}