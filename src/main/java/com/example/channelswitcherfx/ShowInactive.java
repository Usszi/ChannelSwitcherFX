package com.example.channelswitcherfx;

import classes.Channels;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShowInactive {
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

        Channels ch8 = new Channels(8,"Skysport 8","Inactive");
        Channels ch9 = new Channels(9,"Skysport 9","Inactive");
        Channels ch10 = new Channels(10,"Skysport 10","Inactive");

        channelsList.add(ch8);
        channelsList.add(ch9);
        channelsList.add(ch10);

         /*   for (Channels c:channelsList) {
            if(channelsList.contains("Inactive")){
                channelsList.add(c);
            }
        }

      */

        // readChannels(channelsList);

        ObservableList<Channels> observableChannelList = FXCollections.observableList(channelsList);
        channelsTableView.setItems(observableChannelList);


    }

    public  void Return() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainMenu.class.getResource("main-menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        MainMenu.getMainStage().setTitle("Menu");
        MainMenu.getMainStage().setScene(scene);
        MainMenu.getMainStage().show();
    }





   /* private static void readChannels(List<Channels> channelsList) {
        File fileChannels = new File("dat/channels.txt");
        if (fileChannels.exists()) {

            try (FileReader channelReader = new FileReader(fileChannels);
                 BufferedReader lineReader = new BufferedReader(channelReader)) {
                String line;
                while ((line = lineReader.readLine()) != null) {
                    Integer id = Integer.parseInt(line);
                    String name = lineReader.readLine();
                    String status = lineReader.readLine();
                    Channels newChannel = new Channels(id,name,status);
                    channelsList.add(newChannel);
                }
            } catch (FileNotFoundException e) {
                System.out.println("The file does not exist!");
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    */
}
