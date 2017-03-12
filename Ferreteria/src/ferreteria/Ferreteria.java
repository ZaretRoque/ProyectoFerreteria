/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria;

/**
 *
 * @author zaret
 */
public class Ferreteria {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // TODO code application logic here
    //MensajesUsuario mu = new MensajesUsuario();
    MensajesUsuario mu = new MensajesUsuario();
    int op;
    do{
            
            mu.menu();
            op=mu.leerOpcion();
            mu.realizarOpcion(op);
        }while(op != 0);
  }
  
}
