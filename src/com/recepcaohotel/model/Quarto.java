package com.recepcaohotel.model;

import java.io.Serializable;

public class Quarto implements Serializable {

    private int numero;
    private int qntdCamasCasal;
    private int qntdCamasSolteiro;
    private float diaria;
    private boolean isDisponivel;

    public Quarto() {
        this(0, 0, 0, 0);
    }

    public Quarto(int numero, int qntdCamasCasal, int qntdCamasSolteiro, float diaria) {
        this.numero = numero;
        this.qntdCamasCasal = qntdCamasCasal;
        this.qntdCamasSolteiro = qntdCamasSolteiro;
        this.diaria = diaria;
        this.isDisponivel = true;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setQntdCamasCasal(int qntdCamasCasal) {
        this.qntdCamasCasal = qntdCamasCasal;
    }

    public void setQntdCamasSolteiro(int qntdCamasSolteiro) {
        this.qntdCamasSolteiro = qntdCamasSolteiro;
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

    public int getQntdCamasSolteiro() {
        return qntdCamasSolteiro;
    }

    public float getDiaria() {
        return diaria;
    }

    public boolean getDisponivel() {
        return isDisponivel;
    }
}
