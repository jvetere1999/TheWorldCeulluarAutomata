package com.vetere.worldgui;

import com.vetere.worldgui.wrappers.Grid;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;
import org.kordamp.bootstrapfx.scene.layout.Panel;

import java.io.IOException;



public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        Grid grid = new Grid();
        Scene scene = new Scene(boostrapPanel(grid), GLOBAL.SCENE_WIDTH, GLOBAL.SCENE_WIDTH);
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        primaryStage.setTitle("ZA WORLD!");
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    Panel boostrapPanel(Grid grid) {
        Panel panel = new Panel("The World");
        panel.getStyleClass().add("panel-primary");
        BorderPane content = new BorderPane();
        content.setPadding(new Insets(20));
        Button update = new Button("Update World");
        update.getStyleClass().setAll("btn", "btn-danger");
        content.setBottom(update);
        content.setCenter(grid);
        panel.setBody(content);
        return panel;
    }
    public static void main(String[] args) {
        launch();
    }
}