package application.View;

import application.Controller.DatabaseController;
import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;


public class LoginScreenController {


    @FXML
    private TextField userName = new TextField();

    @FXML
    private PasswordField password = new PasswordField();

    private Main main;
    public void setMainApp(Main mainApp){
        this.main = mainApp;
    }

    public LoginScreenController() {
        //this.main = mainApp;
    }

    @FXML
    public void login() throws SQLException {
        String user = userName.getText();
        String pwd = password.getText();
        System.out.println(user + " : " + pwd);
        DatabaseController controller = new DatabaseController();
        Connection connection = controller.getDbConnection();

        PreparedStatement statement = connection.prepareStatement("select * from users where user_id = ?");
        statement.setString(1,user);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next() && resultSet.getString(2).equals(pwd)){
            Preferences preferences = Preferences.userRoot().node("LoginCredentials");

            preferences.put("user",resultSet.getString(1));
            preferences.put("usertype",resultSet.getString(3));

            main.initRootLayout();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Error");
            alert.setHeaderText(null);
            alert.setContentText("User name and/or Password is invalid!");
            alert.showAndWait();
        }
        connection.close();
    }

}
