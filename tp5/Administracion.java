/**
 * Clase Administracion, ejecutable que permite interacturar con la clase Jardin 
 * y sus opciones.
 * tiene un menú interactivo.
 */
import java.util.Scanner;
public class Administracion{
    static Scanner teclado = new Scanner(System.in);
    public static void main(String args[]){
        Jardin jardin1 = crearJardin();
        menu(jardin1);
    }
    
    //método para instanciar un cuadrado
    public static Cuadrado crearCuadrado(){
        System.out.println("\n--- Crear Cuadrado ---");
        System.out.println("Ingrese el origen: ");
        System.out.print("Valor de x: ");
        double x = teclado.nextDouble();
        System.out.println("Valor de y: ");
        double y = teclado.nextDouble();
        Punto origen = new Punto(x, y);
        System.out.print("Ingrese el valor de los lados: ");
        double lados = teclado.nextDouble();
        return new Cuadrado(origen, lados);
    }
    
    //método para instanciar un triangulo
    public static Triangulo crearTriangulo(){
        System.out.println("\n--- Crear Triángulo ---");
        System.out.println("Ingrese el origen: ");
        System.out.print("Valor de x: ");
        double x = teclado.nextDouble();
        System.out.println("Valor de y: ");
        double y = teclado.nextDouble();
        Punto origen = new Punto(x, y);
        System.out.print("Ingrese la base: ");
        double base = teclado.nextDouble();
        System.out.print("Ingrese la altura: ");
        double altura = teclado.nextDouble();
        return new Triangulo(base, altura, origen);
    }
    
    //metodo para instanciar un rectangulo
    public static Rectangulo crearRectangulo(){
        System.out.println("\n--- Crear Rectangulo ---");
        System.out.println("Ingrese el origen: ");
        System.out.print("Valor de x: ");
        double x = teclado.nextDouble();
        System.out.println("Valor de y: ");
        double y = teclado.nextDouble();
        Punto origen = new Punto(x, y);
        System.out.print("Ingrese el valor del lado1: ");
        double lado1 = teclado.nextDouble();
        System.out.print("Ingrese el valor del lado2: ");
        double lado2 = teclado.nextDouble();
        return new Rectangulo(origen, lado1, lado2);
    }
    
    //metodo para instanciar un circulo
    public static Circulo crearCirculo(){
        System.out.println("\n--- Crear Circulo ---");
        System.out.println("Ingrese el centro: ");
        System.out.print("Valor de x: ");
        double x = teclado.nextDouble();
        System.out.println("Valor de y: ");
        double y = teclado.nextDouble();
        Punto centro = new Punto(x, y);
        System.out.print("Ingrese el radio: ");
        double radio = teclado.nextDouble();
        return new Circulo(radio, centro);
    }
    
    //método para instanciar un jardin
    public static Jardin crearJardin(){
        System.out.print("\nIngrese el nombre del Jardin: ");
        String nombre = teclado.nextLine();
        return new Jardin(nombre);
    }
    
    //método para eliminar figura seleccionada, a traves de un indice.
    public static void eliminarFigura(Jardin p_jardin){
        int indice = 0;
        for(int i = 0; i < p_jardin.getFiguras().size(); i++){
            System.out.println((i + 1) + ". " + p_jardin.getFiguras().get(i).nombreFigura() + " Superficie: " + p_jardin.getFiguras().get(i).superficie());
            System.out.println();
        }
        System.out.println("Selecione el indice de la figura que desa eliminar: ");
        indice = teclado.nextInt();
        for(int i = 0; i <= p_jardin.getFiguras().size(); i++){
            if((i + 1) == indice){
                p_jardin.quitarFigura(p_jardin.getFiguras().get(i));
                System.out.println("\nEliminado\n");
                break;
            }
        }
    }
    
    //método del menú
    public static void menu(Jardin p_jardin){
        int opcion = 0;
        do{
            System.out.println("\n**** MENÚ JARDIN: " + p_jardin.getNombre() + " ****\n");
            System.out.println("1. Crear figura 1(cuadrado).");
            System.out.println("2. Crear figura 2(triángulo).");
            System.out.println("3. Crear figura 3(circulo).");
            System.out.println("4. crear figura 4(rectangulo).");
            System.out.println("5. Eliminar figura.");
            System.out.println("6. Ver cuantos metros ocupa.");
            System.out.println("7. Ver detalles de figuras.");
            System.out.println("8. Salir");
            System.out.print("Opcion: ");
            opcion = teclado.nextInt();
            
            switch(opcion){
                case 1:
                    Cuadrado cuadrado = crearCuadrado();
                    p_jardin.agregarFigura(cuadrado);
                    break;
                case 2:
                    Triangulo triangulo = crearTriangulo();
                    p_jardin.agregarFigura(triangulo);
                    break;
                case 3:
                    Circulo circulo = crearCirculo();
                    p_jardin.agregarFigura(circulo);
                    break;
                case 4:
                    Rectangulo rectangulo = crearRectangulo();
                    p_jardin.agregarFigura(rectangulo);
                    break;
                case 5:
                    eliminarFigura(p_jardin);
                    break;
                case 6:
                    System.out.println("Se necesita " + p_jardin.cuantosMetros() + " metros\n");
                    break;
                case 7:
                    p_jardin.detalleFiguras();
                    break;
                case 8:
                    System.out.println("Saliendo!.");
                    break;
                default:
                    System.out.println("Invalido. Ingrese otra opcion!\n");
                    break;
            }
        }while(opcion != 8);
    }
}