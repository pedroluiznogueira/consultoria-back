package br.com.cadastro.cliente.repository;

import br.com.cadastro.cliente.domain.CursoModulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoModuloRepository extends JpaRepository<CursoModulo, Long> {
}
