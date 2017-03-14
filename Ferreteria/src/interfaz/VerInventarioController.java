/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import ferreteria.Inventario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author zaret
 */
public class VerInventarioController implements Initializable {

  @FXML
  private ListView lista;
  
  @FXML
  private Button bVer;
  
  @FXML
  public void verInventario(ActionEvent e){
    Inventario inv = new Inventario();
    int tope = inv.getClave();
    ObservableList<String> prodLista = FXCollections.observableArrayList();
    for (int i = 0; i < tope; i++) {
      String producto = inv.mostrarInformacion(i);
      prodLista.add(producto);
      lista.setItems(prodLista);
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
