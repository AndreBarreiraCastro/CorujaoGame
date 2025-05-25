package org.acme.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public final class JogoDTO {
    @NotNull
    @Size(max = 133,message= "Ultrapassou o tamanho para o campo nome")
    private final String nome;
    @NotNull
    @Size(max = 2,message= "Ultrapassou o tamanho para o campo quantidade")
    private final int quantidade;
    
    @NotNull
    @Size(max = 2,message= "Ultrapassou o tamanho para o campo quantidade")
    private final Long generoJogo;
    
    public JogoDTO(String nome,int quantidade,Long generoJogo) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.generoJogo = generoJogo;
    }
    public String getNome() {
        return nome;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public Long getGeneroJogo() {
        return generoJogo;
    }
}
