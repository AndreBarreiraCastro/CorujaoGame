package org.acme.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public final class JogoDTO {
    @NotNull(message = "Nome nao pode ser nulo")
    @Size(max = 133,message= "Ultrapassou o tamanho para o campo nome")
    private final String nome;
    @NotNull(message = "Quantidade nao pode ser nulo ou negativo")
    @Size(max = 2,message= "Ultrapassou o tamanho para o campo quantidade")
    private final int quantidade;
    
    @NotNull(message = "Genero do jogo nao pode ser nulo")
    @Size(max = 2,message= "Ultrapassou o tamanho para o campo quantidade")
    private final Long generoJogo;
    @NotNull(message = "Valor Unitario nao pode ser nulo")
    @Size(max = 2,message= "Ultrapassou o tamanho para o campo quantidade")
    private final BigDecimal valorUnitario;
    private final Long id;
    
    public JogoDTO(String nome,int quantidade,Long generoJogo,Long id,BigDecimal valorUnitario) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.generoJogo = generoJogo;
        this.valorUnitario = valorUnitario;
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public BigDecimal getvalorUnitiario() {
        return valorUnitario;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public Long getGeneroJogo() {
        return generoJogo;
    }
}
