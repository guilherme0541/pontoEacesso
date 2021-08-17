package com.dio.guilherme.pontoeacesso.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
@IdClass(BancoHorasId.class)
public class BancoHoras {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBancoHoras;

    @Id
    private long idMovimento;

    @Id
    private long idUsuario;

    private LocalDateTime dataTrabalhada;

    private BigDecimal quantidadeHorasTrabalhadas;

    private BigDecimal saldoHorasTrabalhadas;
}

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class BancoHorasId implements Serializable{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBancoHoras;
    private long idMovimento;
    private long idUsuario;
}