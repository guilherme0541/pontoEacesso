package com.dio.guilherme.pontoeacesso.service;

import java.util.List;
import com.dio.guilherme.pontoeacesso.exception.CustomException;
import com.dio.guilherme.pontoeacesso.model.BancoHoras;
import com.dio.guilherme.pontoeacesso.repository.BancoHorasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class BancoHorasService {
    
    @Autowired
    private BancoHorasRepository bancoHorasRepository;

    public BancoHoras saveBancoHoras(BancoHoras bancoHoras) {
        return bancoHorasRepository.save(bancoHoras);
    }

    public List<BancoHoras> getAll() {
        return bancoHorasRepository.findAll();
    }

    public BancoHoras getById(Long id) throws Exception {
        return bancoHorasExists(id);
    }

    public BancoHoras updateBancoHoras(BancoHoras bancoHoras) throws Exception {
        bancoHorasExists(bancoHoras.getId());
        return bancoHorasRepository.save(bancoHoras);
    }

    public void deleteBancoHoras(Long id) throws Exception {
        bancoHorasRepository.delete(bancoHorasExists(id));;
    }

    private BancoHoras bancoHorasExists(Long id) throws Exception {
        return bancoHorasRepository.findById(id)
                .orElseThrow(() -> new CustomException("BancoHoras", id));
    }
}