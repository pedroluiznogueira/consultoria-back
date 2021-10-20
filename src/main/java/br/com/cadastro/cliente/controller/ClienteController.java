package br.com.cadastro.cliente.controller;

import br.com.cadastro.cliente.domain.Cliente;
import br.com.cadastro.cliente.domain.Servico;
import br.com.cadastro.cliente.domain.StatusResponse;
import br.com.cadastro.cliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@CrossOrigin("*")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("pesquisa")
    public ResponseEntity<List<Cliente>> pesquisar(@RequestBody Cliente cliente) {
        List<Cliente> clientes = clienteService.pesquisar(cliente.getNome());
        return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
    }

    @GetMapping("pesquisa/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable ("id") Long id) {
        Cliente cliente = clienteService.findClienteById(id);
        return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> getClientes() {
        List<Cliente> lista = clienteService.getClientes();
        return new ResponseEntity<List<Cliente>>(lista, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StatusResponse> insertCliente(@RequestBody Cliente cliente) {
        StatusResponse statusResponse = clienteService.insertCliente(cliente);
        return new ResponseEntity<StatusResponse>(statusResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StatusResponse> dropCliente(@PathVariable ("id") Long idCliente) {
        StatusResponse statusResponse = clienteService.dropCliente(idCliente);
        return new ResponseEntity<StatusResponse>(statusResponse, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<StatusResponse> updateCliente(@RequestBody Cliente cliente) {
        StatusResponse statusResponse = clienteService.updateCliente(cliente);

        return new ResponseEntity<StatusResponse>(statusResponse, HttpStatus.OK);
    }
}
