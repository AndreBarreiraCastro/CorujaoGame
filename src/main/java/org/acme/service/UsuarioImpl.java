package org.acme.service;

import java.util.List;
import java.util.UUID;

import org.acme.dto.UsuarioResponseDTO;
import org.acme.dto.UsuarioDTO;
import org.acme.dto.UsuarioResponseDTO;
import org.acme.model.Usuario;
import org.acme.model.Perfil;
import org.acme.model.Usuario;
import org.acme.repository.UsuarioRepository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ValidationException;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class UsuarioImpl implements UsuarioService{

    @Inject
    UsuarioRepository repository;

    @Inject
    Hashservice hashService;


     @Override
    public List<Usuario> procurartodos(Integer page, Integer pageSize) {
        PanacheQuery<Usuario> query = null;
        if (page == null || pageSize == null)
            query = repository.find("ORDER BY id");
        else 
            query = repository.find("ORDER BY id").page(page, pageSize);

        return query.list();
    }
@Override
@Transactional
public UsuarioResponseDTO insert(UsuarioDTO dto) {

    if (dto.nome() == null) {
        throw new ValidationException("nome");
    }

    // Gerar ou criptografar senha
    String senhaLegivel = dto.senha();
    if (senhaLegivel == null || senhaLegivel.trim().isEmpty()) {
        // Gera uma senha aleatória simples (ex: UUID)
        senhaLegivel = UUID.randomUUID().toString().substring(0, 8); // 8 caracteres
    }

    String senhaHash;
    try {
        senhaHash = hashService.getHashSenha(senhaLegivel); // Usa o método que você já criou
    } catch (Exception e) {
        throw new RuntimeException("Erro ao gerar hash da senha", e);
    }

    Usuario novoUsuario = new Usuario();
    novoUsuario.setNome(dto.nome());
    novoUsuario.setCpf(dto.cpf());
    novoUsuario.setSobrenome(dto.sobrenome());
    novoUsuario.setTelefone(dto.telefone());
    novoUsuario.setEmail(dto.email());
    novoUsuario.setPerfilUsuario(dto.idperfilUsuario());
    novoUsuario.setUsuariosenha(senhaHash); // Salva senha criptografada

    repository.persist(novoUsuario);

    return UsuarioResponseDTO.valueOf(novoUsuario);
}


    @Override
    @Transactional
    public UsuarioResponseDTO update(UsuarioDTO dto) {
        return null;

    }

    @Override
    @Transactional
    public void delete(Long id) {
    }

    @Override
    public UsuarioResponseDTO findById(Long id) {
         return null;
    }

    @Override
    public List<UsuarioResponseDTO> findByNome(String nome) {
             return null;
    }

  @Override
  @Transactional
public Response alterar(UsuarioDTO usuarioDTO) {
    Usuario usuario = repository.findById(usuarioDTO.id());

        usuario.setNome(usuarioDTO.nome());
        usuario.setSobrenome(usuarioDTO.sobrenome());
        usuario.setTelefone(usuarioDTO.telefone());
        usuario.setCpf(usuarioDTO.cpf());
        usuario.setEmail(usuarioDTO.email());


    if (usuarioDTO.idperfilUsuario() != null ) {
        usuario.setPerfilUsuario(usuarioDTO.idperfilUsuario());
    }

    repository.persist(usuario);

    return Response.ok().entity(UsuarioResponseDTO.valueOf(usuario)).build();
}


    // @Override
    // public List<UsuarioResponseDTO> findByAll() {
    //     return repository.listAll().stream()
    //         .map(e -> UsuarioResponseDTO.valueOf(e)).toList();
    // }



     @Override
     @Transactional
    public UsuarioResponseDTO findByUsernameAndSenha(String username, String senha) {
        return UsuarioResponseDTO.valueOf(
                repository.findByUsernameAndSenha(username, senha)
            );

    }

    @Override
    public UsuarioResponseDTO findByUsername(String username) {
        return UsuarioResponseDTO.valueOf(
            repository.findByUsername(username)
        );
    }
    
}
