package WindowAfterGenericButton;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

import FractalsVisualisation.Dragon;
import FractalsVisualisation.Mandelbrot;
import FractalsVisualisation.SerpinskyTriangle;
import FractalsVisualisation.Snowflake;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.Main;

import javax.swing.*;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class GenerationController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ExitMenuButton;

    @FXML
    private Button HarterGenerationButton;

    @FXML
    private Button KochGenerationButton;

    @FXML
    private Button MandelbrotGenerationButton;

    @FXML
    private Button SerpinskyGenerationButton;

    @FXML
    void initialize() {
        ExitMenuButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                sample.Main.prim.setScene(sample.Main.MainScene);
                Main.prim.show();

            }
        });
      HarterGenerationButton.setOnAction(new EventHandler<ActionEvent>() {
          @Override
          public void handle(ActionEvent actionEvent) {
              JFrame window = new JFrame("Harter's Dragon");
              window.setSize(600, 600);
              window.setContentPane(new Dragon());
              window.setBackground(Color.BLACK);
              window.setResizable(false);
              window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
              window.setVisible(true);
          }
      });
      KochGenerationButton.setOnAction(new EventHandler<ActionEvent>() {
          @Override
          public void handle(ActionEvent actionEvent) {
              JFrame window = new JFrame("Koch Snowflake");
              window.setSize(650,650);
              window.setContentPane(new Snowflake());
              window.setBackground(Color.BLACK);
              window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
              window.setVisible(true);
          }
      });
      MandelbrotGenerationButton.setOnAction(new EventHandler<ActionEvent>() {
          @Override
          public void handle(ActionEvent actionEvent) {
              JFrame window = new JFrame("Mandelbrot Set");
              window.setSize(600,600);
              window.setContentPane(new Mandelbrot());
              window.setBackground(Color.white);
              window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
              window.setVisible(true);
          }
      });
      SerpinskyGenerationButton.setOnAction(new EventHandler<ActionEvent>() {
          @Override
          public void handle(ActionEvent actionEvent) {
              JFrame window = new JFrame("Serpinsky Triangle");
              window.setSize(600,600);
              window.setContentPane(new SerpinskyTriangle());
              window.setBackground(Color.BLACK);
              window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
              window.setVisible(true);
          }
      });
    }
}
