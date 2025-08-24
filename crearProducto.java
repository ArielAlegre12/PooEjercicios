/**
 * Creo la clase ejecutable de Producto
 */
public class crearProducto{
    public static void main(String args[]){
        Laboratorio unLab = new Laboratorio("Colgate S.A", "Scalabrini  Ortiz 5524", " 54-11 -4239-8447");
        Producto unProducto = new Producto(1, "Perfumeria", "Jabón Deluxe", 5.25, unLab);
        
        unProducto.ajuste(500);
        unProducto.mostrar();
    }
}