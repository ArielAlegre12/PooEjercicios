public class Circuferencia{
    public static void main(String args[]){
        if(args.length > 0){
            int radio = Integer.parseInt(args[0]);
            double perimetro = 2 * Math.PI * radio;
            System.out.println("El perimetro de la circuferencia es: " + perimetro);
            
        } else{
            System.out.println("Por favor, ingrese el radio como argumento.");
        }
    }
}


