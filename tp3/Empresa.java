import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 * Instanciar un empleado
 */import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Clase ejecutable {@code Empresa} que permite instanciar un objeto de tipo {@code Empleado}
 * y verificar su comportamiento según los métodos definidos.
 * <p>
 * Solicita datos por teclado, crea un empleado con fecha de ingreso completa,
 * muestra sus datos principales y evalúa si hoy es su aniversario laboral.
 * */
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
        Calendar fechaIngreso = new GregorianCalendar(anio, mes - 1, dia);
        Empleado unEmpleado = new Empleado(cuil, nom, ape, importe, fechaIngreso);
        unEmpleado.mostrar();
        if(unEmpleado.esAniversario()){
            System.out.println("Tiene permisio de salida.");
        }
        
        System.out.println("Responde a un jefe?(1-si, 2-no)");
        int op = teclado.nextInt();
        EmpleadoConJefe jefe = null;
        if(op == 1){
            System.out.println("Ingrese el nombre: ");
            String nombre = teclado.next();
            System.out.println("Ingrese el apellido: ");
            String apellido = teclado.next();
            
            jefe = new EmpleadoConJefe(0, nombre, apellido, 0, 0);
        }
        EmpleadoConJefe empleado = new EmpleadoConJefe(cuil, nom, ape, importe, fechaIngreso, jefe);
        empleado.mostrarPantalla();
        if(unEmpleado.esAniversario() && empleado.getJefe() != null){
            System.out.println("Tiene permisio de salida.");
            System.out.println("Firmado por: " + empleado.getJefe().apeYnom());
        }
        
    }
}