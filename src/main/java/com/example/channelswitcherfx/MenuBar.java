package com.example.channelswitcherfx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class MenuBar {

    public  void ShowAll() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(MainMenu.class.getResource("all.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 460);
        MainMenu.getMainStage().setTitle("Menu");
        MainMenu.getMainStage().setScene(scene);
        MainMenu.getMainStage().show();
    }

    public  void ShowActive() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(MainMenu.class.getResource("active.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 460);
        MainMenu.getMainStage().setTitle("Menu");
        MainMenu.getMainStage().setScene(scene);
        MainMenu.getMainStage().show();
    }

    public  void ShowInactive() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(MainMenu.class.getResource("inactive.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 460);
        MainMenu.getMainStage().setTitle("Menu");
        MainMenu.getMainStage().setScene(scene);
        MainMenu.getMainStage().show();
    }

    public  void ShowChanger() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(MainMenu.class.getResource("changer.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 580);
        MainMenu.getMainStage().setTitle("Menu");
        MainMenu.getMainStage().setScene(scene);
        MainMenu.getMainStage().show();
    }


}
