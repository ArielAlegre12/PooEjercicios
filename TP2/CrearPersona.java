/**
 * Clase ejecutable que crea una persona con datos constantes.
 * <p>
 * Asigna los datos de la persona como constantes, crea el objeto Persona
 * y finalmente muestra sus datos por pantalla a traves del método {@code mostrar()}.
 * @author Alegre Ariel, Agustín Antoniow.
 * @version 1.0
 */
public class CrearPersona{
    public static void main(String args[]){
        int nroDni =  35123456;
        String nombre = "Juan";
        String apellido = "Peréz";
        int anioNacimiento = 2003;
        
        Persona p = new Persona(nroDni, nombre, apellido, anioNacimiento);
        p.mostrar();
    }
}