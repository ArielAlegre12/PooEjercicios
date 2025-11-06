
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class Biblioteca
{
    /**
     * Atributos de la clase
     */
   private String nombre;
   private ArrayList<Socio> socios;
   private ArrayList<Libro> libros;
   
    /**
    *Constructor con parametros, instancia un objeto de la clase
    *@param String p_nombre
    *@param ArrayList<Socio> p_socios
    *@param ArrayList<Libro> p_libros
    */
   public Biblioteca(String p_nombre){
      this.setNombre(p_nombre);
      this.setSocios(new ArrayList<Socio>());
      this.setLibros(new ArrayList<Libro>());
   
   }
   
    /**
    *Constructor con parametros, instancia un objeto de la clase
    *@param ArrayList<Socio> p_socios
    *@param ArrayList<Libro> p_libros
    */
   
    public Biblioteca(ArrayList<Socio> p_socios,ArrayList<Libro> p_libros){
      this.setSocios(p_socios);
      this.setLibros(p_libros);
   
   }
   
   private void setNombre(String p_nombre){
       this.nombre = p_nombre;
   }
   
    /**
    *Setter,recibe un ArrayList y permite modificar el valor de el atributo socios
    *@param ArrayList<Socio> p_socios
    */
   private void setSocios(ArrayList<Socio> p_socios){
       this.socios = p_socios;
   }
   
    /**
    *Setter,recibe un ArrayList y permite modificar el valor de el atributo libros
    *@param ArrayList<Libro> p_libros
    */
   private void setLibros(ArrayList<Libro> p_libros){
       this.libros = p_libros;
   }
   
   
    
    /**
    *Getter, permite obtener el valor de el atributo nombre
    *@return devuelve un String
    */
   public String getNombre(){
       return this.nombre;
   }
   
    
    /**
    *Getter, permite obtener el valor de el atributo socios
    *@return devuelve un ArrayList
    */
   public ArrayList<Socio> getSocios(){
       return this.socios;
       
   }
    
    /**
    *Getter, permite obtener el valor de el atributo libros
    *@return devuelve un ArrayList
    */
   public ArrayList<Libro> getLibros(){
          return this.libros;
   }
   
   
    /**
     * Metodo publico, permite agregar un socio a la lista de socios
     * @param Socio p_socios
     * @return devuelve un boolean
    */
   public boolean agregarSocio(Socio p_socios){
       return this.getSocios().add(p_socios);
   }
   
    /**
     * Metodo publico, permite quitar un socio a la lista de socios
     * @param Socio p_socios
     * @return devuelve un boolean
    */
   public boolean quitarSocio(Socio p_socios){
       if(this.getSocios().size()>0){
            return this.getSocios().remove(p_socios);
       }
       return false;
       
   }
   
   
    /**
     * Metodo publico, permite agregar un libro a la lista de libros
     * @param Libro p_libros
     * @return devuelve un boolean
    */
   public boolean agregarLibro(Libro p_libros){
        return this.getLibros().add(p_libros);
   }
   
    /**
     * Metodo publico, permite quitar un libro a la lista de libros
     * @param Libro p_libros
     * @return devuelve un boolean
    */
   public boolean quitarLibro(Libro p_libros){
             if(this.getLibros().size()>0){
            return this.getLibros().remove(p_libros);
       }
       return false;
       
   }
   
    
    /**
     * Metodo publico, permite contar la cantida de socios por tipo
     * @param String p_tipo
     * @return devuelve un int
    */
   public int cantidadDeSociosPorTipo(String p_tipo){
       int contador = 0;
       
       for(Socio socios:this.getSocios()){
           if(socios.soyDeLaClase().equals(p_tipo)){
               contador+=1;
           }
       }
       return contador;
   }
   
    
    /**
     * Metodo publico, permite obtener los prestamos vencidos
     * @return devuelve un ArrayList
    */
  public ArrayList<Prestamo> prestamosVencidos() {
        ArrayList<Prestamo> prestamosVencidos = new ArrayList<>();
        Calendar fechaHoy = new GregorianCalendar();
        for (Libro libro : this.getLibros()) {
            Prestamo ultimoPrestamo = libro.ultimoPrestamo();
            if (ultimoPrestamo != null && ultimoPrestamo.vencido(fechaHoy)) {
                  prestamosVencidos.add(ultimoPrestamo);
             }
         }
        return prestamosVencidos;
    }
   

   
    
    /**
     * Metodo publico, devuelve una lista con socios
    */
   public String listaDeSocios() {
    String listaSocios = "Lista de Socios:\n";

      
            for (Socio socio : this.getSocios()) {
            listaSocios += ") " + socio.toString() + "\n";  // Concatenamos
        }

            // Agregamos el conteo de socios por tipo
                listaSocios += "**************************************\n";
            listaSocios += "Cantidad de Socios del tipo Estudiante: " + this.cantidadDeSociosPorTipo("Estudiante") + "\n";
                listaSocios += "Cantidad de Socios del tipo Docente: " + this.cantidadDeSociosPorTipo("Docente") + "\n";
            listaSocios += "**************************************";

            return listaSocios;  // Retornamos la cadena completa
  }
   

  public String listaDeLibros(){
    String listaCompleta = "Lista de libros.";
    ArrayList<Libro> listaLibros = this.getLibros();
    int num = 1;
          
    if(listaLibros != null){
        for(Libro unLibro : listaLibros){
            if(unLibro.prestado() == true){
                listaCompleta += "\n"+"" + (num++) + ")" + unLibro.toString() + "\t"+"Prestado : si";
            }
            else{ listaCompleta += "\n"+"" + (num++) + ")" + unLibro.toString() + "\t"+"Prestado : no";
            }
        }
    } else {
              listaCompleta += "\nLa lista de libros es nula. ";
        }
    return listaCompleta;
  }
  
  public Socio buscarSocio(int p_dni) {
        for (Socio socio : this.getSocios()) {
            if (socio.getDniSocio() == p_dni) {
                return socio;
            }
        }
        return null;
    }
 public String quienTieneElLibro(Libro p_libro) {
    try {
        // Buscar si el libro está prestado
        for (Socio socioAux : this.getSocios()) { // Itera sobre todos los socios
            for (Prestamo prestamoAux : socioAux.getPrestamos()) { // Itera sobre los préstamos del socio
                if (p_libro.equals(prestamoAux.getLibro())) { // Compara el libro
                    return socioAux.getNombre() + " tiene el libro"; // Retorna el nombre del socio que tiene el libro
                }
            }
        }
        
        // Si no se encuentra el libro prestado, lanzamos la excepción
        throw new LibroNoPrestadoException("El libro se encuentra en la biblioteca");
        
    } catch (LibroNoPrestadoException e) {
        // Captura la excepción y retorna el mensaje
        return e.getMessage();
    }
  }
    
  public void nuevoLibro(String p_titulo, int p_edicion, String p_editoral, int p_anio) {
        Libro libro = new Libro(p_titulo, p_edicion, p_editoral, p_anio);
        this.getLibros().add(libro);
    }  
    
  public void nuevoSocioEstudiante(int p_dniSocio, String p_nombre, String p_carrera) {
          int diasPrestamosEst = 0;
           for(Socio socios: this.getSocios()){
               if(socios.soyDeLaClase().equals("Estudiante")){
               diasPrestamosEst+= socios.getDiasPrestamos();
            }
           }
          Estudiante estudiante = new Estudiante(p_carrera,p_dniSocio,p_nombre,diasPrestamosEst);
           this.getSocios().add(estudiante);
    }
    
  public void nuevoSocioDocente(int p_dniSocio, String p_nombre, String p_area) {
         int diasPrestamosDoc = 0;
           for(Socio socios: this.getSocios()){
               if(socios.soyDeLaClase().equals("Docente")){
               diasPrestamosDoc+= socios.getDiasPrestamos();
            }
           }
        Docente docente = new Docente(p_area,p_dniSocio, p_nombre,diasPrestamosDoc);
        this.getSocios().add(docente);
    }  
    
  
  public String listaDeTitulos(){
        String titulos = "";
        for (Libro libro : libros){
            titulos += libro.getTitulo() + "\n";
        }
        return titulos; 
    }
   public boolean prestarLibro(Calendar p_fechaRetiro, Socio p_socio, Libro p_libro) {
           if (p_socio == null || p_libro == null) {
        return false;
        }

        if ( p_socio.puedePedir() && p_libro.prestado() == false) {
            Prestamo unPrestamo = new Prestamo(p_fechaRetiro, p_libro,p_socio);
            p_socio.agregarPrestamo(unPrestamo);
            p_libro.agregarPrestamo(unPrestamo);
            return true;
        } else {
            return false;
        }
    }

        public void devolverLibro(Libro p_libro) {
        Calendar fechaHoy = new GregorianCalendar();     
      for (Libro libro : this.getLibros()) {
            if (libro.equals(p_libro)) {
                if (libro.prestado()) {
                    libro.ultimoPrestamo().registrarFechaDevolucion(fechaHoy);
                }
            }
        }
}
    
    public ArrayList<Docente> docentesResponsables() {
        ArrayList<Docente> docenteResponsables = new ArrayList<Docente>();
        
        for (Socio s : this.getSocios()) {
            if (docenteResponsables!=null && s.soyDeLaClase().equals("Docente")) {
                Docente d = (Docente) s;
                if (d.esResponsable() == true) {
                    docenteResponsables.add(d);
                }
            }
        }
        return docenteResponsables;
    }
    public String listaDeDocentesResponsables() {
        String listaDocentesResp = "Lista de Docentes Responsables: \n";

        for (Socio s : this.docentesResponsables()) {
            if (s != null && s.soyDeLaClase().equals("Docente")) {
                Docente d = (Docente) s;
                if (d.esResponsable() == true) {
                    listaDocentesResp += "\n" + "* " + d.toString();
                } else {
                    listaDocentesResp = "";
                }
            }
        }
        return listaDocentesResp;
    }
}