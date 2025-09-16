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
        //Muestra las nuevas funciones de la app del banco.
        System.out.println();
        Persona persona1 = new Persona(44467862, "Ariel", "Alegre", 2002);
        Persona persona2 = new Persona(44469524, "Martin", "Villalva", 1995);
        Persona persona3 = new Persona(35154254, "Jose", "Perez", 2022);
        CuentaBancaria cuenta1 = new CuentaBancaria(14526387, persona1, 5000);
        CuentaBancaria cuenta2 = new CuentaBancaria(23145698, persona2);
        CuentaBancaria cuenta3 = new CuentaBancaria(43135656, persona3);
        unBanco.agregarCuentaBancaria(cuenta1);
        unBanco.agregarCuentaBancaria(cuenta2);
        unBanco.agregarCuentaBancaria(cuenta3);
        unBanco.mostrarResumen();
    }
}
