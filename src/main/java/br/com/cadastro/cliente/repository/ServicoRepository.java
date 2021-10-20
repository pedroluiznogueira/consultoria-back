package br.com.cadastro.cliente.repository;
import br.com.cadastro.cliente.domain.Cliente;
import br.com.cadastro.cliente.domain.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
    @Query("select s from Servico s where s.titulo like %?1%")
    List<Servico> findServicoByTitulo(String titulo);
}
