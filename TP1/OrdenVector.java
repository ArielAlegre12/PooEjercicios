import java.util.Scanner;

public class OrdenVector{
    public static void main(String args[]){
        Scanner teclado = new Scanner(System.in);
        teclado.useDelimiter("\n");
        
        double vector[] = new double[4];
        double menor = 999;
        
        System.out.println("Ingrese un vector de 4 elementos");
        for (int i = 0; i < 4; i++){
            System.out.println("Elemento : " + (i + 1));
            vector[i] = teclado.nextInt();
        }
        //obtener menor
        for(int i = 0; i < 4; i++){
            if(vector[i] < menor){
                menor = vector[i];
            }
        }
        //ordenamiento burbuja
        for(int i = 0; i < vector.length - 1; i++){
            for(int j = 0; j < vector.length - 1 - i; j++){
                if(vector[j] > vector[j + 1]){
                    double temp = vector[j];
                    vector[j] = vector[ j + 1];
                    vector[j + 1] = temp;
                }
            }
        }
        System.out.println("El menor elemento del vector es: " + menor);
        System.out.println("El vector ordenado de menor a mayor queda asi: ");
        for(int i = 0; i < 4; i++){
            System.out.print(vector[i] + "\t");
        }
    }
}