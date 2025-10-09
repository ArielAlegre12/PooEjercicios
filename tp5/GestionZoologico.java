import java.util.*;
/**
 * Instanciar un zoologico .
 */
public class GestionZoologico{
    public static void main(String args[]){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el nombre del zoologico: ");
        String nombre = teclado.nextLine();
        
        //instancio el zoologico
        Zoologico unZoo = new Zoologico(nombre);
        
        //instancio un individuos.
        Calendar fechaNacimientoP1 = new GregorianCalendar(2002,10,3);
        Calendar fechaIngreso = new GregorianCalendar(2024,9,22);
        Persona p1 = new Persona(4447372, "María", "Lusteau", fechaNacimientoP1);
        Individuo individuo1 = new Individuo(p1, "María", fechaIngreso);
        //agrego el individuo 1 a zoologico.
        unZoo.nuevoVisitante(individuo1);
        
        //instancio 2 individuos más
        Calendar fechaNacimientoP2 = new GregorianCalendar(1999, 3, 5);
        Calendar fechaNacimientoP3 = new GregorianCalendar(1980, 6, 23);
        Persona p2 = new Persona(37897678, "Martin", "Suarez", fechaNacimientoP2);
        Persona p3 = new Persona(33123321, "Jose", "Perez", fechaNacimientoP3);
        Individuo individuo2 = new Individuo(p2, "Martin", fechaIngreso);
        Individuo individuo3 = new Individuo(p3, "Jose", fechaIngreso);
        
        //instancio la delegacion "PAMI"
        ArrayList<Individuo> individuos = new ArrayList<Individuo>();
        Delegacion pami = new Delegacion(individuos, "PAMI", fechaIngreso);
        pami.inscribirIntegrante(individuo2);
        pami.inscribirIntegrante(individuo3);
        
        
        //agrego al PAMI a la visita del zoo
        unZoo.nuevoVisitante(pami);
        unZoo.listarVisitantePorFecha(fechaIngreso);
        //recaudacion desde 1 de sep hasta 20 de sep
        Calendar fechaDesde = new GregorianCalendar(2024,9,1);
        Calendar fechaHasta = new GregorianCalendar(2024,9,30);
        double recaudacion = unZoo.recaudacion(fechaDesde, fechaHasta);
        System.out.println("La recaudacion de septiembre fue: " + recaudacion);
        
        //listar por tipo de visitante 
        unZoo.listarTipoVisitantePorfecha(fechaIngreso, "delegacion");
    }
}