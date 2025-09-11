import java.util.*;
import java.util.Scanner;
/**
 * Clase ejecutable que intancia la apliación del banco para manejar sus empleados y sueldos.
 */
public class AplicacionBanco{
    public static void main(String args[]){
        Scanner teclado = new Scanner(System.in);
        Localidad unaLoca = new Localidad("Corrientes", "Corrientes");
        Empleado empleado1 = new Empleado(234467862, "Perez", "Lorena", 25000, 2005);
        Empleado empleado2 = new Empleado(234554585, "Dominguez", "Pedro", 33000, 2008);
        Empleado empleado3 = new Empleado(224588545, "Martinez", "Mauro", 15600, 2009);
        System.out.println("Ingrese el nombre del BANCO: ");
        String nomBanco = teclado.next();
        System.out.println("Ingrese el numero de sucursal del BANCO: ");
        int nroSucursal = teclado.nextInt();
        Banco unBanco = new Banco(nomBanco, unaLoca, nroSucursal, empleado1);
        unBanco.mostrar();
        System.out.println("\n");
        unBanco.agregarEmpleado(empleado2);
        unBanco.agregarEmpleado(empleado3);
        unBanco.mostrar();
        System.out.println("\n");
        unBanco.quitarEmpleado(empleado1);
        unBanco.mostrar();
    }
}
