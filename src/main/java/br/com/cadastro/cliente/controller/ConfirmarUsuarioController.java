package br.com.cadastro.cliente.controller;

import br.com.cadastro.cliente.domain.Usuario;
import br.com.cadastro.cliente.service.ConfirmarUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/confirmar-cadastro")
public class ConfirmarUsuarioController {

    @Autowired
    ConfirmarUsuarioService confirmarUsuarioService;

    @PostMapping("create")
    public Usuario createUsuario(@RequestBody Usuario usuario){
        return this.confirmarUsuarioService.createUsuario(usuario);
    }

}
