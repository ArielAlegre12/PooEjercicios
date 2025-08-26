public class Ecuacion{
    public static void main(String args[]){
        if(args.length > 0){
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            int c = Integer.parseInt(args[2]);
            
            double discriminante = (Math.pow (b, 2)) - 4 * a * c;
            
            if (discriminante > 0){
                double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
                double x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
                
                System.out.println("Las raices son: x1 = " + x1 + " y x2 = " + x2);
            }else if(discriminante == 0){
                double raiz =-b / (2.0 * a);
                
                System.out.println("Las raices x1 = x2 = " + raiz);
            }else{
                System.out.println("Es una solución compleja.");
            }
        }
    }
}