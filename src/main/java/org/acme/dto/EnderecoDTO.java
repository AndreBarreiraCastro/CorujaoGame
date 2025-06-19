package org.acme.dto;

import org.acme.model.Endereco;
import org.acme.model.Estado;
import org.acme.model.Municipio;
import org.acme.model.Usuario;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public  class EnderecoDTO {
    @NotNull
    private  Long id;
    @NotNull
    private  String quadra;
    @NotNull
    private  String alameda;
    @NotNull
    private  String lote;
    @NotNull
    private  String cep;
    @NotNull
    private  Municipio enderecoMunicipio;
    @NotNull
    private  Usuario endeUsuario;
    public Long getId() {
        return id;
    }
    public String getQuadra() {
        return quadra;
    }
    public String getAlameda() {
        return alameda;
    }
    public String getLote() {
        return lote;
    }
    public String getCep() {
        return cep;
    }
    public Municipio getEnderecoMunicipio() {
        return enderecoMunicipio;
    }
    public Usuario getEndeUsuario() {
        return endeUsuario;
    }
    

   

    
}
