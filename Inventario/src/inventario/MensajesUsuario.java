package inventario;

/**
 *
 * @author Esmeralda Jimenez Ramos
 */
public class MensajesUsuario {
  CRUD crud = new CRUD();
  Teclado teclado = new Teclado();
  int seleccionador = 0; 

  /**
   * Muestra el menu al usuario
   */
  public void menu() {
    System.out.println("\tMenu:");
    System.out.println("1) Agregar producto\n2) Consultar producto\n3) Modificar producto\n4) Eliminar producto\n"
        + "5) Mostrar por nombre\n6) Suma de activos\n7) Salir");
  }

  /**
   * Retorna la opción elegida por el usuario
   *
   * @return entero de la opcion elegida
   */
  public int leerOpcion() {
    System.out.println("¿Cual es tu opción?");
    return teclado.leerEnteros();
  }

  /**
   *
   */
  public void realizarOpcion(int op) {
    switch (op) {
      case 1:
        crud.agregar();
        break;
      case 2:
        System.out.println("Consultar por: \n1. Clave\n2. Nombre\n3. Descripcion");
        teclado.leerEnteros();
        
        if (seleccionador == 1) {
          crud.consultarClave();
        } else if (seleccionador == 2) {
          crud.consultarNombre();
        } else if (seleccionador == 3){
          crud.consultarDescripcion();
        } else {
          System.out.println("Selecciona una opcion disponible");
        }
        break;
      case 3:
        crud.editar();
        break;
      case 4:
        crud.eliminar();
        break;
      case 5:
        crud.mostrarNombre();
        break;
      case 6:
        crud.activosTotales();
        break;
      case 7:
        System.out.println("Gracias por participar");
        break;
      default:
        System.out.println("No establecido");
        break;
    }
  }
}
