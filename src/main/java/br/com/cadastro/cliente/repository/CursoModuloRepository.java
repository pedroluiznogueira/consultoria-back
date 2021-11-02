package br.com.cadastro.cliente.repository;
import br.com.cadastro.cliente.domain.CursoModulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoModuloRepository extends JpaRepository<CursoModulo, Long> {

    @Query(value = "select * from curso_modulo where curso_id = ?1", nativeQuery = true)
    List<CursoModulo> findCursoModuloByCurso(Long id);
}
