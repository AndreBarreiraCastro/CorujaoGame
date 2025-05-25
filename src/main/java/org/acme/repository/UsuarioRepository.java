package org.acme.repository;

import java.util.List;

import org.acme.dto.UsuarioDTO;
import org.acme.dto.MunicipioResponseDTO;
import org.acme.model.Usuario;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<Usuario> {
        public List<Usuario> findByNome(String nome) {
        return find("UPPER(nome) LIKE UPPER(?1) ", "%"+nome+"%").list();
    }

    public Usuario findByUsername(String login) {
        return find("nome = ?1 ", login).firstResult();
    }

}
