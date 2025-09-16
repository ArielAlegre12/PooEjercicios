/**
 * Clase ejecutable para probar la funcionalidad de la clase {@code Producto}.
 * <p>
 * Instancia un laboratorio y un producto asociado, simula una carga inicial de stock
 * por promoción, una baja por destrucción, y muestra los datos del producto en cada paso.
 * También calcula y muestra el precio de lista y el precio al contado.
  * Esta clase verifica el funcionamiento de los métodos {@code ajuste()}, {@code mostrar()},
 * {@code precioLista()} y {@code precioContado()} de la clase {@code Producto}.
 * 
 * @Author Alegre Ariel, Antoniow Agustín.
 */
public class GestionStock{
    public static void main(String args[]){
        Laboratorio unLab = new Laboratorio("Colgate S.A", "Scalabrini  Ortiz 5524", " 54-11 -4239-8447");
        Producto unProducto = new Producto(1, "Perfumeria", "Jabón Deluxe", 5.25, unLab);
        
        unProducto.ajuste(500);
        unProducto.mostrar();
        unProducto.ajuste(-200);
        unProducto.mostrar();
        unProducto.precioLista();
        unProducto.precioContado();
    }
}