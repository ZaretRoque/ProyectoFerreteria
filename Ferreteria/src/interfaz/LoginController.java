/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import ferreteria.ControlUsuarios;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author zaret
 */
public class LoginController implements Initializable {

  private Main principal; //Sirve para ligar el programa principal con las nuevas ventanas

  public Main getPrincipal() {
    return principal;
  }

  public void setPrincipal(Main principal) {
    this.principal = principal;
  }
  @FXML
  private TextField tUsuario;

  @FXML
  private PasswordField tContrasena;

  @FXML
  private Button bEntrar;

  @FXML
  public Label info;

  @FXML
  public Label buscando;

  @FXML//Se ejecuta cuando se presiona el botón Entrar
  public void iniciarSesion() {
    String usuario = tUsuario.getText();
    String contrasena = tContrasena.getText();
    
    if(usuario.length()>0 && contrasena.length()>0){
      
    buscando.setVisible(true);
    ControlUsuarios cu = new ControlUsuarios();
    boolean existe = cu.buscarUsuario(usuario, contrasena);
    
    if ((existe == true) && (usuario.equals("admin"))) {
      //Abre la ventana con las opciones para el administrador
      System.out.println("admin");
      principal.mostrarMenuAdmin();
      tUsuario.setText(null);
      tContrasena.setText(null);
      buscando.setVisible(false);
      
    } else if ((existe == true) && (usuario.equals("vendedor"))) {
      //Abre la ventana con las opciones para el vendedor
      System.out.println("vendedor");
      principal.mostrarMenuVendedor();
      tUsuario.setText(null);
      tContrasena.setText(null);
      buscando.setVisible(false);
      
    } else {
      //Mostrar mensaje al usuario
      Alert alert = new Alert(AlertType.ERROR);
      alert.setTitle("Error");
      alert.setHeaderText(null);
      alert.setContentText("Usuario o contraseña inválidos");
      alert.showAndWait();
    }
    }else{
      //Mostrar mensaje al usuario
      Alert alert = new Alert(AlertType.ERROR);
      alert.setTitle("Error");
      alert.setHeaderText(null);
      alert.setContentText("No has ingresado tus datos de usuario");
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
