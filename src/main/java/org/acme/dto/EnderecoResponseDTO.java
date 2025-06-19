package org.acme.dto;

import org.acme.model.Endereco;
import org.acme.model.Estado;
import org.acme.model.Municipio;
import org.acme.model.Perfil;
import org.acme.model.Usuario;

public record EnderecoResponseDTO(Long id,String quadra,String alameda,String lote,String cep,Municipio enderecoMunicipio,Usuario endeUsuario) {

public static EnderecoResponseDTO valueOf(Endereco endereco) {
        return new EnderecoResponseDTO (
            endereco.getId(),
            endereco.getQuadra(),
            endereco.getAlameda(),
            endereco.getLote(),
            endereco.getCep(),
            endereco.getEndereMunicipio(),
            endereco.getEnderecUsuario());
    }
}