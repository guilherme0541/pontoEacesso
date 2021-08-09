package com.dio.guilherme.pontoeacesso.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
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
public class Calendario {
    
    @Id
    private long id;

    @ManyToOne
    private TipoData tipoData;
    
    private String descricao;

    private LocalDateTime dataEspecial;
}
