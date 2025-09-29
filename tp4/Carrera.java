/**
 * Clase ejecutable Curso que instancia uno y permite hacer distintas operaciones.
 * -ver los alumnos
 * -agregar alumno
 * -quitar alumno
 * -verificar si un alumno está inscripto
 * 
 */
import java.util.*;
import java.util.Scanner;
public class Carrera{
    static Scanner teclado = new Scanner(System.in);
    public static void main(String args[]){
        System.out.print("Ingrese el nombre del Curso: ");
        String nomCurso = teclado.next();
        Curso curso1 = new Curso(nomCurso);
        menu(curso1);
    }
    /**
     * Crear un alumno y retornar datos.
     */
    public static Alumno crearAlumno(){
        System.out.println("\n---Registrar Alumno---");
        System.out.print("Ingrese la Libreta Universitaria: ");
        int lu = teclado.nextInt();
        System.out.print("Ingrese el Nombre: ");
        String nombre = teclado.next();
        System.out.print("Ingrese el Apellido: ");
        String apellido = teclado.next();
        System.out.print("Ingrese la Nota 1: ");
        double n1 = teclado.nextDouble();
        System.out.print("Ingrese la Nota 2: ");
        double n2 = teclado.nextDouble();
        return new Alumno(lu, nombre, apellido, n1, n2);
    }
    /**
     * pequeño método para que ingrese el lu que desea seleccionar.
     */
    public static int seleccionarLu(Curso p_curso){
        System.out.println("\nLista de alumnos y sus LU(Libreta Universitaria). SELECCIONE UNA LU:");
        p_curso.mostrarInscriptos();
        System.out.print("escriba la lu que selecciona: ");
        int op = teclado.nextInt();
        return op;
    }
    /**
     * Pequeño menú interactivo
     */
    public static void menu(Curso p_curso){
        int opcion;
        do{
            System.out.println("\n***---Menú del curso de " + p_curso.getNombre() + "---***");
            System.out.println("1. Inscribir Alumno.");
            System.out.println("2. Dar de baja Alumno.");
            System.out.println("3. Buscar y mostrar Alumno por su libreta.");
            System.out.println("4. Ver promedio de un Alumno.");
            System.out.println("5. Visualizar Cantidad y lista de Alumnos.");
            System.out.println("6. Salir.");
            System.out.print("Opcion: ");
            opcion = teclado.nextInt();
            
            switch(opcion){
                case 1:
                    Alumno unAlumno = crearAlumno();
                    p_curso.inscribirAlumno(unAlumno);
                    System.out.println("\nHecho!.\n");
                    break;
                case 2:
                    int p_luQuitar = seleccionarLu(p_curso);
                    if(p_curso.estaInscripto(p_luQuitar)){
                        p_curso.quitarAlumno(p_luQuitar);
                        System.out.println("\nSe da baja a " + p_curso.buscarAlumno(p_luQuitar).getNombre() + " porque deja el curso!\n");
                    }else{
                        System.out.println("\nLU invalida!\n");
                    }
                    break;
                case 3:
                    int p_luBuscar = seleccionarLu(p_curso);
                    if(p_curso.estaInscripto(p_luBuscar)){
                        System.out.println("\n****-- Busca y muestra el alumno con numero de libreta " + p_luBuscar + "--****\n");
                        p_curso.buscarAlumno(p_luBuscar).mostrar();
                        System.out.println("\nHecho!\n");
                    }else{
                        System.out.println("\nLU invalida!\n");
                    }
                    break;
                case 4:
                    int p_luPromedio = seleccionarLu(p_curso);
                    if(p_curso.estaInscripto(p_luPromedio)){
                        System.out.println("\nPromedio: " + p_curso.buscarAlumno(p_luPromedio).promedio());
                        System.out.println("\nHecho!\n");
                    }else{
                        System.out.println("\nLU invalida!\n");
                    }
                    break;
                case 5:
                    System.out.println("\n****-- Cantidad de inscriptos: " + p_curso.cantidadDeAlumnos());
                    p_curso.mostrarInscriptos();
                    break;
                case 6:
                    System.out.println("Saliendo\n");
                    break;
                default:
                    System.out.println("Opcion invalida!\n");
            }
        }while(opcion != 6
        );
    }
}