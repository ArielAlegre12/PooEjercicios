/**
 * clase Alumno para calificar.
 * <p>
 * Ayuda a saber si el alumno esta aprobado o no, dependiendo
 * de si aprobó los dos examenes con nota mayor o igual a 6
 * y si el promedio es mayor a 7, a traves de distintos métodos.
 * @author Ariel, Agustín Antoniow
 * @version 1.0
 */
import java.util.Calendar;
public class Alumno extends Persona{
    private int lu;
    private double nota1;
    private double nota2;
    /**
     * Creo el constructor
     * @param lu libreta universitaria
     * @param nota1 (primera nota)
     * @param nota2 (segunda nota)
     */
    public Alumno(int p_lu, String p_nombre, String p_apellido, int p_dni, Calendar p_fecha, double p_nota1, double p_nota2){
        super(p_dni, p_nombre, p_apellido, p_fecha);
        this.setLu(p_lu);
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
   
    //método que obtiene true o false dependiendo si aprueba o no
    private boolean aprueba(){
        if(this.promedio() > 7 && this.getNota1() >= 6 && this.getNota2() >= 6){
            return true;
        }else{
            return false;
        }
    }
    
    private String leyendaAprueba(){
        if (this.aprueba()){
            return "APROBADO";
        }else{
            return "DESAPROBADO";
        }
    }
    
    public double promedio(){
        return (this.getNota1() + this.getNota2()) / 2;
    }
    
    public void mostrar(){
        super.mostrar();
        System.out.println("LU: " + this.getLu() + "\t" + "Notas: " + this.getNota1() + " - " + getNota2());
        System.out.println("Promedio: " + this.promedio() + " - " + this.leyendaAprueba());
    }
}