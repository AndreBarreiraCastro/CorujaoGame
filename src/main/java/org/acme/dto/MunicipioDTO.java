package org.acme.dto;

import org.acme.model.Estado;

import com.fasterxml.jackson.annotation.JsonCreator;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public final class MunicipioDTO {
    @NotBlank(message = "Nome nao pode ser nulo")
    @Size(max = 133,message= "Ultrapassou o tamanho para o campo id")
    private final long id;
    @NotBlank(message = "Nome nao pode ser nulo")
    @Size(max = 133,message= "Ultrapassou o tamanho para o campo nome")
    private final String nome;
    @NotBlank(message = "Sigla nao pode ser nulo")
    @Size(max = 2,message= "Ultrapassou o tamanho para o campo sigla")
    private final String sigla;
    @NotBlank(message = "Estado nao pode ser nulo")
    @Size(max = 2)
    private final Estado estadoMunicipio;
    
    public MunicipioDTO(Long id,String nome, String sigla,Estado estadoMunicipio) {
        this.id = id;
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
    public Estado getEstado() {
        return estadoMunicipio;
    }
   
    
    public Long getidMunicipio() {
        return id;
    }
}
