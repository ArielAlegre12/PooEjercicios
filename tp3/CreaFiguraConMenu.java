import java.util.Scanner;
import java.util.Random;
/**
 * Clase ejecutable que permite crear y manipular figuras geométricas (Círculo y Rectángulo)
 * mediante un menú interactivo en consola.
 * <p>
 * cumpliendo con unos de los requerimientos del tp de tener un menú interactivo
 * Se utilizan objetos de tipo {@code Punto}, {@code Circulo} y {@code Rectangulo}.
 * </p>
 */

public class CreaFiguraConMenu {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Random unNumero = new Random();
        //defino la variable con la que se manejara las opciones del menú
        int opcion;
        //uso el método do-while para que muestre al menos una vez el menú
        do {
            System.out.println("\n--- MENÚ DE FIGURAS GEOMÉTRICAS ---");
            System.out.println("1. Crear y mostrar Círculo");
            System.out.println("2. Crear y mostrar Rectángulo");
            System.out.println("3. Comparar dos Círculos");
            System.out.println("4. Comparar dos Rectángulos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = teclado.nextInt();
            //incorporo el método switch para elegir y llamar a los distintos métodos
            switch (opcion) {
                case 1:
                    Circulo c = crearCirculo(unNumero, teclado);
                    c.caracteristicas();
                    break;
                case 2:
                    Rectangulo r = crearRectangulo(unNumero, teclado);
                    r.caracateristicas();
                    break;
                case 3:
                    Circulo c1 = crearCirculo(unNumero, teclado);
                    Circulo c2 = crearCirculo(unNumero, teclado);
                    Circulo mayorC = c1.elMayor(c2);
                    System.out.println("El círculo mayor es:");
                    mayorC.caracteristicas();
                    break;
                case 4:
                    Rectangulo r1 = crearRectangulo(unNumero, teclado);
                    Rectangulo r2 = crearRectangulo(unNumero, teclado);
                    Rectangulo mayorR = r1.elMayor(r2);
                    System.out.println("El rectángulo mayor es:");
                    mayorR.caracateristicas();
                    break;
                case 0:
                    System.out.println("Saliendo---");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        teclado.close();
    }
    //acá defino los métodos que se llaman en el switch
    //genera un circulo
    public static Circulo crearCirculo(Random p_unNumero,Scanner p_teclado) {
        double radio = p_unNumero.nextDouble() * 100;
        System.out.println("Radio asignado: " + radio);
        System.out.println("Ingrese coordenadas del centro:");
        System.out.print("X: ");
        double x = p_teclado.nextDouble();
        System.out.print("Y: ");
        double y = p_teclado.nextDouble();
        Punto centro = new Punto(x, y);
        return new Circulo(radio, centro);
    }
    //genera un rectangulo :=
    public static Rectangulo crearRectangulo(Random p_unNumero,Scanner p_teclado) {
        System.out.println("Ingrese coordenadas del origen:");
        System.out.print("X: ");
        double x = p_teclado.nextDouble();
        System.out.print("Y: ");
        double y = p_teclado.nextDouble();
        double ancho = p_unNumero.nextDouble();
        System.out.println("Ancho asignado: " + ancho);
        double alto = p_unNumero.nextDouble();
        System.out.println("Alto asignado: " + alto);
        Punto origen = new Punto(x, y);
        return new Rectangulo(origen, ancho, alto);
    }
}
