import java.util.Scanner;
/**
 * Creo clase ejecutable Secretaria
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