package application.View;

import application.Main;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.util.prefs.Preferences;

public class RootLayoutController {

    @FXML
    private Label welcomeMessage = new Label();
    @FXML
    private HBox dashboard = new HBox();
    @FXML
    private HBox products = new HBox();
    @FXML
    private HBox inventory = new HBox();
    @FXML
    private HBox userMangement = new HBox();
    @FXML
    private HBox reports = new HBox();

    private String userName = "Ridham Kothari";

    @FXML
    private void logout(){

    }


    public RootLayoutController(){
        //this.userName = userName;
    }

    private Preferences preferences = Preferences.userRoot().node("LoginCredentials");
    private String user = preferences.get("user", "USER");

    @FXML
    private void initialize(){
        welcomeMessage.setText("Welcome, \n" + user.toUpperCase());
        dashboard.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //System.out.println("Clicked yeah!!");
                main.showScene("dashboard");
            }
        });
        products.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //System.out.println("Clicked yeah!!");
                main.showScene("products");
            }
        });
        inventory.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //System.out.println("Clicked yeah!!");
                main.showScene("inventory");
            }
        });
        userMangement.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //System.out.println("Clicked yeah!!");
                main.showScene("userManagement");
            }
        });
        reports.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //System.out.println("Clicked yeah!!");
                main.showScene("reports");
            }
        });

    }
    private Main main;
    public void setMainApp(Main mainApp){
        this.main = mainApp;
    }


}
