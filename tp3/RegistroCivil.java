import  java.util.Scanner;
/**
 * Clase ejecutable que simula el Registro Civil y emite un certificado de matrimonio.
 * 
 * Instancia objetos de las clases {@code Mujer} y {@code Hombre} a partir de datos ingresados por teclado,
 * establece el vínculo matrimonial entre ellos y muestra el resultado por pantalla.
 * @Author Alegre Ariel, Antoniow Agustín.
*/
public class RegistroCivil{
    
    public static void main(String args[]){
        /**
         * Método principal que ejecuta el programa.
         * 
         * Solicita datos personales de una mujer y un hombre, los instancia como objetos,
         * establece el vínculo matrimonial entre ellos y muestra el certificado por pantalla.
        */
        Scanner teclado = new Scanner(System.in);
        System.out.println("\n----Ingreso de datos de la Mujer ----");
        System.out.println("Ingrese el nombre de la mujer: ");
        String nomMujer = teclado.next();
        System.out.println("Ingrese el apellido de la mujer: ");
        String apeMujer = teclado.next();
        System.out.println("Ingrese la edad de la mujer: ");
        int edadMujer = teclado.nextInt();
        Mujer unaMujer = new Mujer(nomMujer, apeMujer, edadMujer);
        
        System.out.println("\n-----Ingreso de datos del Hombre: ");
        System.out.println("Ingrese el nombre del Hombre: ");
        String nomHombre = teclado.next();
        System.out.println("Ingrese el apellido del Hombre: ");
        String apeHombre = teclado.next();
        System.out.println("Ingrese la edad del Hombre: ");
        int edadHombre = teclado.nextInt();
        Hombre unHombre = new Hombre(nomHombre, apeHombre, edadHombre);
        
        unHombre.casarseCon(unaMujer);
        unHombre.casadoCon();
        System.out.println("Registro Civil de Corrientes - Matrimonio registrado correctamente.");
    }
}