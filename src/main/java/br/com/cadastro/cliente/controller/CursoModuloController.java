package br.com.cadastro.cliente.controller;
import br.com.cadastro.cliente.domain.CursoModulo;
import br.com.cadastro.cliente.service.CursoModuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
