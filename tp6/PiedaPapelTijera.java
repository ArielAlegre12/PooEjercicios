import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PiedaPapelTijera{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int intentos = 3;
        
        while(intentos > 0){
            System.out.println("Bienvenido al juego de Pieda, Papel o Tijera.");
            System.out.println("Ingresse su elección(1 - Piedra, 2 papel, 3 - Tijera): ");
            
            int eleccion = Integer.parseInt(br.readLine());
            
            if(eleccion >= 1 && eleccion <= 3){
                jugarPiedraPapelTijera(eleccion);
                System.out.println("Fin del Juego.");
                break;
            }else{
                System.out.println("Elija una opción válida(1, 2 o 3).");
            }
        }
        
        if(intentos == 0){
            System.out.println("Ha superado el número máximo de intentos. Salida del juego.");
        }
    }
    
    public static void jugarPiedraPapelTijera(int eleccion){
        int eleccionMaquina = (int) (Math.random() * 3) + 1;
        
        System.out.println("Eleccion de la maquina: " + eleccionMaquina);
        
        if(eleccion == 3 && eleccionMaquina == 2){
            System.out.println("Empaete");
        }else if((eleccion == 1 && eleccionMaquina == 3) || (eleccion == 2 &&
                  eleccionMaquina == 1)){
                      System.out.println("¡Ganaste! :) ");
                  }else{
                      System.out.println("La maquina gana :( ");
                  }
    }
}