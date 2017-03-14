/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author zaret
 */
public class MenuAdminController implements Initializable {
private Stage stagePrincipal;
private Main principal;

  public void setStagePrincipal(Stage stagePrincipal) {
    this.stagePrincipal = stagePrincipal;
  }

  @FXML
  private Button bAgregar;
  
  @FXML
  private Button bEditar;
  
  @FXML
  private Button bEliminar;
  
  @FXML
  public void agregarProducto(){
    try{
    FXMLLoader loader = new FXMLLoader(Main.class.getResource("Agregar.fxml"));
    AnchorPane venAgregar = (AnchorPane) loader.load();
    Stage agregar = new Stage();
    agregar.setTitle("Agregar");
    //agregar.initOwner(primaryStage);
    Scene scene = new Scene(venAgregar);
    agregar.setScene(scene);
    AgregarController controller = loader.getController();
    controller.setPrincipal(agregar);
    agregar.show();
    }catch(Exception ex){
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Información");
    alert.setHeaderText(null);
    alert.setContentText("Producto agregado");
    alert.showAndWait();
  }
  
  @FXML
  public void editarProducto(){
    
  }
  
  @FXML
  public void eliminarProducto(){
    
  }
  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // TODO
  }  
  
}
