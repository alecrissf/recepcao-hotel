package com.recepcaohotel.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HomeController {

    @FXML
    private Button botaoNovaReserva;

    @FXML
    private Button botaoFazerCheckout;

    @FXML
    private Button botaoLogarAdmin;

    @FXML
    private void novaReserva() {
        // TODO: fazer a lógica de trocar de página.
        System.out.println("Nova Reserva");
    }

    @FXML
    private void fazerCheckout() {
        // TODO: fazer a lógica de trocar de página.
        System.out.println("Fazer Checkout");
    }

    @FXML
    private void logarAdmin() {
        // TODO: fazer a lógica de trocar de página.
        System.out.println("Logar Admin");
    }

}
