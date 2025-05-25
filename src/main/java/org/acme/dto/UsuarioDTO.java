package org.acme.dto;

import org.acme.model.Perfil;

public record UsuarioDTO(
     String nome,
     String sobrenome,
     String telefone,
     String cpf,
     String email,
     Perfil idperfilUsuario
) {

}
