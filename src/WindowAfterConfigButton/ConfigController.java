package WindowAfterConfigButton;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import sample.Main;

public class ConfigController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView ConfigEndingPicture;

    @FXML
    void initialize() {
       ConfigEndingPicture.setOnMouseClicked(new EventHandler<MouseEvent>() {
           @Override
           public void handle(MouseEvent mouseEvent) {
               Main.prim.setScene(Main.MainScene);
               Main.prim.show();
           }
       });

    }
}
