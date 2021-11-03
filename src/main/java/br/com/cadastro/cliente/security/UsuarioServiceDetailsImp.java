package br.com.cadastro.cliente.security;

import br.com.cadastro.cliente.domain.Usuario;
import br.com.cadastro.cliente.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceDetailsImp implements UserDetailsService {

    // preciso persistir o nome de usuario e a senha, verificar ou salvar
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(username);
        usuario
                .orElseThrow(
                        () -> new UsernameNotFoundException(username + "not found")
                );
        return usuario.map(UsuarioDetailsImp::new).get();
    }
}
