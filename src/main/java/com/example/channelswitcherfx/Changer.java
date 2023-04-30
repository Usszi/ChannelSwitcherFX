package com.example.channelswitcherfx;

import classes.Channels;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Changer {
    /*ObservableList<String> choiceList = FXCollections.observableArrayList("Skysport 1","Skysport 2","Skysport 3","Skysport 4","Skysport 5","Skysport 6","Skysport 7","Skysport 8","Skysport 9","Skysport 10");
   & @FXML
    private ChoiceBox choice;


    @FXML
    private Button active ;
         */
    @FXML
    private TableView<Channels> channelsTableView;

    @FXML
    private TableColumn<Channels,String> IdTableColumn;

    @FXML
    private TableColumn<Channels,String> nameTableColumn;

    @FXML
    private TableColumn<Channels,String> statusTableColumn;

    @FXML
    private TextField id;
    @FXML
    private TextField change;

    @FXML
    void changer(ActionEvent event) {
        ObservableList<Channels> currentTableData = channelsTableView.getItems();
        int currentChannelid = Integer.parseInt(id.getText());

        for (Channels channel : currentTableData) {
           if (channel.getId() == currentChannelid) {
                channel.setStatus(change.getText());
                channelsTableView.setItems(currentTableData);
                channelsTableView.refresh();
                break;
           }
        }
    }

    @FXML
    void rowClicked(MouseEvent event) {
        Channels clickedChannel = channelsTableView.getSelectionModel().getSelectedItem();
        id.setText(String.valueOf(clickedChannel.getId()));
        change.setText(String.valueOf(clickedChannel.getStatus()));
    }




    @FXML
    public void initialize(){
      /*  choice.setValue("Skysport 1");
        choice.setItems(choiceList);

        active.setOnAction(e -> getActive(choice));
        inactive.setOnAction(e -> getActive(choice));

       */

     //IdTableColumn.setCellValueFactory(new PropertyValueFactory<Channels, Integer>("id"));
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
        Channels ch8 = new Channels(8,"Skysport 8","Inactive");
        Channels ch9 = new Channels(9,"Skysport 9","Inactive");
        Channels ch10 = new Channels(10,"Skysport 10","Inactive");

        channelsList.add(ch1);
        channelsList.add(ch2);
        channelsList.add(ch3);
        channelsList.add(ch4);
        channelsList.add(ch5);
        channelsList.add(ch6);
        channelsList.add(ch7);
        channelsList.add(ch8);
        channelsList.add(ch9);
        channelsList.add(ch10);

        /*
   if (choiceList.get(1).equals("Skysport 2")){  // moze i .contains
        channelsList.get(1).setStatus("Inactive");
         }

         */
     ObservableList<Channels> observableChannelList = FXCollections.observableList(channelsList);
     channelsTableView.setItems(observableChannelList);

    }
/*
    public void getActive(ChoiceBox<String> choiceBox){
        String c1 = choiceBox.getValue();
        System.out.println(c1);

       // List<Channels> channelsList1 = new ArrayList<>();
       // if(choiceList.get(0).contains("Skysport 1")){
       //     channelsList1.get(0).setStatus("Inactive");
       //     System.out.println(channelsList1.get(0).getStatus());
      //  }
    }


    public void ActiveChanger(TableColumn.CellEditEvent edited){

      /*  List<Channels> channelsList = new ArrayList<>();
        if (choiceList.get(1).equals("Skysport 2")){  // moze i .contains
            Channels c1 = channelsTableView.getSelectionModel().getSelectedItem();
            c1.setStatus("Inactive");
            channelsList.get(1).setStatus("Inactive");
        }


       Channels c1 = channelsTableView.getSelectionModel().getSelectedItem();
        c1.setStatus(edited.getNewValue().toString());



       List<Channels> channelsList = new ArrayList<>();

        Channels ch1 = new Channels(1,"Skysport 1","Active");
        Channels ch2 = new Channels(2,"Skysport 2","Active");
        Channels ch3 = new Channels(3,"Skysport 3","Active");
        Channels ch4 = new Channels(4,"Skysport 4","Active");
        Channels ch5 = new Channels(5,"Skysport 5","Active");
        Channels ch6 = new Channels(6,"Skysport 6","Active");
        Channels ch7 = new Channels(7,"Skysport 7","Active");
        Channels ch8 = new Channels(8,"Skysport 8","Inactive");
        Channels ch9 = new Channels(9,"Skysport 9","Inactive");
        Channels ch10 = new Channels(10,"Skysport 10","Inactive");

        channelsList.add(ch1);
        channelsList.add(ch2);
        channelsList.add(ch3);
        channelsList.add(ch4);
        channelsList.add(ch5);
        channelsList.add(ch6);
        channelsList.add(ch7);
        channelsList.add(ch8);
        channelsList.add(ch9);
        channelsList.add(ch10);



        if(choiceList.get(0).contains("Skysport 1")){
            channelsList.get(ch1.getId()).setStatus("Inactive");
            channelsList.get(0).setStatus("Inactive");
            System.out.println(channelsList.get(1).getStatus());
        }

        if(choiceList.contains("Skysport 2")){
            channelsList.get(2).setStatus("Active");
        }

        if(choiceList.contains("Skysport 3")){
            channelsList.get(3).setStatus("Active");
        }

        if(choiceList.contains("Skysport 4")){
            channelsList.get(4).setStatus("Active");
        }

        if(choiceList.contains("Skysport 5")){
            channelsList.get(5).setStatus("Active");
        }

        if(choiceList.contains("Skysport 6")){
            channelsList.get(6).setStatus("Active");
        }

        if(choiceList.contains("Skysport 7")){
            channelsList.get(7).setStatus("Active");
        }

        if(choiceList.contains("Skysport 8")){
            channelsList.get(8).setStatus("Active");
        }

        if(choiceList.contains("Skysport 9")){
            channelsList.get(9).setStatus("Active");
        }

        if(choiceList.contains("Skysport 10")){
            channelsList.get(10).setStatus("Active");
        }

        ObservableList<Channels> observableChannelList = FXCollections.observableList(channelsList);
       channelsTableView.setItems(observableChannelList);


    }

    public void InactiveChanger(){
        List<Channels> channelsList = new ArrayList<>();

        Channels ch1 = new Channels(1,"Skysport 1","Active");
        Channels ch2 = new Channels(2,"Skysport 2","Active");
        Channels ch3 = new Channels(3,"Skysport 3","Active");
        Channels ch4 = new Channels(4,"Skysport 4","Active");
        Channels ch5 = new Channels(5,"Skysport 5","Active");
        Channels ch6 = new Channels(6,"Skysport 6","Active");
        Channels ch7 = new Channels(7,"Skysport 7","Active");
        Channels ch8 = new Channels(8,"Skysport 8","Inactive");
        Channels ch9 = new Channels(9,"Skysport 9","Inactive");
        Channels ch10 = new Channels(10,"Skysport 10","Inactive");

        channelsList.add(ch1);
        channelsList.add(ch2);
        channelsList.add(ch3);
        channelsList.add(ch4);
        channelsList.add(ch5);
        channelsList.add(ch6);
        channelsList.add(ch7);
        channelsList.add(ch8);
        channelsList.add(ch9);
        channelsList.add(ch10);

        if(choiceList.contains("Skysport 1")){
            channelsList.get(1).setStatus("Inactive");
            System.out.println(channelsList.get(1).getStatus());
        }

        if(choiceList.contains("Skysport 2")){
            channelsList.get(2).setStatus("Inactive");
        }

        if(choiceList.contains("Skysport 3")){
            channelsList.get(3).setStatus("Inactive");
        }

        if(choiceList.contains("Skysport 4")){
            channelsList.get(4).setStatus("Inactive");
        }

        if(choiceList.contains("Skysport 5")){
            channelsList.get(5).setStatus("Inactive");
        }

        if(choiceList.contains("Skysport 6")){
            channelsList.get(6).setStatus("Inactive");
        }

        if(choiceList.contains("Skysport 7")){
            channelsList.get(7).setStatus("Inactive");
        }

        if(choiceList.contains("Skysport 8")){
            channelsList.get(8).setStatus("Inactive");
        }

        if(choiceList.contains("Skysport 9")){
            channelsList.get(9).setStatus("Inactive");
        }

        if(choiceList.contains("Skysport 10")){
            channelsList.get(10).setStatus("Inactive");
        }

      //  ObservableList<Channels> observableChannelList = FXCollections.observableList(channelsList);
     //   channelsTableView.setItems(observableChannelList);

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
