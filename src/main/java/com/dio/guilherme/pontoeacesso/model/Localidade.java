package com.dio.guilherme.pontoeacesso.model;

import javax.persistence.ManyToMany;
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
public class Localidade {
    
    private long id;

    @ManyToMany
    private NivelAcesso nivelAcesso;

    private String descricao;
}
