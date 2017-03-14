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
public class MensajesUsuario {

  public MensajesUsuario() {

  }

  /**
   * Este método muestra las opciones disponibles para el usuario
   */
  public void menu() {
    System.out.println("\n1 Agregar producto");
    System.out.println("2 Eliminar");
    System.out.println("3 Editar");
    System.out.println("4 Mostrar inventario");
    System.out.println("5 Buscar por clave");
    System.out.println("6 Buscar por nombre");
    System.out.println("7 Buscar por descripción");
    System.out.println("8 Mostrar ordenado por nombre");
    System.out.println("9 Mostrar ordenado por clave");
    System.out.println("10 Calcular costo total de inventario");
    System.out.println("11 Vender");
    System.out.println("12 Ver ventas");
    System.out.println("13 Ver ventas por fecha");
    System.out.println("14 Ver ganancias por día");
    System.out.println("15 Agregar usuario");
    System.out.println("0 Salir\n");
    
  }

  /**
   * Este método lee la opcion ingresada por el usuario
   *
   * @return retorna la opción introducida por el usuario
   */
  public int leerOpcion() {
    Teclado tec = new Teclado();
    System.out.println("¿Qué te gustaría hacer?");
    return tec.leerEntero();
  }
  
  public String leerInfo(){
    Teclado tec = new Teclado();
    return tec.leerString();
  }

  /**
   * Este método realiza la opción que eligió el usuario
   *
   * @param op Es la opción elegida por el usuario
   */
  public void realizarOpcion(int op) {
    Inventario inv = new Inventario();
    RegistroVentas rv = new RegistroVentas();
    ControlUsuarios cu = new ControlUsuarios();
    String informacion;
    int indice;
    switch (op) {
      case 0:
        System.out.println("Ya me usaste. ¿Estás feliz?");
        break;
      case 1:
        //inv.agregarProducto();
        break;
      case 2:
        System.out.println("Ingresa la clave del producto a eliminar");
        informacion = leerInfo();
        indice = inv.buscarClave(informacion);
        inv.eliminarElemento(indice);
        break;
      case 3:
        System.out.println("Ingresa la clave del producto a editar");
        informacion = leerInfo();
        indice = inv.buscarClave(informacion);
        inv.editar(indice);
        break;
      case 4:
        inv.mostrarInventario();
        break;
      case 5:
        System.out.println("Ingresa la clave del producto a buscar");
        informacion = leerInfo();
        indice = inv.buscarClave(informacion);
        inv.mostrarInformacion(indice);
        break;
      case 6:
        System.out.println("Ingresa el nombre del producto a buscar");
        informacion = leerInfo();
        indice = inv.buscarNombre(informacion);
        inv.mostrarInformacion(indice);
        break;
      case 7:
        System.out.println("Ingresa la descripción del producto a buscar");
        informacion = leerInfo();
        indice = inv.buscarDescripcion(informacion);
        inv.mostrarInformacion(indice);
        break;
      case 8:
        inv.ordenarNombre();
        inv.mostrarInventario();
        break;
      case 9:
        inv.ordenarClave();
        inv.mostrarInventario();
        break;
      case 10:
        inv.calcularTotal();
        break;
      case 11:
        inv.vender();
        break;
      case 12:
        rv.mostrarVentas();
        break;
      case 13:
        System.out.println("Ingresa la fecha (dd/mm/aaaa) solo números");
        informacion = leerInfo();
        rv.verVentasFecha(informacion);
        break;
      case 14:
        System.out.println("Ingresa la fecha (dd/mm/aaaa) solo números");
        informacion = leerInfo();
        rv.calcularGananciasDia(informacion);
        break;
      case 15:
        cu.agregarUsuario();
        break;
      case 16:
        cu.mostrarUsuarios();
        break;
      default:
        System.out.println("¿Me quieres ver la cara de estúpida?\n");
        break;
    }
  }

}
