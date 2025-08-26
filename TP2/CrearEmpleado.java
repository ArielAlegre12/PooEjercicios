import java.util.Scanner;
/**
 * Clase CrearEmpleado que crea el ejecutable de Empleado.
 * <p>
 * Este pide el ingreso de los datos por teclado.
 * puede mostrar info del empleado, agregar el adicional de años trabajados,
 * tambien el descuento del sueldo básico para la obra social y del seguro de vida.
 */
public class CrearEmpleado{
    public static void main(String args[]){
        Scanner texto = new Scanner(System.in);
        System.out.println("Ingrese el cuil: ");
        long cuil = texto.nextInt();
        System.out.println("Ingrese el apellido: ");
        String apellido = texto.next();
        System.out.println("Ingrese el nombre: ");
        String nombre = texto.next();
        System.out.println("Ingrese el importe: ");
        double importe = texto.nextInt();
        System.out.println("Ingrese el año de ingreso: ");
        int anioIngreso = texto.nextInt();
        
        Empleado unEmpleado = new Empleado(cuil, apellido, nombre, importe, anioIngreso);
        unEmpleado.mostrar();
    }
}