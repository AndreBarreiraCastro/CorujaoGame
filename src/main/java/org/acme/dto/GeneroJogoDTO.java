package org.acme.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public final class GeneroJogoDTO {
    @NotNull(message = "Nome nao pode ser nulo")
    @Size(max = 133,message= "Ultrapassou o tamanho para o campo nome")
    private final String nome;
    
    public GeneroJogoDTO(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
}
