package inventario;
/**
 *
 * @author Esmeralda Jimenez Ramos
 */
public class Inventario {
 
  public static void main(String[] args) {
    MensajesUsuario mu = new MensajesUsuario();
    int op;
    do {
      mu.menu();
      op = mu.leerOpcion();
      mu.realizarOpcion(op);
    } while (op != 7);
  } 
}
