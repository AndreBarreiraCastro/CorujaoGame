package org.acme.dto;

import org.acme.model.Estado;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public final class MunicipioDTO {
    @NotNull
    @Size(max = 133,message= "Ultrapassou o tamanho para o campo nome")
    private final String nome;
    @NotNull
    @Size(max = 2,message= "Ultrapassou o tamanho para o campo sigla")
    private final String sigla;
    @NotNull
    @Size(max = 2,message= "Ultrapassou o tamanho para o campo sigla")
    private final Long estadoMunicipio;
    
    public MunicipioDTO(String nome, String sigla,Long estadoMunicipio) {
        this.nome = nome;
        this.sigla = sigla;
        this.estadoMunicipio = estadoMunicipio;
    }
    public String getNome() {
        return nome;
    }
    public String getSigla() {
        return sigla;
    }
    
    public Long getEstadoMunicipio() {
        return estadoMunicipio;
    }
}
