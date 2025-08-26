/**
 * Clase de tipo ejecutable de Punto.
 * <p>
 * permite calcular la distancia desde el punto 1 al punto 2.
 * recibe 4 argumentos por la linea de comando que representan
 * las coordenadas de dos puntos del plano cartesiano, x1, y1, x2, y2.
 * Despues instancia dos objetos {@code Punto} y calcula la distancia
 * entre ellos con el método {@code distanciaA()}
 * 
 * @Author Alegre Ariel, Antoniow Agustín.
*/
public class CrearPunto{
    public static void main(String args[]){
        if(args.length < 4){
            System.out.println("Debe ingresar 4 argumentos asi por ej 'x1', 'y1', 'x2', 'y2'):");
        }else{
            double x1 = Double.parseDouble(args[0]);
            double y1 = Double.parseDouble(args[1]);
            double x2 = Double.parseDouble(args[2]);
            double y2 = Double.parseDouble(args[3]);
            
            Punto p1 = new Punto(x1, y1);
            Punto p2 = new Punto(x2, y2);
            
            double distancia = p1.distanciaA(p2);
            System.out.println("Distancia entre p1 y p2: " + distancia);
        }
        
    }
}