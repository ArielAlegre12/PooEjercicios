import java.util.ArrayList;
public class Libro
{
   private String titulo;
   private int edicion;
   private String editorial;
   private int anio;
   private ArrayList<Prestamo>prestamos;
   
   public Libro(String p_titulo, int p_edicion, String p_editorial,int p_anio,ArrayList<Prestamo> p_prestamos){
       this.setTitulo(p_titulo);
       this.setEdicion(p_edicion);
       this.setEditorial(p_editorial);
       this.setAnio(p_anio);
       this.setPrestamos(p_prestamos);
   }
   public Libro(String p_titulo, int p_edicion, String p_editorial,int p_anio,Prestamo p_prestamos){
       this.setTitulo(p_titulo);
       this.setEdicion(p_edicion);
       this.setEditorial(p_editorial);
       this.setAnio(p_anio);
       this.setPrestamos(new ArrayList<Prestamo>());
   }
   public Libro(String p_titulo, int p_edicion, String p_editorial,int p_anio){
       this.setTitulo(p_titulo);
       this.setEdicion(p_edicion);
       this.setEditorial(p_editorial);
       this.setAnio(p_anio);
       this.setPrestamos(new ArrayList<Prestamo>());
   }
   public String getTitulo(){
       return this.titulo;
   }
   public int getEdicion(){
       return this.edicion;
   }
   public String getEditorial(){
       return this.editorial;
   }
   public int getAnio(){
       return this.anio;
   }
   public ArrayList<Prestamo> getPrestamos(){
       return this.prestamos;
   }
   private void setTitulo(String p_titulo){
       this.titulo=p_titulo;
   }
   private void setEdicion(int p_edicion){
       this.edicion =p_edicion;
   }
   private void setEditorial(String p_editorial){
       this.editorial =p_editorial;
   }
   private void setAnio(int p_anio){
       this.anio =p_anio;
   }
   private void setPrestamos(ArrayList<Prestamo> p_prestamos){
       this.prestamos= p_prestamos;
   }
   public boolean agregarPrestamo(Prestamo p_prestamos){
       return this.getPrestamos().add(p_prestamos);
   }
   public boolean quitarPrestamo(Prestamo p_prestamo){
       return this.getPrestamos().remove(p_prestamo);
   }
   
   public boolean prestado(){
       if(this.getPrestamos().size() > 0){
           return true;
       }else{
           return false;
       }
   }

   public String toString(){
       return "titulo:" + this.getTitulo();
   }
   
   public Prestamo ultimoPrestamo(){
       if(!this.getPrestamos().isEmpty()){
           return this.getPrestamos().get(this.getPrestamos().size()-1);
       }else{
           System.out.println("No tiene prestamos!");
           return null;
       }
   }
   
}
