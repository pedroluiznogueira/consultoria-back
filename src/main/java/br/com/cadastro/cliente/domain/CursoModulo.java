package br.com.cadastro.cliente.domain;

import javax.persistence.*;

@Entity
public class CursoModulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String conteudoPrincipal;
    private String imagem;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    public CursoModulo() {
    }

    public CursoModulo(Long id, String titulo, String conteudoPrincipal, String imagem, Curso curso) {
        this.id = id;
        this.titulo = titulo;
        this.conteudoPrincipal = conteudoPrincipal;
        this.imagem = imagem;
        this.curso = curso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudoPrincipal() {
        return conteudoPrincipal;
    }

    public void setConteudoPrincipal(String conteudoPrincipal) {
        this.conteudoPrincipal = conteudoPrincipal;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
