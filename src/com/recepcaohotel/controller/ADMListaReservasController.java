package com.recepcaohotel.controller;

import java.io.IOException;
import java.util.Collection;

import com.recepcaohotel.app.App;
import com.recepcaohotel.model.Reserva;
import com.recepcaohotel.model.Sistema;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class ADMListaReservasController {
    @FXML
    private VBox containerLista;

    @FXML
    private Button botaoAtualizar;

    @FXML
    private Button botaoVoltar;

    @FXML
    private void initialize() {
        Sistema s = App.getSystemInstance();
        // Inicializar a lista de reservas.
        atualizarListaDeReservas(s.consultarReservas());
    }

    @FXML
    private void atualizar() {
        Sistema s = App.getSystemInstance();
        // Inicializar a lista de reservas.
        atualizarListaDeReservas(s.consultarReservas());
    }

    @FXML
    private void voltar(ActionEvent event) {
        if (event.getSource() == botaoVoltar) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/PainelControle.fxml"));
                botaoVoltar.getScene().setRoot(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void atualizarListaDeReservas(Collection<Reserva> reservas) {
        if (containerLista == null) {
            return;
        }

        containerLista.getChildren().clear();

        for (Reserva reserva : reservas) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/fxml/ADMItemReserva.fxml"));
                Parent listItem = loader.load();
                ADMItemReservaController controller = loader.getController();
                controller.setReserva(reserva);
                containerLista.getChildren().add(listItem);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
