/**
 * clase Alumno para calificar.
 * <p>
 * Ayuda a saber si el alumno esta aprobado o no, dependiendo
 * de si aprobó los dos examenes con nota mayor o igual a 6
 * y si el promedio es mayor a 7, a traves de distintos métodos.
 * @author Ariel, Agustín Antoniow
 * @version 1.0
 */
public class Alumno{
    private int lu;
    private String nombre;
    private String apellido;
    private double nota1;
    private double nota2;
    /**
     * Creo el constructor
     * @param lu libreta universitaria
     * @param nombre (del alumno)
     * @param apellido (del alumno)
     * @param nota1 (primera nota)
     * @param nota2 (segunda nota)
     */
    public Alumno(int p_lu, String p_nombre, String p_apellido, double p_nota1, double p_nota2){
        this.setLu(p_lu);
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setNota1(p_nota1);
        this.setNota2(p_nota2);
    }
    //setters
    public void setNota1(double p_nota){
        this.nota1 = p_nota;
    }
    public void setNota2(double p_nota){
        this.nota2 = p_nota;
    }
    private void setLu(int p_lu){
        this.lu = p_lu;
    }
    private void setNombre(String p_nombre){
        this.nombre = p_nombre;
    }
    private void setApellido(String p_apellido){
        this.apellido = p_apellido;
    }
    //getters
    public double getNota1(){
        return this.nota1;
    }
    public double getNota2(){
        return this.nota2;
    }
    public int getLu(){
        return this.lu;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getApellido(){
        return this.apellido;
    }
    
    /**
     * verifica si el alumno está aprobado o no.
     */
    private boolean aprueba(){
        if(this.promedio() > 7 && this.getNota1() >= 6 && this.getNota2() >= 6){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * devuelve en formato String si el alumno aprobó o no.
     */
    private String leyendaAprueba(){
        if (this.aprueba()){
            return "APROBADO";
        }else{
            return "DESAPROBADO";
        }
    }
    
    /**
     * Retorna el promedio del Alumno.
     */
    public double promedio(){
        return (this.getNota1() + this.getNota2()) / 2;
    }
    
    public String nomYApe(){
        return this.getNombre() + " " + this.getApellido();
    }
    
    public String apeYnom(){
        return this.getApellido() + ", " + this.getNombre();
    }
    
    /**
     * Visualizar información del alumno, como nombre y apellido, libreta universitaria y notas.
     */
    public void mostrar(){
        System.out.println("Nombre y Apellido: " + this.nomYApe());
        System.out.println("LU: " + this.getLu() + "\t" + "Notas: " + this.getNota1() + " - " + this.getNota2());
        System.out.println("Promedio: " + this.promedio() + " - " + this.leyendaAprueba());
    }
}