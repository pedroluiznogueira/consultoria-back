package br.com.cadastro.cliente.controller;

import br.com.cadastro.cliente.domain.Confirmacao;
import br.com.cadastro.cliente.domain.Usuario;
import br.com.cadastro.cliente.domain.UsuarioLogin;
import br.com.cadastro.cliente.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {


    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> getUsuarios() {
        List<Usuario> lista = usuarioService.getUsuarios();
        return new ResponseEntity<List<Usuario>>(lista, HttpStatus.OK);
    }

    @PostMapping("find/email")
    public ResponseEntity<Usuario> getUsuarioByEmail(@RequestBody Usuario usuarioEmail) {
        Usuario usuario = usuarioService.getUsuarioByEmail(usuarioEmail.getEmail());
        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    }

    @PostMapping("login")
    public ResponseEntity<Usuario> login(@RequestBody Optional<UsuarioLogin> usuarioLogin) {
        return usuarioService.logar(usuarioLogin)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

    @PostMapping("cadastro")
    public ResponseEntity<Usuario> cadastro(@RequestBody Usuario usuario) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(usuarioService.cadastrarUsuario(usuario));
    }

    @PostMapping("confirmar")
    public Confirmacao confirmado(@RequestBody Confirmacao confirmacao) {
        return usuarioService.confirmado(confirmacao);

    }

    @GetMapping("teste")
    public String teste() {
        return "teste";
    }

}
