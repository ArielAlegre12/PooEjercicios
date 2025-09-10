import java.util.Calendar;
import java.util.*;
import java.text.SimpleDateFormat;
/**
 * Clase Pedido el cual puede manejar 1 o más productos.
 * trabajando con colecciones y conocimiento entre clases.
 */
public class Pedido{
    private Calendar fecha;
    private Cliente cliente;
    private ArrayList<Producto> productos;
    
    /**
     * Constructor el cual recibe una lista de productos.
     * @param p_fecha fecha del pedido
     * @param   p_cliente cliente que hace el pedido.
     * @param p_productos arrays que contiene los productos.
     */
    public Pedido(Calendar p_fecha, Cliente p_cliente, ArrayList<Producto> p_productos){
        this.setFecha(p_fecha);
        this.setCliente(p_cliente);
        this.setProductos(p_productos);
    }
    /**
     * Constructor el cual recibe sólo un producto.
     */
    public Pedido(Calendar p_fecha, Cliente p_cliente, Producto p_producto){
        this.setFecha(p_fecha);
        this.setCliente(p_cliente);
        this.setProductos(new ArrayList<Producto>());
        this.agregarProducto(p_producto);
    }

    /**
     * Método para agregar un procuto.
     */
    public boolean agregarProducto(Producto p_productos){
        return this.getProductos().add(p_productos);
    }
    /**
     * Método para quitar un producto.
     */
    public boolean quitarProducto(Producto p_producto){
        return this.getProductos().remove(p_producto);
    }
    /**
     * Métodos setters y getters.
     */
    private void setFecha(Calendar p_fecha){this.fecha = p_fecha;}
    private void setCliente(Cliente p_cliente){this.cliente = p_cliente;}
    private void setProductos(ArrayList<Producto> p_productos){this.productos = p_productos;}
    
    public Calendar getFecha(){return this.fecha;}
    public Cliente getCliente(){return this.cliente;}
    public ArrayList<Producto> getProductos(){return this.productos;}
    
    /**
     * Método que devuelve el precio contado de los productos.
     */
    public double totalAlContado(){
        double total = 0.0;
        for(Producto unProducto: this.getProductos()){
            total += unProducto.precioContado();
        }
        return total;
    }
    /**
     * Método que devuelve el precio de lista de los productos.
     */
    public double   totalFinanciado(){
        double total = 0.0;
        for(Producto unProducto: this.getProductos()){
            total += unProducto.precioLista();
        }
        return total;
    }
    /**
     * Método para visualizar los detalles del pedido del cliente.
     * utilizo un for each, tambien genero dos var temporales las cuales guardan el
     * valor del precio de lista y contado pero con sólo dos decimales.
     * tambien uso printf para alinear las columnas con mejor precisión,
     * -20s imprime el texto alineado a la izquierda ocupando 20 espacios.
     * 15s imprime el texto a la derecha, ocupando 15 espacios.
     * 20s imprime el texto a la derecha, ocupando 20 espacios.
     */
    public void mostrarPedido(){
        
        SimpleDateFormat formato = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy");
        System.out.println("****** Detalle del pedido ****** Fecha: " + formato.format(this.getFecha().getTime()));
        System.out.println();
        System.out.printf("%-20s %15s %20s\n", "Producto", "Precio Lista", "Precio Contado");
        System.out.println("--------------------------------------------------------");

        for(Producto unProducto : this.getProductos()){
            System.out.printf("%-20s %15.2f %20.2f\n",
            unProducto.getDescripcion(),
            unProducto.precioLista(),
            unProducto.precioContado());
        }

        System.out.println("--------------------------------------------------------");
        System.out.printf("***  Total ------ %15.2f %20.2f\n", this.totalFinanciado(), this.totalAlContado());
}

}