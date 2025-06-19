package org.acme.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.acme.dto.ItemPedidoDTO;
import org.acme.dto.PedidoResponseDTO;
import org.acme.dto.PedigoDTO;
import org.acme.model.ItemPedido;
import org.acme.model.Jogo;
import org.acme.model.Pedido;
import org.acme.model.Usuario;
import org.acme.repository.JogoRepository;
import org.acme.repository.PedidoRepository;
import org.acme.repository.UsuarioRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
@ApplicationScoped
public class PedidoImpl implements PedidoService {

    @Inject
    PedidoRepository pedidoRepository;

    @Inject
    UsuarioRepository usuarioRepository;

    @Inject
    JogoRepository jogoRepository;

    @Override
    public List<PedidoResponseDTO> findByUsername(String username) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByUsername'");
    }

    @Override
    public PedidoResponseDTO findById(long idPedido, String username) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    @Transactional
    public PedidoResponseDTO create(PedigoDTO pedidoDTO, String username) {
        // obter o usuario pelo username
        Usuario usuario = usuarioRepository.findByUsername(username);

        Pedido pedido = new Pedido();
        pedido.setDataHora(LocalDateTime.now());
        // calcular o total e verificar se eh igual ao dto
        // vcs (alunos) vao fazer :)
        pedido.setTotalPedido(pedidoDTO.getTotal());
        pedido.setUsuario(usuario);

        List<ItemPedido> listaItem = new ArrayList<ItemPedido>();
        for (ItemPedidoDTO  itemDTO : pedidoDTO.getItens()) {
            Jogo jogo = jogoRepository.findById(itemDTO.getIdProduto());

            ItemPedido item = new ItemPedido();
            item.setPedido(pedido);
            item.setJogo(jogo);
            // verificar se o preco do dto eh o mesmo do produto
            item.setPreco(item.getJogo().getValorUnitario());
            item.setQuantidade(itemDTO.getQtd());

            listaItem.add(item);

            // alterando o estoque 
            jogo.setQuantidade(jogo.getQuantidade() - itemDTO.getQtd());

        }

        pedido.setItens(listaItem);

        // salvando o pedido no banco de dados
        pedidoRepository.persist(pedido);




        return PedidoResponseDTO.valueOf(pedido);
    }
}
