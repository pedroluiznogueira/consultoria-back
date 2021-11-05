package br.com.cadastro.cliente.service;

import br.com.cadastro.cliente.domain.*;
import br.com.cadastro.cliente.repository.ProfessorRepository;
import br.com.cadastro.cliente.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CursoService {

    @Autowired
    CursoRepository cursoRepository;
    @Autowired
    ProfessorRepository professorRepository;

    // todos os cursos
    public List<Curso> getCursos(){
        return cursoRepository.findAll();
    }

    // curso por id
    public Curso findCursoById(Long id){
        return cursoRepository.findById(id).get();
    }

    // encontrar os cursos por professor
    public List<Curso> getCursosByProfessorId(Long id){
        return cursoRepository.findCursoByProfessor(id);
    }

    // cadastrar curso
    public Curso insertCurso(Curso novoCurso){
        cursoRepository.save(novoCurso);
        return novoCurso;
    }

    // excluir curso
    public StatusResponse dropCurso(Long idServico){

        cursoRepository.deleteById(idServico);
        return new StatusResponse("Serviço deletado com sucesso", "sucesso");
    }

    // atualizar curso
    public StatusResponse updateCurso(Curso novoCurso) {
        Curso curso = cursoRepository.findById(novoCurso.getId()).get();

        if (novoCurso.getTitulo() == "" || novoCurso.getDescricao() == "" || novoCurso.getValor() == null){
            return new StatusResponse("Dados invalidos", "erro");
        }

        curso.setTitulo(novoCurso.getTitulo());
        curso.setDescricao(novoCurso.getDescricao());
        curso.setValor(novoCurso.getValor());

        cursoRepository.save(curso);
        return new StatusResponse("Serviço alterado com sucesso", "sucesso");
    }

    // fazer pesquisa por cursos
    public List<Curso> pesquisar(String titulo) {
        return cursoRepository.findCursoByTitulo(titulo);
    }

    public StatusResponse addCursoWish(Cursowishlist cw) {
        cw.getWishlist().getCursos().add(cw.getCurso());
        cw.getCurso().getWishlists().add(cw.getWishlist());

        cursoRepository.save(cw.getCurso());
        return new StatusResponse("Curso adicionado à Wishlist", "sucesso");
    }

    public List<Curso> getCursosWishAll(List<Long> idsCursos) {
        List<Curso> cursos = new ArrayList<>();

        for (Long id : idsCursos) {
            Curso curso = cursoRepository.findCursoById(id);
            cursos.add(curso);
        }
        return cursos;
    }

    public List<Curso> cursosByCursos(List<Curso> cursos) {
        List<Curso> cursosDb = new ArrayList<>();

        for (Curso curso: cursos){
            cursosDb.add(cursoRepository.findCursoById(curso.getId()));
        }

        return cursosDb;
    }

    public StatusResponse addCursoPedido(CursopedidoDTO cpDTO) {

        cpDTO.getPedido().getCursos().add(cpDTO.getCurso());
        cpDTO.getCurso().getPedidos().add(cpDTO.getPedido());

        cursoRepository.save(cpDTO.getCurso());
        return new StatusResponse("Curso adicionado ao Pedido", "sucesso");
    }


    public List<Long> findCursosIdByPedidosIds(List<Pedido> pedidos) {
        List<Long> ids = new ArrayList<>();

        for (Pedido pedido : pedidos) {
            List<Long> listaId = cursoRepository.findCursosIdByPedidoId(pedido.getId());
            for (Long id : listaId) {
                ids.add(id);
            }
        }

        return ids;
    }

    public List<Curso> getCursosPedidosAll(List<Long> idsCursos) {
        List<Curso> cursos = new ArrayList<>();

        for (Long id : idsCursos) {
            Curso curso = cursoRepository.findCursoById(id);
            cursos.add(curso);
        }
        return cursos;
    }
}
