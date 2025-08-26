import java.util.Scanner;

public class OperarVector{
    public static void main(String args[]){
     Scanner teclado = new Scanner (System.in);
     
     int notas[] = new int [5];
     int acum = 0;
     double promedio = 0;
     int mayorNota = 0;
     
     System.out.println("Ingrese las 5 notas del alumno: ");
     
     for(int i = 0; i < 5; i++){
         System.out.println("Nota " + (i +1) + ": ");
         notas[i] = teclado.nextInt();
         System.out.println("");
         acum = (acum + notas[i]); 
         if (mayorNota <= notas[i]){
             mayorNota = notas[i];
         }
     }
     
     promedio = (acum / 5);
     
     System.out.println("El promedio es : " + promedio);
     System.out.println("La mayor nota es: " + mayorNota);
     
     
    }
}