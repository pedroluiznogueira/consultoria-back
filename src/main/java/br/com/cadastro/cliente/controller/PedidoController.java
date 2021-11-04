package br.com.cadastro.cliente.controller;

import br.com.cadastro.cliente.domain.Pedido;
import br.com.cadastro.cliente.domain.Usuario;
import br.com.cadastro.cliente.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedido")
@CrossOrigin("*")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @PostMapping("create")
    public ResponseEntity<Pedido> createPedido(@RequestBody Pedido pedido){
        Pedido pd = pedidoService.createPedido(pedido);
        return new ResponseEntity<>(pd, HttpStatus.OK);
    }
}
