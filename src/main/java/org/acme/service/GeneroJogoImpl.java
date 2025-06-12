package org.acme.service;

import java.util.List;

import org.acme.dto.GeneroJogoDTO;
import org.acme.dto.GeneroJogoResponseDTO;
import org.acme.dto.JogoDTO;
import org.acme.dto.JogoResponseDTO;
import org.acme.model.GeneroJogo;
import org.acme.model.Jogo;
import org.acme.model.Municipio;
import org.acme.repository.GeneroJogoRepository;
import org.acme.repository.JogoRepository;

import com.arjuna.ats.arjuna.common.recoveryPropertyManager;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
@ApplicationScoped
public class GeneroJogoImpl implements GeneroJogoService {

    @Inject
    GeneroJogoRepository generoJogoRepository;

    @Override
    public GeneroJogoResponseDTO inserir(GeneroJogoDTO genero) {
       GeneroJogo generoJogo = new GeneroJogo();
       generoJogo.setNome(genero.getNome());
       generoJogoRepository.persist(generoJogo);
       return GeneroJogoResponseDTO.valueOf(generoJogo);
    }

    @Override
    public GeneroJogoResponseDTO alterar(Long id, GeneroJogoDTO generojogoDTO) {
        GeneroJogo alteradGeneroJogo = generoJogoRepository.findById(id);
        if(alteradGeneroJogo.getNome()!=generojogoDTO.getNome()){
            alteradGeneroJogo.setNome(generojogoDTO.getNome());
        }
        return GeneroJogoResponseDTO.valueOf(alteradGeneroJogo);
    }

    @Override
    public void deletar(Long id) {
       generoJogoRepository.delete(generoJogoRepository.findById(id));
    }

    @Override
    public GeneroJogoResponseDTO procurarNome(String nome) {
       return GeneroJogoResponseDTO.valueOf(generoJogoRepository.findGeneroJogo(nome));
    }

   

   //  @Override
   //  public List<GeneroJogo> procurartodos() {
   //     return generoJogoRepository.listAll();
   //  }
 @Override
    public List<GeneroJogo> procurartodos(Integer page, Integer pageSize) {
        PanacheQuery<GeneroJogo> query = null;
        if (page == null || pageSize == null)
            query = generoJogoRepository.findAll();
        else 
            query = generoJogoRepository.findAll().page(page, pageSize);

        return query.list();
    }

 @Override
 public Long count() {
   return generoJogoRepository.findAll().count();
 }



    
}
