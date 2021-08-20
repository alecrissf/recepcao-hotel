package com.recepcaohotel.model;

public class Admin {
    private String nomeUsuario;
    private String senha;

    public Admin(String nomeUsuario, String senha) {
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public boolean compararSenha(String senhaParaComparar) {
        return this.senha.equals(senhaParaComparar);
    }
}
