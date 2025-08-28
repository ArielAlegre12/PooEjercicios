import java.util.Scanner;
import java.util.Random;
/**
 * Representa un banco, en el cual puede instanciarse un usuario 
 */
public class Banco{
    static Scanner teclado  = new Scanner(System.in);
    public static void main(String args[]){
        Persona unTitular = crearTitular();
        CuentaCorriente unaCuenta = crearCuentaCorriente(unTitular);
        CajaDeAhorro unaCaja = crearCajaAhorro(unTitular);
        menuBanco(unaCuenta, unaCaja);
        
    }
    /**
     * método que permite crear un titular, devolviendo el objeto listo para asignarlo.
     */
    public static Persona crearTitular(){
        System.out.println("\nIngrese el DNI: ");
        int dni = teclado.nextInt();
        System.out.println("Ingrese el Nombre: ");
        String nombre = teclado.next();
        System.out.println("Ingrese el Apellido: ");
        String apellido = teclado.next();
        System.out.println("Ingrese el año en que nacio: ");
        int anioNacimiento = teclado.nextInt();
        
        return new Persona(dni, nombre, apellido, anioNacimiento);
    }
    /**
     * método que permite crear una cuenta corriente para una persona.
     */
    public static CuentaCorriente crearCuentaCorriente(Persona p_titular){
        Random unNumero = new Random();
        //nextInt(9000) + 1000 hace que sea un numero random del 1000 al 9000, haciendo más real el numero de cuenta
        int nroCuenta = unNumero.nextInt(9000) + 1000;
        System.out.println("El numero de cuenta asignado a la Cuenta Corriente es: " + nroCuenta);
        return new CuentaCorriente(nroCuenta, p_titular);
    }
    /**
     * método que permite crear una cuenta corriente par una persona
     */
    public static CajaDeAhorro crearCajaAhorro(Persona p_titular){
        Random unNumero = new Random();
        //nextInt(9000) + 1000 hace que sea un numero random del 1000 al 9000, haciendo más real el numero de cuenta
        int nroCuenta = unNumero.nextInt(9000) + 1000;
        System.out.println("El numero de cuenta asignado de la Caja de Ahorro es: " + nroCuenta);
        return new CajaDeAhorro(nroCuenta, p_titular);
    }
    /**
     * Menú para interactuar con el titular
     */
    public static void menuBanco(CuentaCorriente p_unaCuenta, CajaDeAhorro p_unaCaja){
        int opcion;
        do{
            System.out.println("\n---- MENÚ USUARIO ---");
            System.out.println("1. Ver datos de Cuenta Corriente.");
            System.out.println("2. Ver datos de Caja de Ahorro.");
            System.out.println("3. Depositar en Cuenta Corriente.");
            System.out.println("4. Depositar en Caja de Ahorro.");
            System.out.println("5. Extraer de Cuenta corriente.");
            System.out.println("6. Extraer de Caja de Ahorro.");
            System.out.println("0. Salir.");
            System.out.println("Eliga una opción: ");
            opcion = teclado.nextInt();
            System.out.println("\n");
            
            switch(opcion){
                case 1:
                    p_unaCuenta.mostrar();
                    break;
                case 2:
                    p_unaCaja.mostrar();
                    break;
                case 3:
                    System.out.println("Ingrese el monto a depositar: ");
                    double montoCuenta = teclado.nextDouble();
                    p_unaCuenta.depositar(montoCuenta);
                    System.out.println("Hecho. Saldo actual: " + p_unaCuenta.getSaldo());
                    break;
                case 4:
                    System.out.println("Ingrese el monto a depositar: ");
                    double montoCaja = teclado.nextDouble();
                    p_unaCuenta.depositar(montoCaja);
                    System.out.println("Hecho. Saldo actual: " + p_unaCuenta.getSaldo());
                    break;
                case 5:
                    System.out.println("Ingrese el monto a extraer: ");
                    double extraerCuenta = teclado.nextDouble();
                    p_unaCuenta.extraer(extraerCuenta);
                    break;
                case 6:
                    System.out.println("Ingrese el monto a extraer: ");
                    double extraerCaja = teclado.nextDouble();
                    p_unaCaja.extraer(extraerCaja);
                    break;
                case 0:
                    System.out.println("Saliendo---");
                    break;
                default:
                    System.out.println("Opción invalida. hagalo de nuevo!");
            }
            
        }while(opcion != 0);
    }
}