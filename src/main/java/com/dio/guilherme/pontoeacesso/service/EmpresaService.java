package com.dio.guilherme.pontoeacesso.service;

import java.util.List;
import com.dio.guilherme.pontoeacesso.exception.CustomException;
import com.dio.guilherme.pontoeacesso.model.Empresa;
import com.dio.guilherme.pontoeacesso.repository.EmpresaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaService {
    
    @Autowired
    private EmpresaRepository empresaRepository;

    public Empresa saveEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public List<Empresa> getAll() {
        return empresaRepository.findAll();
    }

    public Empresa getById(Long id) throws Exception {
        return empresaExists(id);
    }

    public Empresa updateEmpresa(Empresa empresa) throws Exception {
        empresaExists(empresa.getId());
        return empresaRepository.save(empresa);
    }

    public void deleteEmpresa(Long id) throws Exception {
        empresaRepository.delete(empresaExists(id));;
    }

    private Empresa empresaExists(Long id) throws Exception {
        return empresaRepository.findById(id)
                .orElseThrow(() -> new CustomException("Empresa", id));
    }
}