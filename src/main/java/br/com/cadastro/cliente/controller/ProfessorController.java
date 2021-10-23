package br.com.cadastro.cliente.controller;

import br.com.cadastro.cliente.domain.Cliente;
import br.com.cadastro.cliente.domain.StatusResponse;
import br.com.cadastro.cliente.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
@CrossOrigin("*")
public class ProfessorController {

    @Autowired
    private ProfessorService clienteService;

    // todos professores
    @GetMapping
    public ResponseEntity<List<Cliente>> getClientes() {
        List<Cliente> lista = clienteService.getClientes();
        return new ResponseEntity<List<Cliente>>(lista, HttpStatus.OK);
    }

    // professor por id
    @GetMapping("pesquisa/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable ("id") Long id) {
        Cliente cliente = clienteService.findClienteById(id);
        return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
    }

    // cadastrar professor
    @PostMapping
    public ResponseEntity<StatusResponse> insertCliente(@RequestBody Cliente cliente) {
        StatusResponse statusResponse = clienteService.insertCliente(cliente);
        return new ResponseEntity<StatusResponse>(statusResponse, HttpStatus.OK);
    }


    // excluir professor
    @DeleteMapping("/{id}")
    public ResponseEntity<StatusResponse> dropCliente(@PathVariable ("id") Long idCliente) {
        StatusResponse statusResponse = clienteService.dropCliente(idCliente);
        return new ResponseEntity<StatusResponse>(statusResponse, HttpStatus.OK);
    }

    // atualizar professor
    @PutMapping
    public ResponseEntity<StatusResponse> updateCliente(@RequestBody Cliente cliente) {
        StatusResponse statusResponse = clienteService.updateCliente(cliente);

        return new ResponseEntity<StatusResponse>(statusResponse, HttpStatus.OK);
    }

    // fazer pesquisa por professores
    @PostMapping("pesquisa")
    public ResponseEntity<List<Cliente>> pesquisar(@RequestBody Cliente cliente) {
        List<Cliente> clientes = clienteService.pesquisar(cliente.getNome());
        return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
    }
}
