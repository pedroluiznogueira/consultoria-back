package br.com.cadastro.cliente.domain;

public class CursopedidoDTO {

    private Curso curso;
    private Pedido pedido;

    public CursopedidoDTO() {
    }

    public CursopedidoDTO(Curso curso, Pedido pedido) {
        this.curso = curso;
        this.pedido = pedido;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
