package br.com.cadastro.cliente.service;

import br.com.cadastro.cliente.domain.Curso;
import br.com.cadastro.cliente.domain.Pedido;
import br.com.cadastro.cliente.domain.Usuario;
import br.com.cadastro.cliente.repository.CursoRepository;
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
    UsuarioService usuarioService;

    @Autowired
    CursoService cursoService;

    @Autowired
    CursoRepository cursoRepository;

    public Usuario insertPedido(Usuario usuario){
        Usuario newUsuario = usuarioRepository.findByEmail(usuario.getEmail()).orElseThrow(IllegalArgumentException::new);

        newUsuario.getPedidos().addAll(usuario.getPedidos()
                .stream()
                .map(pedido -> {
                    List<Curso> cursos = cursoService.cursosByCursos(pedido.getCursos());

                    Pedido newPedido = new Pedido();
                    newPedido.setUsuario(newUsuario);
                    newPedido.setCursos(cursos);

                    pedidoRepository.save(newPedido);

                    for (Curso curso: cursos){
                        curso.getPedidos().add(newPedido);

                        cursoRepository.save(curso);
                    }

                    return  newPedido;
                })
                .collect(Collectors.toList()));

        return usuarioRepository.save(newUsuario);
    }



}
