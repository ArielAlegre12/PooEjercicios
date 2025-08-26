import java.util.Scanner;

public class CircuferenciaWhile{
    public static void main(String args[]){
        int opcion = 1;
        int radio = 0;
        Scanner teclado = new Scanner(System.in);
        
        while(opcion == 1){
            System.out.println("Ingrese el radio de la circuferencia: ");
            radio = teclado.nextInt();
            double perimetro = 2 * Math.PI * radio;
            
            System.out.println("El perimetro es: " + perimetro);
            System.out.println("¿Desea calcular otra circuferencia?(1-si. 0-no)");
            opcion = teclado.nextInt();
        }
        
    }
}