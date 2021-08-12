package com.recepcaohotel.app;

import java.io.IOException;

import com.recepcaohotel.model.Sistema;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public static final int PREF_APP_WIDTH = 1200;
    public static final int PREF_APP_HEIGHT = 720;

    private static Sistema systemInstance = null;

    public static void main(String[] args) {
        // TODO: adaptar quando a classe Sistema for implementada.
        systemInstance = new Sistema();
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/Home.fxml"));
            Scene scene = new Scene(root, PREF_APP_WIDTH, PREF_APP_HEIGHT);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }

        stage.setTitle("Recepção do Hotel");
        stage.show();
    }

    public static Sistema getSystemInstance() {
        return systemInstance;
    }
}
