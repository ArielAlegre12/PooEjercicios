/**
 * Clase ejecutable que instancia 6 elementos de tipo Punto
 */
import java.util.Scanner;
public class ArrayDePuntos{
    public static void main(String args[]){
        Punto arraysPuntos[] = new Punto[6];
        Scanner teclado = new Scanner(System.in);
        for(int i = 0; i < 6; i++){
            System.out.println("Ingrese el x" + (i+1) + ": ");
            double x = teclado.nextDouble();
            System.out.println("Ingrese el y" + (i+1) + ": ");
            double y = teclado.nextDouble();
            arraysPuntos[i] = new Punto(x, y);
        }
        for(Punto unPunto: arraysPuntos){
            unPunto.coordenadas();
        }
        for(int i = 0; i < 5; i++){
            double distancia = arraysPuntos[i].distanciaA(arraysPuntos[i+1]);
            System.out.println("Distancia de " + arraysPuntos[i].coordenadas() + " y " + arraysPuntos[i+1].coordenadas() + 
                               " es: " + distancia);
            System.out.println("*-----*");
        }
    }
}