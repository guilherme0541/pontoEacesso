package com.dio.guilherme.pontoeacesso.model;

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
public class Empresa {
    
    private long id;

    private String descricao;

    private String cnpj;

    private String endereco;

    private String bairro;

    private String cidade;

    private String estado;

    private String telefone;
}
