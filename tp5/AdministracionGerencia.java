/**
 * Clase ejecutable que permite instanciar dos alojamientos, un hotel y una cabaña
 */
import java.util.Scanner;
public class AdministracionGerencia{
    public static void main(String args[]){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el nombre de la gerencia: ");
        String nombre = teclado.nextLine();
        //instancio servicios
        Servicio s1 = new Servicio("Internet", 400);
        Servicio s2 = new Servicio("Lavanderia", 100);
        Servicio s3 = new Servicio("Auto", 300);
        //instancio 1 hotel
        Hotel hotel = new Hotel("single", "Hotel Guaraní", 200.0, 7, s1);
        hotel.agregarServicio(s2);
        
        //instancio 1 cabaña
        Cabaña cabaña = new Cabaña(3, "Cabañas La Alondra", 500, 5, s3);
        cabaña.agregarServicio(s2);
        
        //instancio una gerencia
        Gerencia gerencia = new Gerencia(nombre);
        gerencia.agregarAlojamiento(hotel);
        gerencia.agregarAlojamiento(cabaña);
        gerencia.mostrarLiquidacion();
    }
}