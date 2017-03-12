
package ferreteria;

import java.util.ArrayList;


/**
 *
 * @author Zaret Roque
 * @version
 * Fecha: 11/03/2017, 07:47:59 PM
 */
public class ControlUsuarios {
Archivo arch = new Archivo();
ArrayList<Usuario> usuarios;

/**
 * Verifica si existe un archivo de usuarios del cual leer, si no existe lo crea
 */
public ControlUsuarios(){
  if(arch.existeUsuario()){
    usuarios = arch.leerUsuario();
  }else{
    usuarios = new ArrayList();
  }
}

/**
 * Agrega un nuevo usuario al arreglo usuarios
 */
public void agregarUsuario(){
  Teclado tec = new Teclado();
  Usuario usu = new Usuario();
  String info;
  System.out.println("Nombre:");
  info = tec.leerString();
  usu.setNombre(info);
  System.out.println("pass:");
  info = tec.leerString();
  usu.setPassword(info);
  usuarios.add(usu);
  arch.escribirUsuario(usuarios);
}

public void mostrarUsuarios(){
  for (int i = 0; i < usuarios.size(); i++) {
    System.out.println(usuarios.get(i).toString());
    
  }
}

}
