public class TrianguloRectangulo{
    public static void main(String args[]){
        int hipotenusa = Integer.parseInt(args[0]);
        int cateto1 = Integer.parseInt(args[1]);
        int cateto2 = Integer.parseInt(args[2]);
        
        if(Math.pow(hipotenusa, 2) == Math.pow(cateto1, 2) + Math.pow(cateto2, 2)){
            System.out.println("Es un triangulo rectangulo");
        }else{
            System.out.println("No es un triangulo rectangulo");
        }
    }
}