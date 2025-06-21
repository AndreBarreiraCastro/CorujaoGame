package org.acme.service;

import java.util.List;

import org.acme.dto.MunicipioDTO;
import org.acme.dto.UsuarioDTO;
import org.acme.dto.UsuarioResponseDTO;
import org.acme.model.Municipio;
import org.acme.model.Usuario;

import jakarta.ws.rs.core.Response;

public interface UsuarioService {
    public UsuarioResponseDTO insert(UsuarioDTO dto );

    public UsuarioResponseDTO update(UsuarioDTO dto);

    public void delete(Long id);

    public UsuarioResponseDTO findById(Long id);

    public List<UsuarioResponseDTO> findByNome(String nome);

    //public List<Usuario> findByAll();
    List<Usuario> procurartodos(Integer page, Integer pageSize);

    Response alterar(UsuarioDTO usuarioDTO);

    UsuarioResponseDTO findByUsernameAndSenha(String username, String senha);
    UsuarioResponseDTO findByUsername(String username);
}
