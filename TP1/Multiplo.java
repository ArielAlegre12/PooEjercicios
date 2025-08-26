public class Multiplo{
    public static void main(String args[]){
        System.out.println("Los multiplos de 4 son: ");
        for(int i= 42; i<=150; i++ ){
            if ((i % 4) == 0){
                System.out.println(i);
            }
        }
    }
}