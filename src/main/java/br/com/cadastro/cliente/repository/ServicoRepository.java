package br.com.cadastro.cliente.repository;
import br.com.cadastro.cliente.domain.Cliente;
import br.com.cadastro.cliente.domain.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
    @Query("select s from Servico s where s.titulo like %?1%")
    List<Servico> findServicoByTitulo(String titulo);

    @Query(value = "select * from Servico where cliente_id = ?1", nativeQuery = true)
    List<Servico> findServicoByCliente(Long id);
}
