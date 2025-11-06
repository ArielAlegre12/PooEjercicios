
/**
 * Write a description of class Docente here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import java.util.Calendar;

public class Docente extends Socio
{
    private String area;
    
    
    public Docente(String p_area, int p_dniSocio, String p_nombre, int p_diasPrestamo, ArrayList<Prestamo> p_prestamos){
        super(p_dniSocio, p_nombre, p_diasPrestamo, p_prestamos);
        this.setArea(p_area);
    }
    
    public Docente(String p_area, int p_dniSocio, String p_nombre, int p_diasPrestamo, Prestamo p_prestamo){
        super(p_dniSocio, p_nombre, p_diasPrestamo, p_prestamo);
        this.setArea(p_area);
    }
    
    public Docente(String p_area, int p_dniSocio, String p_nombre, int p_diasPrestamo){
        super(p_dniSocio, p_nombre, p_diasPrestamo);
        this.setArea(p_area);
    }
    
    private void setArea(String p_area){
        this.area = p_area;
    }
    
    public String getArea(){
        return this.area;
    }
    
    public boolean esResponsable(){
        if(this.puedePedir()){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean puedePedir(){
         return super.puedePedir();
    }
    
    public void cambiarDiasDePrestamo(int p_dias){
        if(esResponsable() == true){
           this.setDiasPrestamo(this.getDiasPrestamos() + p_dias); 
    }else{
        System.out.println("No puede añadir dias porque no es responsable");
    }
    }
    
    public String soyDeLaClase(){
        return "Docente";
    }
}
