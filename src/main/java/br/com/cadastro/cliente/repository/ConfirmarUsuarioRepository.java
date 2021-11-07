package br.com.cadastro.cliente.repository;

import br.com.cadastro.cliente.domain.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url= "http://localhost:8090/" , name = "usuario")
public interface ConfirmarUsuarioRepository {

    @PostMapping("usuario/create")
    Usuario createUsuario(@RequestBody Usuario usuario);

}
