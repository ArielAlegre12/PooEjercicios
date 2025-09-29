/**
 * Clase ejecutable para instanciar una facultad y manejar a sus profesores y sus cargos.
 */
import java.util.Scanner;
public class AplicacionFacultad{
    public static void main(String args[]){
        Scanner teclado = new Scanner(System.in);
        System.out.print("Ingrese el nombre de la facultad: ");
        String nombre = teclado.next();
        
        //Instancio cargos.
        SemiExclusivo cargoSemi1 = new SemiExclusivo(5, "Titular-TFA", 1400.0, 2013, 11);
        Cargo cargoSimple1 = new Cargo("JTP-Programación OO", 800.0, 2015, 10);
        Cargo cargoSimple2 = new Cargo("JTP-Analisis de Sistemas", 800.0, 2005, 10);
        Profesor profe1 = new Profesor("Lic. en Sistemas de Información", cargoSimple1, 28596132, "Juan", "Perez", 1988);
        profe1.agregarCargo(cargoSemi1);
        profe1.agregarCargo(cargoSimple2);
        
        
        //Instancio otro profesor con otros cargos
        Cargo cargoSimple3 = new Cargo("JTP-TP-II", 1200.0, 2014, 10);
        Exclusivo cargoExclusivo1 = new Exclusivo(20, 10, "JTP-Ing.Soft", 1800.0, 2015, 10);
        Profesor profe2 = new Profesor("Lic. en Sistemas de Información", cargoExclusivo1,34519921 ,"Mirta", "Lopez", 1995);
        
        Facultad facu = new Facultad(nombre, profe1);
        facu.agregarProfesor(profe2);
        facu.listarProfesoresCargos();
        facu.nomina();
    }
}