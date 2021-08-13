package com.recepcaohotel.model;

public class Quarto {

    private int numero;
    private int qntdCamasCasal;
    private int qntdCamasSolteira;
    private float diaria;
    private boolean isDisponivel;

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setQntdCamasCasal(int qntdCamasCasal) {
        this.qntdCamasCasal = qntdCamasCasal;
    }

    public void setQntdCamasSolteira(int qntdCamasSolteira) {
        this.qntdCamasSolteira = qntdCamasSolteira;
    }

    public void setDiaria(float diaria) {
        this.diaria = diaria;
    }

    public void setDisponivel(boolean isDisponivel) {
        this.isDisponivel = isDisponivel;
    }

    public int getNumero() {
        return numero;
    }

    public int getQntdCamasCasal() {
        return qntdCamasCasal;
    }

    public int getQntdCamasSolteira() {
        return qntdCamasSolteira;
    }

    public float getDiaria() {
        return diaria;
    }

    public boolean getDisponivel() {
        return isDisponivel;
    }
}
