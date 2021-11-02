package br.com.cadastro.cliente.controller;
import br.com.cadastro.cliente.domain.Curso;
import br.com.cadastro.cliente.domain.CursoModulo;
import br.com.cadastro.cliente.domain.Professor;
import br.com.cadastro.cliente.service.CursoModuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso/modulo")
@CrossOrigin("*")
public class CursoModuloController {

    @Autowired
    CursoModuloService cursoModuloService;

    @PostMapping("create")
    public ResponseEntity<CursoModulo> insertCursoModulo(@RequestBody CursoModulo newCursoModulo) {
        CursoModulo cursoModulo = cursoModuloService.insertCursoModulo(newCursoModulo);
        return new ResponseEntity<CursoModulo>(cursoModulo, HttpStatus.OK);
    }

    @PostMapping("find-by-curso")
    public ResponseEntity<List<CursoModulo>> findByCurso(@RequestBody Curso curso){
        List<CursoModulo> cursoModulos = cursoModuloService.getCursoModuloByCurso(curso.getId());
        return new ResponseEntity<List<CursoModulo>>(cursoModulos, HttpStatus.OK);
    }

}
