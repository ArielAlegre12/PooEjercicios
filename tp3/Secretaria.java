import java.util.Scanner;
/**
 * Clase ejecutable {@code Secretaria} que permite instanciar un objeto {@code Docente}
 * y una {@code Escuela} que lo contiene como colaborador, para emitir un recibo de sueldo.
 * <p>
 * Solicita los datos del docente y de la escuela por teclado, crea los objetos correspondientes
 * y muestra el recibo con desglose de sueldo básico, asignación familiar y total.
 * @Author Alegre Ariel, Antoniow Agustín.
 */
public class Secretaria{
    public static void main(String args[]){
        Scanner teclado =  new Scanner(System.in);
        System.out.println("Ingrese nombre de la docente: ");
        String nomDocente = teclado.nextLine();
        System.out.println("Ingrese el grado: ");
        String grado = teclado.next();
        System.out.println("Ingrese el sueldo basico: ");
        double sueldoBasico = teclado.nextDouble();
        System.out.println("Ingrese la asignación familiar: ");
        double asiFamiliar = teclado.nextDouble();
        teclado.nextLine();
        Docente unDocente = new Docente(nomDocente, grado, sueldoBasico, asiFamiliar);
        System.out.println("Docente registrada!\n");
        
        System.out.println("Ingrese el nombre del colegio: ");
        String nomEscuela = teclado.nextLine();
        System.out.println("Ingrese el domicilio del colegio: ");
        String domicilio = teclado.nextLine();
        System.out.println("Ingrese el nombre del director del colegio: ");
        String director = teclado.nextLine();
        Escuela unaEscuela = new Escuela(nomEscuela, domicilio, director, unDocente);
        unaEscuela.imprimirRecibo(unDocente);
    }
}