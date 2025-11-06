
/**
 * Write a description of class Estudiante here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class Estudiante extends Socio
{
    private String carrera;
    
    public Estudiante(String p_carrera, int p_dniSocio, String p_nombre, int p_diasPrestamo, ArrayList<Prestamo> p_prestamos){
        super(p_dniSocio, p_nombre, p_diasPrestamo, p_prestamos);
        this.setCarrera(p_carrera);
    }
    
    public Estudiante(String p_carrera, int p_dniSocio, String p_nombre, int p_diasPrestamo, Prestamo p_prestamo){
        super(p_dniSocio, p_nombre, p_diasPrestamo, p_prestamo);
        this.setCarrera(p_carrera);
    }
    
    public Estudiante(String p_carrera, int p_dniSocio, String p_nombre, int p_diasPrestamo){
        super(p_dniSocio, p_nombre, p_diasPrestamo);
        this.setCarrera(p_carrera);
    }
    
    private void setCarrera(String p_carrera){
        this.carrera = p_carrera;
    }
    
    public String getCarrera(){
        return carrera;
    }
    
    public boolean puedePedir(){
        if(super.puedePedir() && this.catLibrosPrestados() <= 3 ){
            return true;
        }else{
            return false;
        }
    }
    
    public String soyDeLaClase(){
        return "Estudiante";
    }
}