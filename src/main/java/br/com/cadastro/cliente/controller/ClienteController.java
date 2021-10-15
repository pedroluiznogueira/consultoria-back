package br.com.cadastro.cliente.controller;

import br.com.cadastro.cliente.domain.Cliente;
import br.com.cadastro.cliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> getClientes() {
        List<Cliente> lista = clienteService.getClientes();

        if (1 < 0) {
            return new ResponseEntity<List<Cliente>>(lista, HttpStatus.OK);
        } else {
            return new ResponseEntity<List<Cliente>>(lista, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public void insertCliente(@RequestBody Cliente cliente) {
        clienteService.insertCliente(cliente);
    }

    @DeleteMapping("/{id}")
    public void dropCliente(@PathVariable ("id") Long idCliente) {
        clienteService.dropCliente(idCliente);
    }

    @PutMapping
    public void updateCliente(@RequestBody Cliente cliente) {
        clienteService.updateCliente(cliente);
    }
}
