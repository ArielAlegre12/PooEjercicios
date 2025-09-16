/**
 * Clase Curso la cual representa la info de los cursos que se dictan y sus alumnos.
 * @author Alegre Ariel santiago, Antoniow Agustín.
 */
import java.util.*;
public class Curso{
    private String nombre;
    private HashMap alumnos;
    
    /**
     * Constructor que sólo recibe el nombre del curso.
     * @param p_nombre nombre del curso.
     * incializa los alumnos en 0;
     */
    public Curso(String p_nombre){
        setNombre(p_nombre);
        setAlumnos(new HashMap());
    }
    /**
     * Constructor que recibe ademas del nombre del curso, una lista de 1 o más alumnos.
     * @param p_nombre nombre del curso.
     * @param p_alumno lista de 1 o más alumnos del curso.
     */
    public Curso(String p_nombre, HashMap p_alumnos){
        setNombre(p_nombre);
        setAlumnos(p_alumnos);
    }
    /**
     * métodos setters y getters.
     */
    private void setNombre(String p_nombre){this.nombre = p_nombre;}
    private void setAlumnos(HashMap p_alumnos){this.alumnos = p_alumnos;}
    
    public String getNombre(){return this.nombre;}
    public HashMap getAlumnos(){return this.alumnos;}
    /**
     * inscribe un alumno utilizando el método de HashMap, ingreso por clave y valor.
     * hace un casteo al valor.
     * @param p_alumno alumno que se va inscribir en el curso.
     */
    public void inscribirAlumno(Alumno p_alumno){
        this.getAlumnos().put(new Integer(p_alumno.getLu()), p_alumno);
    }
    /**
     * quita un alumno de la colección,
     */
    public Alumno quitarAlumno(int p_lu){
        return (Alumno)this.getAlumnos().remove(new Integer(p_lu));
    }
    /**
     * Conocer la cantidad de alumnos en la colección.
     */
    public int cantidadDeAlumnos(){
        return this.getAlumnos().size();
    }
    /**
     * Saber si un alumno esta inscripto o no a traves de su libreta universitaria.
     */
    public boolean estaInscripto(int p_lu){
        return this.getAlumnos().containsKey(new Integer(p_lu));
    }
    /**
     * método sobrecargado busco por Objeto alumno y no por el lu.
     */
    public boolean estaInscripto(Alumno p_alumno){
        return this.getAlumnos().containsValue(p_alumno);
    }
    /**
     * método para buscar el alumno a traves de su clave (lu).
     * si encuentra el alumno lo retorna.
     */
    public Alumno buscarAlumno(int p_lu){
        return (Alumno)this.getAlumnos().get(new Integer(p_lu));
    }
    /**
     * imprime el promedio del alumno buscado por el método.
     */
    public void imprimirPromedioDelAlumno(int p_lu){
        if(buscarAlumno(p_lu) != null){
            System.out.println("Promedio: " + buscarAlumno(p_lu).promedio());
        }else{
            System.out.println("No existe Alumno con esa Libreta Unversitaria.");
        }
    }
    /**
     * Mostrar los datos de los inscriptos.
     */
    public void mostrarInscriptos(){
        for(Object unAlumno: this.getAlumnos().entrySet()){
            Map.Entry<Integer, Alumno> unAlu = (Map.Entry)unAlumno;
            System.out.println(unAlu.getKey() + " " + unAlu.getValue().nomYApe());
        }
    }
}