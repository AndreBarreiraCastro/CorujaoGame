package org.acme.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public final class EstadoDTO {
    @NotNull
    @Size(max = 133,message= "Ultrapassou o tamanho para o campo nome")
    private final String nome;
    @NotNull
    @Size(max = 2,message= "Ultrapassou o tamanho para o campo sigla")
    private final String sigla;
    
    public EstadoDTO(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
    }
    public String getNome() {
        return nome;
    }
    public String getSigla() {
        return sigla;
    }
}
