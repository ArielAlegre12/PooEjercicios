import java.util.Scanner;
/**
 * Clase ejecutable que permite crear un objeto {@link Punto}
 * a partir de coordenadas ingresadas por el usuario.
 * <p>
 * Muestra las coordenadas del punto en consola.
 */
public class CrearUnPunto{
    /**
     * Método principal que solicita coordenadas al usuario,
     * crea un punto y muestra su ubicación.
     *
     * @param args argumentos de línea de comandos (no se utiliza acá)
     */
    public static void main(String args[]){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el valor de X: ");
        double x = teclado.nextDouble();
        System.out.println("Ingrese el valor de Y: ");
        double y = teclado.nextDouble();
        
        Punto unPunto = new Punto(x, y);
        unPunto.mostrar();
    
    }
}