
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

/**
 * Muestra los usuarios que existen
 */
public void mostrarUsuarios(){
  for (int i = 0; i < usuarios.size(); i++) {
    System.out.println(usuarios.get(i).toString());
    
  }
}

/**
 * Busca un usuario en el arreglo
 * @param usu Un String con el nombre de usuario a buscar
 * @param pass Un String con la contraseña del usuario
 * @return True si usuario y contraseña coinciden con los almacenados, False si no
 */
public boolean buscarUsuario(String usu, String pass){
  boolean existe=false;
  for (int i = 0; i < usuarios.size(); i++) {
   if(usu.equals(usuarios.get(i).getNombre())){
     if(pass.equals(usuarios.get(i).getPassword())){
       existe = true;
       break;
     }
   } else{
     existe = false;
   }
  }
  return existe;
}

}
