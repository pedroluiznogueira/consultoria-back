package br.com.cadastro.cliente.domain;

import java.util.List;

public class Cursopedido {

    private List<Curso> cursos;
    private Pedido pedido;

    public Cursopedido() {
    }

    public Cursopedido(List<Curso> cursos, Pedido pedido) {
        this.cursos = cursos;
        this.pedido = pedido;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
