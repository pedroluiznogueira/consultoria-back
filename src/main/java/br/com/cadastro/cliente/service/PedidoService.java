package br.com.cadastro.cliente.service;

import br.com.cadastro.cliente.domain.Curso;
import br.com.cadastro.cliente.domain.Pedido;
import br.com.cadastro.cliente.domain.Usuario;
import br.com.cadastro.cliente.repository.CursoRepository;
import br.com.cadastro.cliente.repository.PedidoRepository;
import br.com.cadastro.cliente.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    public Pedido createPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);

    }



}
