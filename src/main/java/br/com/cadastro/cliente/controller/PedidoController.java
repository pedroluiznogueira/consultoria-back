package br.com.cadastro.cliente.controller;

import br.com.cadastro.cliente.domain.Usuario;
import br.com.cadastro.cliente.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@CrossOrigin("*")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @PostMapping("/pedido")
    public Usuario insertPedido(@RequestBody Usuario usuario){
        Usuario usuarioDb = pedidoService.insertPedido(usuario);

        return  usuarioDb;
    }
}
