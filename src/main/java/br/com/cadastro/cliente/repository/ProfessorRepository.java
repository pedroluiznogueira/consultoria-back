package br.com.cadastro.cliente.repository;

import br.com.cadastro.cliente.domain.Cliente;
import br.com.cadastro.cliente.domain.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository extends JpaRepository<Cliente, Long> {
    @Query("select n from Cliente n where n.nome like %?1%")
    List<Cliente> findServicoByTitulo(String nome);
}
