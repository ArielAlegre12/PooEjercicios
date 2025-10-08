/**
 * Clase ejecutable que instancia artefactos de un hogar.
 */
import java.util.Scanner;
public class Comercio{
    static Scanner teclado = new Scanner(System.in);
    public static void main(String args[]){
        Heladera hela1 = crearHeladera();
        Cocina coci1 =  crearCocina();
        Lavarropa lava1 = crearLavarropa();
        menu(lava1, coci1, hela1);
    }
    
    //método para instanciar un lavarropa
    public static Lavarropa crearLavarropa(){
        System.out.println("\n*** Crear Lavarropa ***");
        System.out.print("Ingrese la cantidad de programas: ");
        int programas = teclado.nextInt();
        System.out.print("\nIngrese la cantidad de kilos que soporta: ");
        float kilos = teclado.nextFloat();
        System.out.print("\n¿Es automatio? (true o false): ");
        boolean automatico = teclado.nextBoolean();
        teclado.nextLine();
        System.out.print("\nIngrese la marca: ");
        String marca = teclado.nextLine();
        System.out.print("\nIngrese el precio: ");
        float precio = teclado.nextFloat();
        System.out.print("\nIngrese el stock: ");
        int stock = teclado.nextInt();
        return new Lavarropa(programas, kilos, automatico, marca, precio, stock);
    }
    
    //Método para instanciar una heladera
    public static Heladera crearHeladera(){
        System.out.println("\n*** Crear Heladera ***");
        System.out.print("\nIngrese la cantidad de pies de la heladera: ");
        int pies = teclado.nextInt();
        System.out.print("\nIngrese la cantidad de puertas: ");
        int puertas = teclado.nextInt();
        System.out.println("\n¿Tiene compresor?(true o false): ");
        boolean compresor = teclado.nextBoolean();
        teclado.nextLine();
        System.out.print("\nIngrese la marca: ");
        String marca = teclado.nextLine();
        System.out.print("\nIngrese el precio: ");
        float precio = teclado.nextFloat();
        System.out.print("\nIngrese el stock: ");
        int stock = teclado.nextInt();
        return new Heladera(pies, puertas, compresor, marca, precio, stock);
    }
    
    //Método para instanciar una cocina
    public static Cocina crearCocina(){
        System.out.println("\n*** Crear Cocina ***");
        System.out.print("\nIngresar la cantidad de hornillas: ");
        int hornallas = teclado.nextInt();
        System.out.print("\nIngrese la cantidad de calorias: ");
        int calorias = teclado.nextInt();
        teclado.nextLine();
        System.out.print("Ingrese las dimensiones(string): ");
        String dimensiones = teclado.nextLine();
        System.out.print("\nIngrese la marca: ");
        String marca = teclado.nextLine();
        System.out.print("\nIngrese el precio: ");
        float precio = teclado.nextFloat();
        System.out.print("\nIngrese el stock: ");
        int stock = teclado.nextInt();
        return new Cocina(hornallas, calorias, dimensiones, marca, precio, stock);
    }
    
    //Hago un mini menú
    public static void menu(Lavarropa p_lava, Cocina p_coci, Heladera p_hela){
        int opcion;
        do{
            System.out.println("\n---- MENÚ DE COMERCIO ----");
            System.out.println("1. Ver detalles de cocina.");
            System.out.println("2. Ver detalles de Lavarropas.");
            System.out.println("3. Ver detalles de Heladera.");
            System.out.println("4. Salir");
            System.out.println("Opcion: ");
            opcion = teclado.nextInt();
            
            switch(opcion){
                case 1:
                    System.out.println("\nIngrese la cantidad de cuotas: ");
                    int couotasCoci1 = teclado.nextInt();
                    p_coci.imprimir();
                    System.out.printf("Cuotas: %d - Interés: %.2f%%\n", couotasCoci1, p_coci.cuotaCredito(couotasCoci1, 2));
                    System.out.printf("Valor Cuota: %.2f\n", p_coci.cuotaCredito(couotasCoci1, 2));
                    System.out.printf("Valor Cuota Con Adicionales: %.2f\n", p_coci.creditoConAdicional(couotasCoci1, 2));
                    break;
                case 2:
                    System.out.println("\nIngrese la cantidad de cuotas: ");
                    int couotasLava1 = teclado.nextInt();
                    p_lava.imprimir();
                    System.out.printf("Cuotas: %d - Interés: %.2f%%\n", couotasLava1, p_lava.cuotaCredito(couotasLava1, 2));
                    System.out.printf("Valor Cuota: %.2f\n", p_lava.cuotaCredito(couotasLava1, 2));
                    System.out.printf("Valor Cuota Con Adicionales: %.2f\n", p_lava.creditoConAdicional(couotasLava1, 2));
                    break;
                case 3:
                    System.out.println("\nIngrese la cantidad de cuotas: ");
                    int couotasHela1 = teclado.nextInt();
                    p_hela.imprimir();
                    System.out.printf("Cuotas: %d - Interés: %.2f%%\n", couotasHela1, p_hela.cuotaCredito(couotasHela1, 2));
                    System.out.printf("Valor Cuota: %.2f\n", p_hela.cuotaCredito(couotasHela1, 2));
                    System.out.printf("Valor Cuota Con Adicionales: %.2f\n", p_hela.creditoConAdicional(couotasHela1, 2));
                    break;
                case 4:
                    System.out.println("saliendo!");
                    break;
                default:
                    System.out.println("Opcion invalida!");
                    break;
            }
        }while(opcion != 4);
    }
}