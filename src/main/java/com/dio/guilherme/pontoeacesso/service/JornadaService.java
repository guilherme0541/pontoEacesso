package com.dio.guilherme.pontoeacesso.service;

import java.util.List;
import com.dio.guilherme.pontoeacesso.exception.CustomException;
import com.dio.guilherme.pontoeacesso.model.JornadaTrabalho;
import com.dio.guilherme.pontoeacesso.repository.JornadaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class JornadaService {
    
    @Autowired
    private JornadaRepository jornadaRepository;

    public JornadaTrabalho saveJornada(JornadaTrabalho jornadaTrabalho) {
        return jornadaRepository.save(jornadaTrabalho);
    }

    public List<JornadaTrabalho> getAll() {
        return jornadaRepository.findAll();
    }

    public JornadaTrabalho getById(Long id) throws Exception {
        return jornadaExists(id);
    }

    public JornadaTrabalho updateJornada(JornadaTrabalho jornadaTrabalho) throws Exception {
        jornadaExists(jornadaTrabalho.getId());
        return jornadaRepository.save(jornadaTrabalho);
    }

    public void deleteJornada(Long id) throws Exception {
        jornadaRepository.delete(jornadaExists(id));;
    }

    private JornadaTrabalho jornadaExists(Long id) throws Exception {
        return jornadaRepository.findById(id)
                .orElseThrow(() -> new CustomException("Jornada", id));
    }
}
