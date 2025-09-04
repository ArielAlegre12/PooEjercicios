import java.util.*;
import java.util.Scanner;

/**
 * Clase para interactuar con la libreria.
 */
public class Aplicacion{
    static Scanner teclado = new Scanner(System.in);
    public static void main(String args[]){
        System.out.println("Ingrese el nombre de la libreria: ");
        String nombre = teclado.nextLine();
        Libreria unaLibreria = new Libreria(nombre);
        menu(unaLibreria);
    }
    public static Autor crearAutor(){
    System.out.println("\nIngrese el nombre del autor: ");
    String nombre = teclado.nextLine();
    return new Autor(nombre);
}
    public static Libro crearLibro(){
        System.out.println("Ingrese el nombre del libro: ");
        teclado.nextLine();
        String nombre = teclado.nextLine();
        System.out.println("Ingrese el precio del libro: ");
        double precio = teclado.nextDouble();
        teclado.nextLine();
        return new Libro(nombre, precio);
    }
    public static void menu(Libreria p_libreria){
        int opcion;
        do{
            System.out.println("\n1. Agregar un libro.");
            System.out.println("2. Quitar un libro.");
            System.out.println("3. Mostrar Stock Valorizado.");
            System.out.println("4. Mostrar Libreria.");
            System.out.println("5. Editar libro.");
            System.out.println("6. Salir.");
            System.out.println("ELige una opción: ");
            opcion = teclado.nextInt();
            
            switch(opcion){
                case 1:
                    Libro unLibro =  crearLibro();
                    p_libreria.agregarLibro(unLibro);
                    System.out.println("Desea agregar un Autor?(1.si, 2. no): ");
                    int op = teclado.nextInt();
                    teclado.nextLine();
                    if(op == 1){
                    Autor unAutor = crearAutor();
                    unLibro.agregarAutor(unAutor);
                    }else{
                        System.out.println("ok\n");
                        }
                    System.out.println("Hecho");
                    break;
                case 2:
                    ArrayList<Libro> libros = p_libreria.getLibros();
                    quitarLibros(libros, p_libreria);
                    break;
                case 3:
                    p_libreria.stockValorizado();
                    break;
                case 4:
                    p_libreria.mostrar();
                    break;
                case 5:
                    editarLibros(p_libreria.getLibros(), p_libreria);
                case 6:
                    System.out.println("Saliendo");
                    break;
                default:
                    System.out.println("Opción invalida.");
                    break;
            }
        }while(opcion != 6);
    }
    
    public static void quitarLibros(ArrayList<Libro> p_libros, Libreria p_libreria){
        if(p_libros.isEmpty()){
                        System.out.println("No hay libros para quitar.");
                    }else{
                        System.out.println("Libros disponibles:");
                        int cont = 1;
                        for(Libro libro : p_libros){
                            System.out.println(cont + ". " + libro.getTitulo());
                            cont ++;
                        }
                        System.out.println("Ingrese el número de libro que desea quitar: ");
                        int indice = teclado.nextInt() - 1;
                        
                        if(indice >= 0 && indice <  p_libros.size()){
                            Libro libroSeleccionado = p_libros.get(indice);
                            boolean quitado = p_libreria.quitarLibro(libroSeleccionado);
                            if(quitado){
                                System.out.println("Se quito el libro: " + libroSeleccionado.getTitulo());
                            }else{
                                System.out.println("No se pudo quitar el libro.");
                            }
                        }else{
                           System.out.println("Índice invalido"); 
                        }
                    }
    }
    public static void editarLibros(ArrayList<Libro> p_libros, Libreria p_libreria){
        if(p_libros.isEmpty()){
            System.out.println("No hay libros para modificar.");
        }else{
            System.out.println("Libros disponibles: ");
            int cont =  1;
            for(Libro libro: p_libros){
                System.out.println(cont + ". " + libro.getTitulo());
                cont ++;
            }
            System.out.println("Ingrese el número ded libro que desea editar");
            int indice =  teclado.nextInt() -1;
            if(indice >= 0 && indice < p_libros.size()){
                Libro libroSeleccionado = p_libros.get(indice);
                menuLibro(libroSeleccionado);
            }
        }
    }
    
    public static void menuLibro(Libro p_libro){
        int opcion;
        do{
            System.out.println("1. agregar autor.");
            System.out.println("2. quitar autor.");
            System.out.println("3. salir");
            opcion = teclado.nextInt();
            switch(opcion){
                case 1:
                    teclado.nextLine();
                    Autor newAutor = crearAutor();
                    p_libro.agregarAutor(newAutor);
                    System.out.println("Autor agregado.");
                    break;
                case 2:
                    ArrayList<Autor> autores = p_libro.getAutores();
                   if (autores.isEmpty()) {
                    System.out.println("No hay autores.");
                    } else {
                    System.out.println("Lista de autores:");
                    int cont = 1;
                    for (Autor aut : autores) {
                        System.out.println(cont + ". " + aut.getNombre());
                        cont++;
                    }
                    System.out.println("Elija el número de autor que desea quitar:");
                    int indice = teclado.nextInt() - 1;
                    if (indice >= 0 && indice < autores.size()) {
                        Autor autorSeleccionado = autores.get(indice);
                        p_libro.quitarAutor(autorSeleccionado);
                        System.out.println("Autor quitado.");
                       } else {
                          System.out.println("Índice inválido.");
                              }
                            }
                   break;
                case 3:
                    System.out.println("volviendo al menú principal");
                    break;
                default:
                    System.out.println("Opcion invalida!.");
                    break;
            }
            
        }while(opcion != 3);
    }
}