package com.recepcaohotel.model;

public class DetalhesEstadia {
    private float servicoDeQuarto;
    private float frigobar;

    DetalhesEstadia() {
        this.servicoDeQuarto = 0;
        this.frigobar = 0;
    }

    // Ir somando todos os serviços que forem inseridos
    void addServicoDeQuarto(float servicoDeQuarto, int qntdServicoDeQuarto) {
        this.servicoDeQuarto += servicoDeQuarto * qntdServicoDeQuarto;
        if (this.servicoDeQuarto < 0) {
            this.servicoDeQuarto = 0;
        }
    }

    // Ir somando todos os custos do frigobar que forem inseridos
    void addFrigobar(float frigobar, int qntdFrigobar) {
        this.frigobar += frigobar * qntdFrigobar;
        if (this.frigobar < 0) {
            this.frigobar = 0;
        }
    }

    public float getFrigobar() {
        return frigobar;
    }

    public float getServicoDeQuarto() {
        return servicoDeQuarto;
    }
}
