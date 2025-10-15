/**
 * clase ejecutable para hacer un pedido instanciandolo.
 */
import java.util.*;
public class HacerPedido{
    public static void main(String args[]){
             Scanner teclado = new Scanner(System.in);
             //instancio una etiqueta premium
             Premium etiquetaPremium = new Premium(2, 200.0);
             //instancio una etiqueta comúm
             Comun etiquetaComun = new Comun(150.0, 500.0);
             //instancio otro premium
             Premium etiquetaPremium2 = new Premium(6, 140.0);
             //instancio otro comúm
             Comun etiquetaComun2 = new Comun(30.0, 300.0);
              //instancio un renglón
             Renglon r1 = new Renglon(20, 240.0, etiquetaPremium);
             //instancio otro renglón
             Renglon r2 = new Renglon(42, 300.0, etiquetaComun);
             //instancio otro renglón
             Renglon r3 = new Renglon(30, 400.0, etiquetaComun2);
             
             //instancio un pedido
             Pedido pedido = new Pedido(r1);
             //agrego renglones.
             pedido.agregarRenglon(r2);
             pedido.agregarRenglon(r3);
             pedido.mostrar();
         }
}