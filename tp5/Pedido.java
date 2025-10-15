import java.util.*;
import java.util.ArrayList;

/**
 * Clase pedido que permite mostrar los pedidos de las prendas.
 */
public class Pedido{
    private ArrayList<Renglon> renglones;
    
    /**
     * Constructor que inicializa con un array de renglones.
     * @param p_renglones renglones del pedido.
     */
    public Pedido(ArrayList<Renglon> p_renglones){
        this.setRenglones(p_renglones);
    }
    
    /**
     * método que recibe 1 sólo renglon
     */
    public Pedido(Renglon p_renglon){
        this.setRenglones(new ArrayList<Renglon>());
        this.agregarRenglon(p_renglon);
    }
    
    //setters
    private void setRenglones(ArrayList<Renglon> p_renglones){this.renglones = p_renglones;}
    
    //getters
    public ArrayList<Renglon> getRenglones(){return this.renglones;}
    
    //agregar un renglón
    public boolean agregarRenglon(Renglon p_renglon){
        return this.getRenglones().add(p_renglon);
    }
    
    //quitar un renglón
    public boolean quitarRenglo(Renglon p_renglon){
        if(this.getRenglones().size() > 0){
            return this.getRenglones().remove(p_renglon);
        }else{
            System.out.println("\nError. No se puede eliminar más renglones.");
            return false;
        }
    }
    
    /**
     * método para mostrar los renglones.
     */
    public void mostrar(){
        int cantEtiquetas = 0;
        double montoTotal = 0.0;
        System.out.println("\nPedido:");
        System.out.println("Cantidad de items: " + this.getRenglones().size());
        for(Renglon unRenglon: this.getRenglones()){
            unRenglon.mostrar();
            System.out.printf("Precio $: %.2f\n", unRenglon.getItem().precio(unRenglon.getCantidad()));
            cantEtiquetas += unRenglon.getCantidad();
            montoTotal += unRenglon.getItem().precio(unRenglon.getCantidad());
        }
        System.out.printf("--- Total Pedido: %d Etiquetas por un importe total de: $%.2f", cantEtiquetas, montoTotal);
    }
}
