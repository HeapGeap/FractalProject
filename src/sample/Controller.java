package sample;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller {

    /*@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;*/

    @FXML
    private Button GenerationMenuButton;

    @FXML
    private Button ConfigMenuButton;

    @FXML
    private Button ExitMenuButton;
    @FXML
    private Button CreatorIdCard;
    @FXML
    private Scene ConfigScene;
    @FXML
    private Scene GenerationScene;
    @FXML
    void initialize() throws Exception{
        URL url1 = new File("src/WindowAfterConfigButton/Config.fxml").toURI().toURL();
        URL url2 = new File("src/WindowAfterGenericButton/Generation.fxml").toURI().toURL();
        Parent ConfigRoot = FXMLLoader.load(url1);
        Parent GenerationRoot = FXMLLoader.load(url2);
        ConfigScene = new Scene(ConfigRoot);
        GenerationScene = new Scene(GenerationRoot);

        Stage mainStage = Main.prim;
    ExitMenuButton.setOnAction(event -> {
        Stage stage = (Stage) ExitMenuButton.getScene().getWindow();
        stage.close();
    });//закрытие приложения

     ConfigMenuButton.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             mainStage.setScene(ConfigScene);
             mainStage.show();
         }
     });

     GenerationMenuButton.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             mainStage.setScene(GenerationScene);
             mainStage.show();
         }
     });
     CreatorIdCard.setOnAction(actionEvent -> {
        FXMLLoader CreatorsLoader = new FXMLLoader();
        CreatorsLoader.setLocation(getClass().getResource("/CreatorsInfo/Creators.fxml"));
         try {
             CreatorsLoader.load();
         } catch (IOException e) {
             e.printStackTrace();
         }
         Parent CreatorsRoot = CreatorsLoader.getRoot();
         Stage CreatorsStage = new Stage();
         CreatorsStage.setScene(new Scene(CreatorsRoot));
         CreatorsStage.showAndWait();
     });

    }
}
