package br.com.cadastro.cliente.controller;

import br.com.cadastro.cliente.domain.Cliente;
import br.com.cadastro.cliente.domain.Servico;
import br.com.cadastro.cliente.domain.StatusResponse;
import br.com.cadastro.cliente.domain.Usuario;
import br.com.cadastro.cliente.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servico")
@CrossOrigin("*")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @PostMapping("pesquisa")
    public ResponseEntity<List<Servico>> pesquisar(@RequestBody Servico servicoPesq) {
        List<Servico> servicos = servicoService.pesquisar(servicoPesq.getTitulo());
        return new ResponseEntity<List<Servico>>(servicos, HttpStatus.OK);
    }

    @GetMapping("pesquisa/{id}")
    public ResponseEntity<Servico> findById(@PathVariable ("id") Long id) {
        Servico servico = servicoService.findServicoById(id);
        return new ResponseEntity<Servico>(servico, HttpStatus.OK);
    }

    @GetMapping
    public List<Servico> getServicos() {
        return servicoService.getServicos();
    }

    @PostMapping
    public ResponseEntity<StatusResponse> insertServico(@RequestBody Servico servico) {
        StatusResponse statusResponse = servicoService.insertServico(servico);
        return new ResponseEntity<StatusResponse>(statusResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StatusResponse> dropServico(@PathVariable ("id") Long idServico) {
        StatusResponse statusResponse = servicoService.dropServico(idServico);
        return new ResponseEntity<StatusResponse>(statusResponse, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<StatusResponse> updateServico(@RequestBody Servico servico) {
        StatusResponse statusResponse = servicoService.updateServico(servico);

        return new ResponseEntity<StatusResponse>(statusResponse, HttpStatus.OK);
    }
}
