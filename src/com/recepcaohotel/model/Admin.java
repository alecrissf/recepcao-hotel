package com.recepcaohotel.model;

public class Admin {
    private String nomeUsuario;
    private String senha;

    boolean isAutenticado(String nomeUsuario, String senha){
        //TODO: Melhorar essa lógica do usuário para verificar login
        if(nomeUsuario == this.getNomeUsuario() && senha == this.senha){
            return true;
        }
        return false;
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
}
