import java.util.Scanner;
/**
 * clase ejecutable que instancia un hospital y permite el ingreso y la visualización de los datos.
 */
public class GestionHospital{
    public static void main(String args[]){
        Scanner teclado  = new Scanner(System.in);
        
        System.out.println("---- Ingreso datos de la localidad donde nació ---");
        System.out.println("Localidad: ");
        String nomLocal = teclado.nextLine();
        System.out.println("Provincia: ");
        String nomProvi = teclado.next();
        Localidad unaLocalidadNacimiento = new Localidad(nomLocal, nomProvi);
        System.out.println("Localidad de nacimiento confirmada.\n");
        
        System.out.println("---- Ingreso datos de la localidad donde vive ---");
        teclado.nextLine();
        System.out.println("Localidad: ");
        String nomLocaVive = teclado.nextLine();
        System.out.println("Provincia: ");
        String nomProviVive = teclado.next();
        Localidad unaLocalidadVive = new Localidad(nomLocaVive, nomProviVive);
        System.out.println("Localidad donde vive confirmada.\n");
        
        System.out.println("---- Ingreso datos del Paciente ---");
        System.out.println("Historia clinica: ");
        int historiaClinica = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Nombre del paciente: ");
        String nomPaciente = teclado.nextLine();
        System.out.println("Domicilio del paciente: ");
        String domiPaciente = teclado.nextLine();
        Paciente unPaciente = new Paciente(historiaClinica, nomPaciente, domiPaciente, unaLocalidadNacimiento, unaLocalidadVive);
        System.out.println("Paciente registrado!\n");
        
        System.out.println("---- Ingreso de los datos del Hospital ---");
        System.out.println("Nombre del hospital: ");
        String nomHospital = teclado.nextLine();
        System.out.println("Nombre del director: ");
        String nomDirector = teclado.nextLine();
        Hospital unHospital = new Hospital(nomHospital, nomDirector, unPaciente);
        unHospital.consultaDatosFilatorios(unPaciente);
        
    }
}