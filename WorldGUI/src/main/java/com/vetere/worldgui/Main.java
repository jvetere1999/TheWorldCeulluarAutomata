package com.vetere.worldgui;

import com.jvetere.worldlogic.main.GLOBAL;
import com.vetere.worldgui.wrappers.Grid;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;
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
        System.out.println("HereGUI");
    }

    Panel boostrapPanel(Grid grid) {
        Panel panel = new Panel("The World");
        panel.getStyleClass().add("panel-primary");

        BorderPane content = new BorderPane();
        content.setPadding(new Insets(20));

        Button update = new Button("Step 1 tick");
        update.setOnAction( (e) -> {
            grid.update();
        });
        update.getStyleClass().setAll("btn", "btn-danger");

        Timeline fiveSecondsWonder = new Timeline(
                new KeyFrame(Duration.millis(GLOBAL.SECONDS_PER_UPDATE),
                        event -> {
                            grid.update();
                        }));

        Button play = new Button("Play");
        play.setOnAction( (e) -> {
            if(!update.isDisabled()) {
                update.setDisable(true);
                play.setText("Stop");
                fiveSecondsWonder.setCycleCount(Timeline.INDEFINITE);
                fiveSecondsWonder.play();
            }
            else {
                update.setDisable(false);
                play.setText("Play");
                fiveSecondsWonder.stop();
            }
        });

        Button stop = new Button("Stop");
        stop.getStyleClass().setAll("btn", "btn-danger");

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10));
        hBox.getChildren().addAll(update, play);
        content.setBottom(hBox);
        content.setCenter(grid);
        panel.setBody(content);
        return panel;
    }
    public static void main(String[] args) {
        launch();
    }
}