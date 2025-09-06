/**
 * Creo un ejecutable para ingresar y recorrer los datos del tipo Punto.
 * recibe hasta 6 elementos de ese tipo.
 */
import java.util.*;
import java.util.Scanner;

public class CrearArrayPuntos{
    public static void main(String args[]){
        Scanner teclado = new Scanner(System.in);
        ArrayDePunto newPuntos = new ArrayDePunto();
        int cont = 1;
        for(Punto unPunto: newPuntos.getPuntos()){
            System.out.println("Ingrese el valor de x" + cont + ": ");
            double x = teclado.nextDouble();
            System.out.println("Ingrese el valor de y" + cont + ": ");
            double y = teclado.nextDouble();
            unPunto = new Punto(x, y);
            newPuntos.agregarPunto(unPunto);
            cont ++;
        }
        newPuntos.recorrerArray();
    }
}