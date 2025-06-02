package org.acme.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public final class MunicipioDTO {
    @NotBlank(message = "Nome nao pode ser nulo")
    @Size(max = 133,message= "Ultrapassou o tamanho para o campo nome")
    private final String nome;
    @NotBlank(message = "Sigla nao pode ser nulo")
    @Size(max = 2,message= "Ultrapassou o tamanho para o campo sigla")
    private final String sigla;
    @NotBlank(message = "Estado nao pode ser nulo")
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
