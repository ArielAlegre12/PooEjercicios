import java.util.Random;
import java.util.Scanner;
/**
 * Clase ejecutable que permite crear y manipular figuras geométricas (Círculo y Rectángulo).
 * <p>
 *  Se utilizan objetos de tipo {@code Punto}, {@code Circulo} y {@code Rectangulo}.
 *  @Author Alegre Ariel, Antoniow Agustín.
 */
public class CreaFigura{
    public static void main(String args[]){
        
        Scanner teclado = new Scanner(System.in);
        //Genero un numero random
        Random unNumero = new Random();
        
        //Primero circulo
        double radio = unNumero.nextDouble() * 100;
        System.out.println("Ingreso de valores del Centro: \n");
        System.out.println("X: ");
        double x1 = teclado.nextDouble();
        System.out.println("Y: ");
        double y1 = teclado.nextDouble();
        Punto p1 = new Punto(x1, y1);
        Circulo c1 = new Circulo(radio, p1);
        c1.desplazar(-240, -230);
        c1.caracteristicas();
        
        //Segundo circulo
        double radio2 = unNumero.nextDouble() * 100;
        System.out.println("Ingreso de valores del segundo centro: \n");
        System.out.println("X: ");
        double x2 = teclado.nextDouble();
        System.out.println("Y: ");
        double y2 = teclado.nextDouble();
        Punto p2 = new Punto(x2, y2);
        Circulo c2 = new Circulo(radio2, p2);
        c2.caracteristicas();
        
        //Muestra las caracteristicas del mayor de los dos circulos
        System.out.println("\nEl circulo mayor es: \n");
        c2.elMayor(c1).caracteristicas();
        //Muestra la distancia entre los circulos
        System.out.println("Las distancia de los circulos es: " + c2.distanciaA(c1));
        
        //Trabajando con el Rectangulo
        System.out.println("\nIngrese coordenadas del origen:");
        System.out.println("X: ");
        double xp = teclado.nextDouble();
        System.out.println("Y: ");
        double yp = teclado.nextDouble();
        Punto origen1 = new Punto(xp, yp);
        double ancho1 = unNumero.nextDouble() * 100;
        System.out.println("Ancho asignado: "+ ancho1);
        double alto1 = unNumero.nextDouble() * 100;
        System.out.println("Alto asignado: " + alto1);
        Rectangulo r1 = new Rectangulo(origen1, ancho1, alto1);
        r1.desplazar(40, -20);
        r1.caracateristicas();
        
        //Creo otro Rectangulo
        System.out.println("\nIngrese coordenadas del origen:");
        System.out.println("X: ");
        double xp2 = teclado.nextDouble();
        System.out.println("Y: ");
        double yp2 = teclado.nextDouble();
        Punto origen2 = new Punto(xp2, yp2);
        double ancho2 = unNumero.nextDouble() * 100;
        System.out.println("Ancho asignado: " + ancho2);
        double alto2 = unNumero.nextDouble() * 100;
        System.out.println("Alto asignado: " + alto2);
        Rectangulo r2 = new Rectangulo(origen2, ancho2, alto2);
        System.out.println("Las caracteristicas del rectangulo mayor son: \n");
        r2.elMayor(r1).caracateristicas();
        System.out.println("\nLa distancia entre los rectangulos es: " + r2.distanciaA(r1));
        
        
        
    }
}