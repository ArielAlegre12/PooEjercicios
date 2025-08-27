/**
 * Crear clase Escuela
 */
public class Escuela{
    private String nombre;
    private String domicilio;
    private String director;
    private Docente docente;
    
    /**
     * método constructor
     */
    public Escuela(String p_nombre, String p_domicilio, String p_director, Docente p_docente){
        setNombre(p_nombre);
        setDomicilio(p_domicilio);
        setDirector(p_director);
        setDocente(p_docente);
    }
    /**
     * métodos setters
     */
    private void setNombre(String p_nombre){
        nombre = p_nombre;
    }
    private void setDomicilio(String p_domicilio){
        domicilio = p_domicilio;
    }
    private void setDirector(String p_director){
        director = p_director;
    }
    private void setDocente(Docente p_docente){
        docente = p_docente;
    }
    /**
     * métodos getters
     */
    public String getNombre(){
        return nombre;
    }
    public String getDomicilio(){
        return domicilio;
    }
    public String getDirector(){
        return director;
    }
    public Docente getDocente(){
        return docente;
    }
    /**
     * método para imprimir el recibo del docente
     */
    public void imprimirRecibo(Docente p_docente){
        System.out.println("Escuela: " + getNombre() + "  Domicilio: " + getDomicilio() + "  " + " Director: " + getDirector());
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Docente:   " + p_docente.getNombre());
        System.out.println("Sueldo:------------------- $" + p_docente.calcularSueldo());
        System.out.println("Sueldo basico------------- $" + p_docente.getSueldoBasico());
        System.out.println("Asignación basica--------- $" + p_docente.getAsiFamiliar());
    }
}