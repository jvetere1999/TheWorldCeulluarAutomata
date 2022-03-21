package com.jvetere.worldtestingui;




import com.jvetere.worldtestingui.wrappers.Grid;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;



public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Grid grid = new Grid();
        Scene scene = new Scene(grid, 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}