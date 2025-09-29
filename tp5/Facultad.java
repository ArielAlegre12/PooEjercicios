/**
 * Clase Facultad que administra a los profesores y sus cargos.
 */
import java.util.*;
public class Facultad{
    private String nombre;
    private ArrayList<Profesor> profesores;
    
    /**
     * Constructor que incializa un arrays de profesores.
     * @param p_nombre nombre de la facultad.
     * @param p_profesores array de los profes.
     */
    public Facultad(String p_nombre, ArrayList<Profesor> p_profesores){
        this.setNombre(p_nombre);
        this.setProfesores(p_profesores);
    }
    
    /**
     * Constructor que inicializa con sólo un profesor
     * @param p_nombre nombre de la facultad.
     * @param p_profesor profesor que de la facu.
     */
    public Facultad (String p_nombre, Profesor p_profesor){
        this.setNombre(p_nombre);
        this.setProfesores(new ArrayList<Profesor>());
        this.agregarProfesor(p_profesor);
    }
    
    /**
     * Métodos setters y getters
     */
    private void setNombre(String p_nombre){this.nombre = p_nombre;}
    private void setProfesores(ArrayList<Profesor> p_profesores){this.profesores = p_profesores;}
    
    public String getNombre(){return this.nombre;}
    public ArrayList<Profesor> getProfesores(){return this.profesores;}
    
    /**
     * Método para agregar un profesor.
     */
    public boolean agregarProfesor(Profesor p_profesor){
        return this.getProfesores().add(p_profesor);
    }
    
    /**
     * Método para quitar un profesor.
     */
    public boolean quitarProfesor(Profesor p_profesor){
        return this.getProfesores().remove(p_profesor);
    }
    
    /**
     * método que permite imprimir una nomina con los datos de los profesores y su sueldo.
     */
    public void nomina(){
        double monto = 0.0;
        System.out.println("************** Nómina Facultad: " + this.getNombre());
        for(Profesor unProfe: this.getProfesores()){
            System.out.println("----------------------------------------------------");
            System.out.println(unProfe.mostrarLinea());
            monto += unProfe.sueldoTotal();
        }
        System.out.println(" Total a pagar: $" + monto);
    }
    
    /**
     * Listar con detalles a todos los profesores.
     */
    public void listarProfesoresCargos(){
        int cant = 0;
        System.out.println("\n\n***** Detalle de Profesores y cargos de Facultad: " + this.getNombre() + " *****");
        for(Profesor unProfe: this.getProfesores()){
            unProfe.mostrar();
            System.out.println("\n------------------  **** ------------------- \n");
            cant ++;
        }
        System.out.println("    Hay " + cant + " profesores.\n");
    }
}