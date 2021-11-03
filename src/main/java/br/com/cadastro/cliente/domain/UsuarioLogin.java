package br.com.cadastro.cliente.domain;

public class UsuarioLogin {

    private String nome;
    private String email;
    private String senha;
    private String token;
    private String imagem;

    public UsuarioLogin() {
    }

    public UsuarioLogin(String nome, String email, String senha, String token) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.token = token;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
