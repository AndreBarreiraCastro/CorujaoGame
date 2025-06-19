package org.acme.dto;

import org.acme.model.Perfil;
import org.acme.model.Usuario;

public record UsuarioResponseDTO(Long id,String nome,String sobrenome,String telefone,String cpf,String email,Perfil idperfilUsuario,String senha) {

public static UsuarioResponseDTO valueOf(Usuario usuario) {
        return new UsuarioResponseDTO (
            usuario.getId(),
            usuario.getNome(),
            usuario.getSobrenome(),
            usuario.getTelefone(),
            usuario.getCpf(),
            usuario.getEmail(),
            usuario.getPerfilUsuario(),
            usuario.getUsuariosenha());
    }
}