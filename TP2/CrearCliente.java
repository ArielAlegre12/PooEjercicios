/**
 * Clase ejecutable que instancia un objeto Cliente y muestra sus datos.
 * <p>
 * La clase debe ejecutarse con 4 argumentos desde la linea de comando.
 * DNI(tipo int), apellido(tipo string), nombre(tipo string) y saldo(tipo double).
 * Si no se ingresan los datos correctamente, muestra un mensaje de error
 * 
 * @author Alegre Ariel, Agustín Antoniow
 * @version 1.0
 */
public class CrearCliente{
    public static void main(String args[]){
        if(args.length < 4){
            System.out.println("Error: tienen que ser 4 argumentos(DNI, apellido, nombre y saldo)");
            return;
        }
        int nroDni= Integer.parseInt(args[0]);
        String apellido = args[1];
        String nombre = args[2];
        double saldo = Double.parseDouble(args[3]);
        
        Cliente c = new Cliente(nroDni, apellido, nombre, saldo);
        c.mostrar();
        
    }
}