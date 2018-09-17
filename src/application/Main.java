package application;

import application.View.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.prefs.Preferences;

public class Main extends Application {

    private Stage primaryStage;
    private Stage loginStage;

    private BorderPane rootLayout;

    private AnchorPane loginLayout;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Inventory Management");
        login();
        //initRootLayout();
        //showEmployeeOperationsView();
    }
    public void login(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("View/loginScreen.fxml"));
            loginLayout = loader.load();
            loginStage = new Stage();
            Scene scene = new Scene(loginLayout); //We are sending rootLayout to the Scene.
            loginStage.setScene(scene); //Set the scene in primary stage.
            loginStage.setResizable(false);
            //primaryStage.setFullScreen(true);

            LoginScreenController loginScreenController = loader.getController();
            loginScreenController.setMainApp(Main.this);

            loginStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("View/rootLayout.fxml"));
            rootLayout = loader.load();

            Scene scene = new Scene(rootLayout); //We are sending rootLayout to the Scene.
            primaryStage.setScene(scene); //Set the scene in primary stage.
            primaryStage.setFullScreen(true);

            RootLayoutController rootLayoutController = loader.getController();
            rootLayoutController.setMainApp(this);
            loginStage.hide();
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showScene(String sceneName) {
        try {
            FXMLLoader loader = new FXMLLoader();
            AnchorPane scenePane;
            switch (sceneName) {
                case "dashboard":
                    loader.setLocation(Main.class.getResource("View/dashboard.fxml"));
                    scenePane = (AnchorPane) loader.load();
                    DashboardController dashboardController = loader.getController();
                    dashboardController.setMainApp(this);
                    break;
                case "products":
                    loader.setLocation(Main.class.getResource("View/products.fxml"));
                    scenePane = (AnchorPane) loader.load();
                    ProductsController productsController = loader.getController();
                    productsController.setMainApp(this);
                    break;
                case "inventory":
                    loader.setLocation(Main.class.getResource("View/inventory.fxml"));
                    scenePane = (AnchorPane) loader.load();
                    InventoryController inventoryController = loader.getController();
                    inventoryController.setMainApp(this);
                    break;
                case "userManagement":
                    loader.setLocation(Main.class.getResource("View/userManagement.fxml"));
                    scenePane = (AnchorPane) loader.load();
                    UserManagementController userManagementController = loader.getController();
                    userManagementController.setMainApp(this);
                    break;
                case "reports":
                    loader.setLocation(Main.class.getResource("View/reports.fxml"));
                    scenePane = (AnchorPane) loader.load();
                    ReportsController reportsController = loader.getController();
                    reportsController.setMainApp(this);
                    break;
                default:
                    loader.setLocation(Main.class.getResource("View/dashboard.fxml"));
                    scenePane = (AnchorPane) loader.load();
                    DashboardController dashboardControllerDefault = loader.getController();
                    dashboardControllerDefault.setMainApp(this);
            }
            //loader.setLocation(Main.class.getResource("View/inputItemForm.fxml"));
            rootLayout.setCenter(scenePane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}