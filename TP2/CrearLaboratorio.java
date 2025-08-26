/**
 * Clase ejecutable que crea un laboratorio.
 * <p>
 * Asigna los datos del laboratorio como constantes, crea el objeto correspondiente
 * y muestra su información mediante el método {@code mostrar()}.
 * @author Alegre Ariel, Agustín Antoniow
 * @version 1.0
 */
public class CrearLaboratorio{
    public static void main(String args[]){
        String nombre = "Colgate S.A";
        String domicilio = "Junín 5204";
        String telefono = "54-11 -4239-8447";
        
        Laboratorio l = new Laboratorio(nombre, domicilio, telefono);
        System.out.println(l.mostrar());
    }
}