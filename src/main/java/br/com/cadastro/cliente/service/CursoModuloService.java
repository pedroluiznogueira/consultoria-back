package br.com.cadastro.cliente.service;

import br.com.cadastro.cliente.domain.CursoModulo;
import br.com.cadastro.cliente.repository.CursoModuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoModuloService {

    @Autowired
    CursoModuloRepository cursoModuloRepository;

    public CursoModulo insertCursoModulo(CursoModulo newCursoModulo) {
        return cursoModuloRepository.save(newCursoModulo);
    }
}
