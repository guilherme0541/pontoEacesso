package com.dio.guilherme.pontoeacesso.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
@Entity
@IdClass(MovimentacaoId.class)
public class Movimentacao {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMovimento;

    @Id
    private long idUsuario;

    private LocalDateTime dataEntrada;

    private LocalDateTime dataSaida;

    private BigDecimal periodo;

    @ManyToOne
    private Ocorrencia ocorrencia;
    
    @ManyToOne
    private Calendario calendario;
}

    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    public class MovimentacaoId implements Serializable{
        
        
        private long idMovimento;
        private long idUsuario;
    }