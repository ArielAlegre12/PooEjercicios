import java.util.Scanner;
/**
  * Clase ejecutable que simula un Registro Civil con menú interactivo.
  * 
  * Permite crear registros de un hombre y una mujer, establecer vínculos matrimoniales entre ellos,
  * mostrar el estado civil, consultar con quién están casados y realizar divorcios.
  * 
*/
public class RegistroCivilMenu{
    static Scanner teclado = new Scanner(System.in);
    public static void main(String args[]){
        /**
         * Método principal que ejecuta el programa.
         *  
         * Crea un hombre y una mujer a partir de datos ingresados por teclado, y lanza el menú interactivo.
        */
        Hombre unHombre = crearHombre();
        Mujer unaMujer = crearMujer();
        menu(unHombre, unaMujer);
        
    }
    /**
     * Crea un objeto que representa una mujer y lo devuelve
     */
    public static Mujer crearMujer(){
        System.out.println("\n--- Crear registro de Mujer ---\n");
        System.out.println("Ingrese el nombre: ");
        String nombre = teclado.next();
        System.out.println("Ingrese el apellido: ");
        String apellido = teclado.next();
        System.out.println("Ingrese la edad: ");
        int edad = teclado.nextInt();
        
        return new Mujer(nombre, apellido, edad);
    }
    /**
     * Crea un objeto que representa un hombre y lo devuelve.
     */
    public static Hombre crearHombre(){
        System.out.println("\n--- Crear registro de Hombre ---\n");
        System.out.println("Ingrese el nombre: ");
        String nombre = teclado.next();
        System.out.println("Ingrese el apellido: ");
        String apellido = teclado.next();
        System.out.println("Ingrese la edad: ");
        int edad = teclado.nextInt();
        
        return new Hombre(nombre, apellido, edad);
    }
    /**
     * menú interactivo
     */
    public static void menu(Hombre p_hombre, Mujer p_mujer){
        int opcion;
        do{
            System.out.println("\n--- MENÚ REGISTRO CIVIL ---\n");
            System.out.println("1. Mostrar estado civil del hombre.");
            System.out.println("2. Mostrar estado civil de la mujer.");
            System.out.println("3. Casar.");
            System.out.println("4. Divorciar.");
            System.out.println("5. Ver con quien está casado el hombre.");
            System.out.println("6. Ver con quien está casada la mujer.");
            System.out.println("7. Salir.");
            System.out.println("Ingrese una opcion: ");
            opcion = teclado.nextInt();
            
            switch(opcion){
                case 1:
                    p_hombre.mostrarEstadoCivil();
                    System.out.println("\nHecho\n");
                    break;
                case 2:
                    p_mujer.mostrarEstadoCivil();
                    System.out.println("\nHecho\n");
                    break;
                case 3:
                    p_hombre.casarseCon(p_mujer);
                    System.out.println("\nHecho\n");
                    break;
                case 4:
                    p_hombre.divorcio();;
                    System.out.println("\nHecho\n");
                    break;
                case 5:
                    p_hombre.casadoCon();
                    break;
                case 6:
                    p_mujer.casadaCon();
                    break;
                case 7:
                    System.out.println("Hasta luego crack!\n");
                    break;
                default:
                    System.out.println("opcion invalida, ingrese de nuevo!\n");
                    break;
            }
        }while(opcion != 7);
    }
}