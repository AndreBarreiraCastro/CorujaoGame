package org.acme.dto;

import org.acme.model.Perfil;

public record UsuarioDTO(
     Long id,
     String nome,
     String sobrenome,
     String telefone,
     String cpf,
     String email,
    Perfil idperfilUsuario,
    String senha
) {

}
