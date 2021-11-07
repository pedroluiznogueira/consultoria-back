package br.com.cadastro.cliente.service;

import br.com.cadastro.cliente.domain.Usuario;
import br.com.cadastro.cliente.repository.ConfirmarUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfirmarUsuarioService {

    @Autowired
    ConfirmarUsuarioRepository confirmarUsuarioRepository;

    public Usuario createUsuario(Usuario usuario){
        return this.confirmarUsuarioRepository.createUsuario(usuario);
    }

}
