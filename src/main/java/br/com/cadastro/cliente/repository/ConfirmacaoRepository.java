package br.com.cadastro.cliente.repository;

import br.com.cadastro.cliente.domain.Confirmacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfirmacaoRepository extends JpaRepository<Confirmacao, Long> {
}
