import java.util.Scanner;
import java.util.*;
import java.util.Calendar;
/**
 * Clase ejecutable que toma el pedido del cliente.
 */
public class TomaPedido{
    static Scanner teclado = new Scanner(System.in);
    public static void main(String args[]){
        Calendar fechaHoy = new GregorianCalendar();
        fechaHoy = Calendar.getInstance();
        Cliente unCliente = crearCliente();
        Producto unProducto = crearProducto();
        unProducto.mostrar();
        Pedido unPedido= new Pedido(fechaHoy, unCliente, unProducto);
        menu(unCliente, unPedido);

    }
    /**
     * Método para crear un cliente y retornar los datos.
     */
    public static Cliente crearCliente(){
        System.out.print("Ingrese el dni: ");
        int dni = teclado.nextInt();
        System.out.print("Ingrese el apellido: ");
        String apellido = teclado.next();
        System.out.print("Ingrese el nombre: ");
        String nombre = teclado.next();
        System.out.print("Ingrese el saldo: ");
        double importe = teclado.nextDouble();
        return new Cliente(dni, apellido, nombre, importe);
    }
    /**
     * Método para crear un laboratorio.
     */
    public static Laboratorio crearLab(){
        teclado.nextLine();
        System.out.print("Ingrese el nombre del laboratorio: ");
        String nombre = teclado.nextLine();
        System.out.print("Ingrese el domicilio: ");
        String domicilio = teclado.nextLine();
        System.out.print("Ingrese el telefono: ");
        String telefono = teclado.nextLine();
        return new Laboratorio(nombre, domicilio, telefono);
    }
    /**
     * Método para crear un producto.
     */
    public static Producto crearProducto(){
        Laboratorio unLab = crearLab();
        System.out.print("Ingrese el codigo del producto: ");
        int cod =  teclado.nextInt();
        System.out.print("Ingrese el rubro: ");
        String rubro = teclado.next();
        System.out.print("Ingrese la descripción: ");
        String desc = teclado.next();
        teclado.nextLine();
        System.out.println("Ingrese el costo: ");
        double costo = teclado.nextDouble();
        return new Producto(cod, rubro, desc, costo, unLab);
    }
    /**
     * Menú iterativo
     */
    public static void menu(Cliente unCliente, Pedido unPedido){
        int opcion;
        do{
            System.out.println("1. Agregar Producto.");
            System.out.println("2. Quitar Producto.");
            System.out.println("3. Visualizar lista.");
            System.out.println("4. salir.");
            opcion = teclado.nextInt();
            
            switch(opcion){
                case 1:
                    Producto otroProducto = crearProducto();
                    unPedido.agregarProducto(otroProducto);
                    System.out.println("\nhecho\n");
                    break;
                case 2:
                    if(unPedido.getProductos().size() > 0){
                        codigosProductos(unPedido);
                        System.out.println("Ingrese el codigo del que desea eliminar: ");
                        int cod = teclado.nextInt();
                        eliminar(cod, unPedido);
                        }else{
                        System.out.println("No hay nada para eliminar.\n");}
                        break;
                case 3:
                    unPedido.mostrarPedido();
                    break;
                case 4:
                    System.out.println("Saliendo.");
                    break;
                default:
                    System.out.println("Opción invalida");
                    break;
                }
        }while(opcion != 4);
    }
    
    /**
     * Muestra la lista de codigo y descripción del producto.
     */
    public static void codigosProductos(Pedido p_unPedido){
        for(Producto unProducto: p_unPedido.getProductos()){
            System.out.println("codigo: " + unProducto.getCodigo() + " Descripcion: " + unProducto.getDescripcion());
        }
    }
    /**
     * Elimina el producto eligiendo su codigo.
     */
    public static void eliminar(int p_cod, Pedido p_unPedido){
        for(Producto unProducto: p_unPedido.getProductos()){
            if(p_cod == unProducto.getCodigo()){
                p_unPedido.quitarProducto(unProducto);
                break;
            }
        }
    }
}
