package com.example.channelswitcherfx;

import classes.Channels;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ShowActive {
    @FXML
    private TableView<Channels> channelsTableView;

    @FXML
    private TableColumn<Channels,String> IdTableColumn;

    @FXML
    private TableColumn<Channels,String> nameTableColumn;

    @FXML
    private TableColumn<Channels,String> statusTableColumn;

    public void initialize(){

        IdTableColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId().toString()));

        nameTableColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));

        statusTableColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStatus()));

        List<Channels> channelsList = new ArrayList<>();

        Channels ch1 = new Channels(1,"Skysport 1","Active");
        Channels ch2 = new Channels(2,"Skysport 2","Active");
        Channels ch3 = new Channels(3,"Skysport 3","Active");
        Channels ch4 = new Channels(4,"Skysport 4","Active");
        Channels ch5 = new Channels(5,"Skysport 5","Active");
        Channels ch6 = new Channels(6,"Skysport 6","Active");
        Channels ch7 = new Channels(7,"Skysport 7","Active");
/*
        ch1.setStatus("Inactive");
        if(ch1.getStatus().equals("Active")){
            channelsList.add(ch1);
        }

 */
        channelsList.add(ch1);
        channelsList.add(ch2);
        channelsList.add(ch3);
        channelsList.add(ch4);
        channelsList.add(ch5);
        channelsList.add(ch6);
        channelsList.add(ch7);


       //RADI channelsList.get(ch1.getId()).setStatus("Inactive");

  /*
       for (Channels c:channelsList) {
            if(channelsList.contains("Active")){
                channelsList.add(c);
            }
        }

*/

        ObservableList<Channels> observableChannelList = FXCollections.observableList(channelsList);
        channelsTableView.setItems(observableChannelList);


       // channelsList.get(1).setStatus("Inactive");
    }

//mozda radi
    /*
    public void Return() {
        Channels ch1 = new Channels(1,"Skysport 1","Active");
        ch1.setStatus("Inactive");
        }
    }

     */

    public  void Return() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainMenu.class.getResource("main-menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        MainMenu.getMainStage().setTitle("Menu");
        MainMenu.getMainStage().setScene(scene);
        MainMenu.getMainStage().show();
    }


}

