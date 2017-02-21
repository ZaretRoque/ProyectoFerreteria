/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria;

import java.util.Scanner;

/**
 *
 * @author Zaret Sahar Jahzeel Roque
 * @version 1.0
 */
public class Teclado {

  private Scanner sc;

  /**
   * Inicializa un objeto Scanner usando la entrada estándar
   */
  public Teclado() {
    sc = new Scanner(System.in);
  }

  /**
   * Este método lee un entero
   *
   * @return Regresa un valor de tipo entero con el número leído
   */
  public int leerEntero() {
    return sc.nextInt();
  }

  /**
   * Este método lee un double
   *
   * @return Regresa un valor de tipo entero con el número leído
   */
  public double leerDouble() {
    return sc.nextDouble();
  }
  
  /**
   * Lee un String
   * @return Regresa el String leído
   */
  public String leerString(){
    return sc.nextLine();
  }
  
  /**
   * Limpia el buffer de entrada
   */
  public void limpiarBuffer(){
    sc.nextLine();
  }

}
