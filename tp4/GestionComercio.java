/**
 * La clase {@code GestionComercio} representa el punto de entrada de la aplicación.
 * 
 * Instancia un objeto de la clase {@code Comercio}, solicita al usuario el nombre del comercio
 * y agrega varios empleados a dicho comercio. Luego muestra la nómina de empleados en cada paso.
 * 
 * Este ejemplo demuestra cómo utilizar la clase {@code Comercio} y cómo gestionar empleados
 * mediante la consola.
 * 
 * @author Alegre Ariel, Agustín Antoniow.
 * @version 1.0
 */
import java.util.*;
import java.util.Scanner;

public class GestionComercio{
    public static void main(String args[]){
        Scanner teclado = new Scanner(System.in);
        System.out.print("Ingrese el nombre del comercio: ");
        String nombre = teclado.nextLine();
        Comercio comercio1 = new Comercio(nombre);
        //muestro el comercio sin ningún empleado.
        comercio1.nomina();
        //Instancio 1 empleado.
        Empleado emp1 = new Empleado(30100623, "Gonzalez", "Juan", 150000, 2000);
        comercio1.altaEmpleado(emp1);
        comercio1.nomina();
        //Instancio los demas empleados.
        Empleado emp2 = new Empleado(37045987, "Martinez", "Mercedes", 230000, 2000);
        comercio1.altaEmpleado(emp2);
        Empleado emp3 = new Empleado(32550096, "Gomez", "Virginia", 560000, 2000);
        comercio1.altaEmpleado(emp3);
        comercio1.nomina();
    }
}