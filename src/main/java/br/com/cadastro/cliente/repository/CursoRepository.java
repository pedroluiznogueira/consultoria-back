package br.com.cadastro.cliente.repository;
import br.com.cadastro.cliente.domain.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    @Query("select c from Curso c where c.titulo like %?1%")
    List<Curso> findCursoByTitulo(String titulo);

    @Query(value = "select * from Curso where professor_id = ?1", nativeQuery = true)
    List<Curso> findCursoByProfessor(Long id);

    List<Long> findCursosIdByWishlistId(Long id);
}
