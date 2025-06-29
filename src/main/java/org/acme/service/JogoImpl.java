package org.acme.service;

import java.util.List;

import org.acme.dto.JogoDTO;
import org.acme.dto.JogoResponseDTO;
import org.acme.model.Jogo;
import org.acme.model.Municipio;
import org.acme.repository.GeneroJogoRepository;
import org.acme.repository.JogoRepository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
@ApplicationScoped
public class JogoImpl implements JogoService {

    @Inject
    GeneroJogoRepository generoJogoRepository;

    @Inject
    JogoRepository jogoRepository;

    @Override
    public JogoResponseDTO inserir(JogoDTO jogo) {
        Jogo novoJogo = new Jogo();
        novoJogo.setNome(jogo.getNome());
        novoJogo.setQuantidade(jogo.getQuantidade());
        novoJogo.setJogoGenero(jogo.getGeneroJogo());
        novoJogo.setValorUnitario(jogo.getvalorUnitiario());
        jogoRepository.persist(novoJogo);

        return JogoResponseDTO.valueOf(novoJogo);
    }

    @Override
    public JogoResponseDTO alterar( JogoDTO jogoDTO) {
        Jogo alteradoJogo = jogoRepository.findById(jogoDTO.getId());
        
        if(alteradoJogo.getNome()!=jogoDTO.getNome()){
            alteradoJogo.setNome(jogoDTO.getNome());
        }
        if(alteradoJogo.getQuantidade()!=jogoDTO.getQuantidade()){
            alteradoJogo.setQuantidade(jogoDTO.getQuantidade());
        }
        if(alteradoJogo.getJogoGenero()!=jogoDTO.getGeneroJogo()){
            alteradoJogo.setJogoGenero(jogoDTO.getGeneroJogo());
        }
        if(alteradoJogo.getValorUnitario()!=jogoDTO.getvalorUnitiario()){
            alteradoJogo.setValorUnitario(jogoDTO.getvalorUnitiario());
        }
        return JogoResponseDTO.valueOf(alteradoJogo);
    }

    @Override
    public void deletar(Long id) {
        jogoRepository.delete(jogoRepository.findById(id));
    }

    @Override
    public JogoResponseDTO procurarjogo(Long id) {
      return JogoResponseDTO.valueOf(jogoRepository.findById(id));
    }

    @Override
    public JogoResponseDTO procurarNome(String nome) {
     return JogoResponseDTO.valueOf(jogoRepository.findJogo(nome));
    }

   @Override
    public List<Jogo> procurartodos(Integer page, Integer pageSize) {
        PanacheQuery<Jogo> query = null;
        if (page == null || pageSize == null)
            query = jogoRepository.find("ORDER BY id");
        else 
            query =jogoRepository.find("ORDER BY id").page(page, pageSize);

        return query.list();
    }

 @Override
 public long count() {
   return jogoRepository.findAll().count();
 }
}
