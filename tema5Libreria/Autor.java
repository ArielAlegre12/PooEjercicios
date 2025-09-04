/**
 * Clase autor que contendra el nombre de un autor y lo mostrara
 */
public class Autor{
    private String nombre;
    
    public Autor(String p_nombre){
        this.setNombre(p_nombre);
    }
    
    private void setNombre(String p_nombre){this.nombre = p_nombre;}
    public String getNombre(){return this.nombre;}
    
    public void mostrar(){
        System.out.println("Autor: " + this.getNombre());
    }
}