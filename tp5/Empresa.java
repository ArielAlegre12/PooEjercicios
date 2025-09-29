/**
 * Clase ejecutable que representa la interacción de los empleados, pudiendo mostrar sus datos
 * como dni, nombre, apellido, fecha de ingreso y de nacimiento, y su sueldo.
 */
import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;
public class Empresa{
    public static void main(String args[]){
    Scanner teclado = new Scanner(System.in);
    System.out.print("Cuantos empleados quiere instanciar?: ");
    int num = teclado.nextInt();
    for(int i = 0; i < num; i++){
        System.out.print("Ingrese el cuil: ");
        long cuil = teclado.nextLong();
        System.out.print("Ingrese el dni: ");
        int dni = teclado.nextInt();
        System.out.print("Ingrese el nombre: ");
        String nombre = teclado.next();
        System.out.print("Ingrese el apellido: ");
        String apellido = teclado.next();
        System.out.print("Ingrese el sueldo: ");
        double importe = teclado.nextDouble();
        System.out.print("\n****Ingreso de la fecha de Ingreso.****\n");
        System.out.print("Ingrese el año de ingreso: ");
        int anio = teclado.nextInt();
        System.out.print("Ingrese el mes de ingreso: ");
        int mes = teclado.nextInt();
        System.out.print("Ingrese el dia de ingreso: ");
        int dia = teclado.nextInt();
        Calendar fechaIngreso = new GregorianCalendar(anio, mes, dia);
        System.out.print("\n****Ingreso de la fecha de Nacimiento.****\n");
        System.out.print("Ingrese el año de Nacimiento: ");
        int anioNa = teclado.nextInt();
        System.out.print("Ingrese el mes de Nacimiento: ");
        int mesNa = teclado.nextInt();
        System.out.print("Ingrese el dia de Nacimiento: ");
        int diaNa = teclado.nextInt();
        Calendar fechaNacimiento = new GregorianCalendar(anioNa, mesNa, diaNa);
        Empleado emple = new Empleado(cuil, nombre, apellido, importe, fechaIngreso, dni, fechaNacimiento);
        System.out.println("\n--------------------------------------------------\n");
        emple.mostrar();
        System.out.println("\n--------------------------------------------------\n");
    }
    }
}