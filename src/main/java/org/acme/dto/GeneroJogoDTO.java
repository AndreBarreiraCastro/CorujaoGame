package org.acme.dto;

import com.arjuna.ats.arjuna.common.recoveryPropertyManager;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public final class GeneroJogoDTO {
    @NotNull(message = "Nome nao pode ser nulo")
    @Size(max = 133,message= "Ultrapassou o tamanho para o campo nome")
    private final String nome;
    private final Long id;
    public GeneroJogoDTO(String nome,Long id) {
        this.nome = nome;
        this.id = id;
    }
    public String getNome() {
        return nome;
    }

    public Long getId(){
        return id;
    }
}
