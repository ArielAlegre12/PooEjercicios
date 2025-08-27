import java.util.Scanner;
/**
 * Clase ejecutable que permite crear una cuenta bancaria y operar sobre ella.
 * Simula un menú de opciones para consultar datos del usuario, depositar y extraer dinero.
 * Cumple con las consignas de ingreso por teclado y colaboración entre objetos.
 */
public class CrearCuenta{
    static Scanner teclado = new Scanner(System.in);
    /**
     * Método principal del programa.
     * Instancia una cuenta bancaria y permite operar sobre ella mediante un menú interactivo.
     * Las opciones incluyen ver datos del usuario, depositar dinero, extraer dinero y salir.
     * Utiliza Scanner para el ingreso por teclado.
     */
    public static void main(String args[]){
        int opcion;
        CuentaBancaria unUsuario = nuevaCuenta();
        do{
            System.out.println("\n*** Menú del Banco ***");
            System.out.println("1. Ver datos del usuario");
            System.out.println("2. Depositar dinero");
            System.out.println("3. Extraer dinero");
            System.out.println("4. Salir");
            System.out.println("Ingrese una opcion: ");
            opcion = teclado.nextInt();
            
            switch(opcion){
                case 1:
                    unUsuario.mostrar();
                    break;
                case 2:
                    double montoDepositar;
                    System.out.println("\nIngrese el monto: ");
                    montoDepositar = teclado.nextDouble();
                    if(montoDepositar < 0){
                        System.out.println("Ingrese un monto valido!");
                    }else{
                        unUsuario.depositar(montoDepositar);
                    }
                    break;
                case 3:
                    double montoExtraer;
                    System.out.println("\nIngrese el monto: ");
                    montoExtraer = teclado.nextDouble();
                    if(montoExtraer > unUsuario.getSaldo()){
                        System.out.println("El monto supera el saldo!");
                    }else{
                        unUsuario.extraer(montoExtraer);
                    }
                    break;
                case 4:
                    System.out.println("\n----adios----\n");
                    break;
                default:
                    System.out.println("\nOpcion invalida!");
                    break;
                    
            }
            
        }while(opcion != 4);
        
    }
    /**
     * Solicita al usuario los datos personales por teclado y crea un objeto Persona.
     * Este objeto será utilizado como titular de la cuenta bancaria.
     * @return una instancia de la clase Persona con los datos ingresados
     */
    public static Persona crearUsuario(){
        System.out.println("Ingrese el número de dni: ");
        int dni = teclado.nextInt();
        System.out.println("Ingrese el nombre: ");
        String nombre = teclado.next();
        System.out.println("Ingrese el apellido: ");
        String apellido = teclado.next();
        System.out.println("Ingrese el año de nacimiento: ");
        int anioNacimiento = teclado.nextInt();
        return new Persona(dni, nombre, apellido, anioNacimiento);
       
    }
    /**
     * Solicita el número de cuenta y los datos del titular.
     * Crea una instancia de CuentaBancaria con el titular correspondiente.
     * @return una cuenta bancaria inicializada con saldo cero y titular definido
     */
    public static CuentaBancaria nuevaCuenta(){
        System.out.println("Ingrese el nro de cuenta: ");
        int nroCuenta = teclado.nextInt();
        Persona unTitular = crearUsuario();
        return new CuentaBancaria(nroCuenta, unTitular);
    }
    
}