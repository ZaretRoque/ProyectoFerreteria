
package ferreteria;

import java.io.Serializable;


/**
 * Define los atributos de un usuario
 * @author Zaret Roque
 * @version
 * Fecha: 11/03/2017, 07:40:53 PM
 */
public class Usuario implements Serializable{

  private String nombre;
  private String password;

  public Usuario(){
    
  }
  public Usuario(String nombre, String password) {
    this.nombre = nombre;
    this.password = password;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
  
  public String toString(){
    return nombre;
  }
  
}
