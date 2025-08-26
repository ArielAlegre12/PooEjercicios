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
    public Alumno(int p_lu, String p_nombre, String p_apellido){
        setLu(p_lu);
        setNombre(p_nombre);
        setApellido(p_apellido);
    }
    //setters
    public void setNota1(double p_nota){
        nota1 = p_nota;
    }
    public void setNota2(double p_nota){
        nota2 = p_nota;
    }
    private void setLu(int p_lu){
        lu = p_lu;
    }
    private void setNombre(String p_nombre){
        nombre = p_nombre;
    }
    private void setApellido(String p_apellido){
        apellido = p_apellido;
    }
    //getters
    public double getNota1(){
        return nota1;
    }
    public double getNota2(){
        return nota2;
    }
    public int getLu(){
        return lu;
    }
    public String getNombre(){
        return nombre;
    }
    public String getApellido(){
        return apellido;
    }

    //método que obtiene true o false dependiendo si aprueba o no
    private boolean aprueba(){
        if(promedio() > 7 && getNota1() >= 6 && getNota2() >= 6){
            return true;
        }else{
            return false;
        }
    }
    
    private String leyendaAprueba(){
        if (aprueba()){
            return "APROBADO";
        }else{
            return "DESAPROBADO";
        }
    }
    
    public double promedio(){
        return (getNota1() + getNota2()) / 2;
    }
    
    public String nomYApe(){
        return getNombre() + " " + getApellido();
    }
    
    public String apeYnom(){
        return getApellido() + ", " + getNombre();
    }
    
    public void mostrar(){
        System.out.println("Nombre y Apellido: " + nomYApe());
        System.out.println("LU: " + getLu() + "\t" + "Notas: " + getNota1() + " - " + getNota2());
        System.out.println("Promedio: " + promedio() + " - " + leyendaAprueba());
    }
}