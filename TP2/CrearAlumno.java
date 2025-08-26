/**
 * Crea una clase ejecutable de un alumno.
 * <p>
 * Debe recibir 3 argumentos de lo contrario muestra un mensaje de error, finalmente visualiza los datos.
 * @author Alegre Ariel, Agustín Antoniow.
 * @version 1.0
 * 
 */
public class CrearAlumno{
    public static void main(String args[]){
        if(args.length < 3){
            System.out.println("Error: debe ingresar 5 argumentos(libreta universitaria, nombre, apellido, nota1 y nota2)");
            return;
        }
        int lu = Integer.parseInt(args[0]);
        String nombre = args[1];
        String apellido = args[2];
        
        Alumno unAlumno = new Alumno(lu, nombre, apellido);
        unAlumno.mostrar();
    }
}