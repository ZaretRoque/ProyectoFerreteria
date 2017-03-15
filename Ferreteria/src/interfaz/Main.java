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
  
/**
 * Permite mostrar la ventana de Login al arrancar el programa
 */
  public void mostrarVentanaLogin() {
    try {
      FXMLLoader loader = new FXMLLoader(Main.class.getResource("Login.fxml"));
      page = (AnchorPane) loader.load();
      Scene scene = new Scene(page);
      primaryStage.setScene(scene);
      primaryStage.setTitle("Login");
      LoginController login = loader.getController(); //carga el controlador de la ventana de Login
      login.setPrincipal(this);//Le dice a la ventana de login a qué Stage pertenece
      login.info.setVisible(false);
      login.buscando.setVisible(false);
      primaryStage.show();
    } catch (Exception ex) {
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  /**
   * Permite mostrar la ventana con las opciones del administrador
   */
  public void mostrarMenuAdmin(){
    try{
    FXMLLoader loader = new FXMLLoader(Main.class.getResource("VentanaAdmin.fxml"));
    AnchorPane ventanaAdmin = (AnchorPane) loader.load();
    Stage ventana = new Stage();
    ventana.setTitle("Administrador");
    ventana.initOwner(primaryStage);
    Scene scene = new Scene(ventanaAdmin);
    ventana.setScene(scene);
    VentanaAdminController controller = loader.getController(); //carga controlador de la ventana
    controller.setStagePrincipal(ventana);//Asigna el Stage a la ventana
    ventana.show();
    }catch(Exception ex){
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  /**
   * Permite mostrar la ventana con las opciones para el vendor
   */
  public void mostrarMenuVendedor(){
    try{
    FXMLLoader loader = new FXMLLoader(Main.class.getResource("VentanaVendedor.fxml"));
    AnchorPane ventanaVend = (AnchorPane) loader.load();
    Stage ventana = new Stage();
    ventana.setTitle("Administrador");
    ventana.initOwner(primaryStage);
    Scene scene = new Scene(ventanaVend);
    ventana.setScene(scene);
    VenderController controller = loader.getController(); //Carga el controlador de otra clase con 
                                                          //fin de reutilizar código
    controller.setStagePrincipal(ventana);//Asigna el Stage
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
