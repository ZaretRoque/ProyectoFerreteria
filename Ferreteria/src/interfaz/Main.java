/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author zaret
 */
public class Main extends Application {

  private Stage primaryStage;
  private AnchorPane page;

  @Override
  public void start(Stage primaryStage) {
    this.primaryStage = primaryStage;
    mostrarVentanaLogin();
  }

  public void mostrarVentanaLogin() {
    try {
      FXMLLoader loader = new FXMLLoader(Main.class.getResource("Login.fxml"));
      page = (AnchorPane) loader.load();
      Scene scene = new Scene(page);
      primaryStage.setScene(scene);
      primaryStage.setTitle("Login");
      LoginController login = loader.getController();
      login.setPrincipal(this);
      login.info.setVisible(false);
      login.buscando.setVisible(false);
      primaryStage.show();
    } catch (Exception ex) {
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public void mostrarMenuAdmin(){
    try{
    FXMLLoader loader = new FXMLLoader(Main.class.getResource("VentanaAdmin.fxml"));
    AnchorPane ventanaAdmin = (AnchorPane) loader.load();
    Stage ventana = new Stage();
    ventana.setTitle("Administrador");
    ventana.initOwner(primaryStage);
    Scene scene = new Scene(ventanaAdmin);
    ventana.setScene(scene);
    VentanaAdminController controller = loader.getController();
    controller.setStagePrincipal(ventana);
    ventana.show();
    }catch(Exception ex){
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  public void mostrarMenuVendedor(){
    try{
    FXMLLoader loader = new FXMLLoader(Main.class.getResource("VentanaVendedor.fxml"));
    AnchorPane ventanaVend = (AnchorPane) loader.load();
    Stage ventana = new Stage();
    ventana.setTitle("Administrador");
    ventana.initOwner(primaryStage);
    Scene scene = new Scene(ventanaVend);
    ventana.setScene(scene);
    VentanaVendedorController controller = loader.getController();
    controller.setStagePrincipal(ventana);
    ventana.show();
    }catch(Exception ex){
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }

}
