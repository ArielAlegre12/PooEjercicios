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
        this.setNombre(p_nombre);
        this.setDomicilio(p_domicilio);
        this.setDirector(p_director);
        this.setDocente(p_docente);
    }
    /**
     * métodos setters
     */
    private void setNombre(String p_nombre){
        this.nombre = p_nombre;
    }
    private void setDomicilio(String p_domicilio){
        this.domicilio = p_domicilio;
    }
    private void setDirector(String p_director){
        this.director = p_director;
    }
    private void setDocente(Docente p_docente){
        this.docente = p_docente;
    }
    /**
     * métodos getters
     */
    public String getNombre(){
        return this.nombre;
    }
    public String getDomicilio(){
        return this.domicilio;
    }
    public String getDirector(){
        return this.director;
    }
    public Docente getDocente(){
        return this.docente;
    }
    /**
     * método para imprimir el recibo del docente
     */
    public void imprimirRecibo(Docente p_docente){
        System.out.println("Escuela: " + this.getNombre() + "  Domicilio: " + this.getDomicilio() + "  " + " Director: " + getDirector());
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Docente:   " + p_docente.getNombre());
        System.out.println("Sueldo:------------------- $" + p_docente.calcularSueldo());
        System.out.println("Sueldo basico------------- $" + p_docente.getSueldoBasico());
        System.out.println("Asignación basica--------- $" + p_docente.getAsiFamiliar());
    }
}