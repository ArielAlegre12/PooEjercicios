/**4
 * clase ejecutable
 */
import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;
public class Escuela{
    public static void main(String args[]){
        Scanner teclado = new Scanner(System.in);
        System.out.print("Ingrese el dni: ");
        int dni = teclado.nextInt();
        System.out.print("Ingrese la libreta universitaria: ");
        int lu = teclado.nextInt();
        System.out.print("Ingrese el nombre: ");
        String nombre = teclado.next();
        System.out.print("Ingrese el apellido: ");
        String apellido = teclado.next();
        System.out.print("Ingrese el año de nacimiento: ");
        int anio = teclado.nextInt();
        System.out.print("Ingrese el mes de nacimiento: ");
        int mes = teclado.nextInt();
        System.out.print("Ingrese el dia de nacimiento: ");
        int dia = teclado.nextInt();
        Calendar fecha = new GregorianCalendar(anio, mes, dia);
        System.out.print("Ingrese la nota 1: ");
        double n1 = teclado.nextDouble();
        System.out.println("Ingrese la nota 2: ");
        double n2 = teclado.nextDouble();
        Persona per1 = new Persona(dni, nombre, apellido, fecha);
        per1.mostrar();
        System.out.println("\n");
        Alumno alum1 = new Alumno(lu, nombre, apellido, dni, fecha, n1, n2);
        alum1.mostrar();
    }
}