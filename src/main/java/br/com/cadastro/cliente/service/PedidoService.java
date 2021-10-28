package br.com.cadastro.cliente.service;

import br.com.cadastro.cliente.domain.Curso;
import br.com.cadastro.cliente.domain.Pedido;
import br.com.cadastro.cliente.domain.Usuario;
import br.com.cadastro.cliente.repository.PedidoRepository;
import br.com.cadastro.cliente.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    CursoService cursoService;

    public Usuario insertPedido(Usuario usuario){

        Usuario newUsuario = usuarioRepository.findByEmail(usuario.getEmail()).orElseThrow(IllegalArgumentException::new);

        List<Pedido> pedidos = usuario.getPedidos()
                .stream()
                .map(pedido -> {
                    List<Curso> cursos = cursoService.cursosByCursos(pedido.getCursos());

                    Pedido newPedido = new Pedido();
                    newPedido.setCursos(cursos);
                    newPedido.setUsuario(newUsuario);

                    return  newPedido;
                })
                .collect(Collectors.toList());

        return usuarioRepository.save(newUsuario);
    }



}
