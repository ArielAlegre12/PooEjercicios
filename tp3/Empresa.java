import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 * Instanciar un empleado
 */
public class Empresa{
    public static void main(String args[]){
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Ingrese el cuil: ");
        long cuil = teclado.nextLong();
        System.out.println("Ingrese el nombre:");
        String nom = teclado.next();
        System.out.println("Ingrese el apellido: ");
        String ape  =  teclado.next();
        System.out.println("Ingrese el sueldo: ");
        double importe = teclado.nextDouble();
        System.out.println("Ingrese el año de ingreso: ");
        int anio = teclado.nextInt();
        System.out.println("Ingrese el mes de ingreso: ");
        int mes = teclado.nextInt();
        System.out.println("Ingrese el dia de ingreso: ");
        int dia = teclado.nextInt();
        Calendar fechaIngreso = new GregorianCalendar(anio, mes, dia);
        Empleado unEmpleado = new Empleado(cuil, nom, ape, importe, fechaIngreso);
        unEmpleado.mostrar();
        if(unEmpleado.esAniversario()){
            System.out.println("Tiene permisio de salida.");
        }
        
    }
}