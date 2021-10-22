package br.com.cadastro.cliente.service;

import br.com.cadastro.cliente.domain.StatusResponse;
import br.com.cadastro.cliente.domain.Usuario;
import br.com.cadastro.cliente.dto.DadosLogin;
import br.com.cadastro.cliente.exceptions.EmailExistenteException;
import br.com.cadastro.cliente.exceptions.LoginInvalidoException;
import br.com.cadastro.cliente.exceptions.TokenExpiradoException;
import br.com.cadastro.cliente.exceptions.TokenInvalidoException;
import br.com.cadastro.cliente.repository.UsuarioRepository;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TokenService tokenService;

    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario autenticar(Usuario usuario){
        Usuario user = usuarioRepository.findByEmail(usuario.getEmail()).orElseThrow(EmailExistenteException::new);

        if(usuario.getSenha().equals(user.getSenha())) {
            return user;
        }
        else {
            throw new LoginInvalidoException();
        }
    }

    public Usuario registrar(Usuario user){
        user.setToken(tokenService.gerarToken(user));
        return usuarioRepository.save(user);
    }

}
