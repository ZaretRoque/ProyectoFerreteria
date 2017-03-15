/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import ferreteria.Inventario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author zaret
 */
public class EliminarController implements Initializable {

  @FXML
  private TextField tClave;

  @FXML
  private Button bEliminar;

  @FXML//Se ejecuta cuando se presiona el botón Eliminar
  public void eliminar() {
    
    String clave = tClave.getText();
    
    if(clave.length()>0){
      
    Inventario inv = new Inventario();
    int indice = inv.buscarClave(clave);
    inv.eliminarElemento(indice);
    //Mostrar mensaje al usuario
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Información");
    alert.setHeaderText(null);
    alert.setContentText("Elemento eliminado");
    alert.showAndWait();
    
    }else{
      //Mostrar mensaje al usuario
      Alert alert = new Alert(AlertType.ERROR);
      alert.setTitle("Error");
      alert.setHeaderText(null);
      alert.setContentText("Ingresa clave de producto");
      alert.showAndWait();
    }
  }

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // TODO
  }

}
