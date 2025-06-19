package org.acme.service;

import java.util.List;
import java.util.stream.Collectors;

import org.acme.dto.EnderecoDTO;
import org.acme.dto.EnderecoResponseDTO;
import org.acme.model.Endereco;
import org.acme.repository.EnderecoRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class EnderecoImpl implements EnderecoService {

    @Inject
    EnderecoRepository repository;

    @Override
    @Transactional
    public EnderecoResponseDTO inserir(EnderecoDTO dto) {
        Endereco endereco = new Endereco();
        endereco.setQuadra(dto.getQuadra());
        endereco.setAlameda(dto.getAlameda());
        endereco.setLote(dto.getLote());
        endereco.setCep(dto.getCep());
        endereco.setEndereMunicipio(dto.getEnderecoMunicipio());
        endereco.setEnderecUsuario(dto.getEndeUsuario());

        repository.persist(endereco);

        return EnderecoResponseDTO.valueOf(endereco);
    }

    @Override
    public List<Endereco> buscartodos() {
        return repository.listAll();
    }

    @Override
    @Transactional
    public void deletar(Long id) {
        Endereco endereco = repository.findById(id);
        if (endereco != null) {
            repository.delete(endereco);
        }
    }

    @Override
    @Transactional
    public EnderecoResponseDTO alterar(EnderecoDTO dto) {
        Endereco endereco = repository.findById(dto.getId());
        if (endereco == null) {
            throw new RuntimeException("Endereço não encontrado");
        }

        endereco.setQuadra(dto.getQuadra());
        endereco.setAlameda(dto.getAlameda());
        endereco.setLote(dto.getLote());
        endereco.setCep(dto.getCep());
        endereco.setEndereMunicipio(dto.getEnderecoMunicipio());
        endereco.setEnderecUsuario(dto.getEndeUsuario());

        return  EnderecoResponseDTO.valueOf(endereco);
    }

    @Override
    public EnderecoResponseDTO buscarId(Long id) {
        Endereco endereco = repository.findById(id);
        if (endereco == null) {
            throw new RuntimeException("Endereço não encontrado");
        }
        return  EnderecoResponseDTO.valueOf(endereco);
    }
}
