package inventario;

import java.util.Scanner;

/**
 *
 * @author Esmeralda Jimenez Ramos
 * @version 0.1
 */
public class Teclado {

  Scanner sc;

  /**
   * Inicializa nuestro objeto Scanner con la entrada estándar
   */
  Teclado() {
    sc = new Scanner(System.in);
  }

  /**
   * Regresa un entero leido desde teclado
   *
   * @return valor de tipo entero
   */
  public int leerEnteros() {
    return sc.nextInt();
  }

  /**
   * Regresa un doble leído desde teclado
   *
   * @return valor de tipo double
   */
  public double leerDoble() {
    return sc.nextDouble();
  }
  /**
   * Vacia el buffer antes de leer una cadena
   * @return valor de tipo string, cadena leída
   */
  public String leerCadenaPostEntero(){
    sc.nextLine();
    return sc.nextLine(); 
  }
  /**
   * lee una cadena de texto
   * @return string, cadena leída
   */
  public String leerCadena(){
    return sc.nextLine(); 
  }
}
