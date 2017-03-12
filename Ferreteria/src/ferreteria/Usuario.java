
package ferreteria;


/**
 *
 * @author Zaret Roque
 * @version
 * Fecha: 11/03/2017, 07:40:53 PM
 */
public class Usuario {

  private String nombre;
  private String password;

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
  
  
  
}
