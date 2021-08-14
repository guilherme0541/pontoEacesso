package com.dio.guilherme.pontoeacesso.service;

import java.util.List;
import com.dio.guilherme.pontoeacesso.exception.CustomException;
import com.dio.guilherme.pontoeacesso.model.Calendario;
import com.dio.guilherme.pontoeacesso.repository.CalendarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CalendarioService {
    
    @Autowired
    private CalendarioRepository calendarioRepository;

    public Calendario saveCalendario(Calendario calendario) {
        return calendarioRepository.save(calendario);
    }

    public List<Calendario> getAll() {
        return calendarioRepository.findAll();
    }

    public Calendario getById(Long id) throws Exception {
        return calendarioExists(id);
    }

    public Calendario updateCalendario(Calendario calendario) throws Exception {
        calendarioExists(calendario.getId());
        return calendarioRepository.save(calendario);
    }

    public void deleteCalendario(Long id) throws Exception {
        calendarioRepository.delete(calendarioExists(id));;
    }

    private Calendario calendarioExists(Long id) throws Exception {
        return calendarioRepository.findById(id)
                .orElseThrow(() -> new CustomException("Calendario", id));
    }
}