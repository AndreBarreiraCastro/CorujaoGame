package org.acme.dto;

import java.math.BigDecimal;
import java.util.List;

import org.acme.model.GeneroJogo;


import com.google.common.base.Strings;

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
    private final GeneroJogo generoJogo;
    @NotNull(message = "Valor Unitario nao pode ser nulo")
    @Size(max = 2,message= "Ultrapassou o tamanho para o campo quantidade")
    private final Double valorUnitario;
    
    private final Long id;

  private String imagens;
    
    public JogoDTO(String nome,int quantidade,GeneroJogo generoJogo,Long id,Double valorUnitario,String imagemJogo) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.generoJogo = generoJogo;
        this.valorUnitario = valorUnitario;
        this.id = id;
        this.imagens = imagemJogo;
    }
  



    




    public String getNome() {
        return nome;
    }
    public Double getvalorUnitiario() {
        return valorUnitario;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public GeneroJogo getGeneroJogo() {
        return generoJogo;
    }
    public Long getId() {
        return id;
    }
}
