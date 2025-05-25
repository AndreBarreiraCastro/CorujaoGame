package org.acme.service;

import java.util.List;

import org.acme.dto.JogoDTO;
import org.acme.dto.JogoResponseDTO;
import org.acme.model.Jogo;
import org.acme.repository.GeneroJogoRepository;
import org.acme.repository.JogoRepository;

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
        novoJogo.setJogoGenero(generoJogoRepository.findById(jogo.getGeneroJogo()));
        jogoRepository.persist(novoJogo);

        return JogoResponseDTO.valueOf(novoJogo);
    }

    @Override
    public JogoResponseDTO alterar(Long id, JogoDTO jogoDTO) {
        Jogo alteradoJogo = jogoRepository.findById(id);
        
        if(alteradoJogo.getNome()!=jogoDTO.getNome()){
            alteradoJogo.setNome(jogoDTO.getNome());
        }
        if(alteradoJogo.getQuantidade()!=jogoDTO.getQuantidade()){
            alteradoJogo.setQuantidade(jogoDTO.getQuantidade());
        }
        if(alteradoJogo.getJogoGenero().getId()!=jogoDTO.getGeneroJogo()){
            alteradoJogo.setJogoGenero(generoJogoRepository.findById(jogoDTO.getGeneroJogo()));
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
    public List<Jogo> procurartodos() {
        return jogoRepository.listAll();
    }


}
