/**
 * Clase jardin que representa el manejo de pinturas de figuras en el jardin.
 * recibe un array de figuras.
 */
import java.util.*;
import java.util.ArrayList;

public class Jardin{
    private String nombre;
    private ArrayList<FiguraGeometrica> figuras;
    
    /**
     * Constructor que inicializa con el nombre y el array de figuras geometricas.
     * @param p_nombre nombre del jardin-
     * @param p_figuras array de figuras geometricas.
     */
    public Jardin(String p_nombre, ArrayList<FiguraGeometrica> p_figuras){
        this.setNombre(p_nombre);
        this.setFiguras(p_figuras);
    }
    
    /**
     * Constructor que incializa con el nombre y una figura geometrica.
     * @param p_nombre nombre del jardin.
     * @param p_figura Objeto del tipo FiguraGeometrica que representa una figura.
     */
    public Jardin(String p_nombre, FiguraGeometrica p_figura){
        this.setNombre(p_nombre);
        this.setFiguras(new ArrayList<FiguraGeometrica>());
        this.agregarFigura(p_figura);
    }
    
    /**
     * Constructor que sólo recibe el nombre del jardin.
     * @param p_nombre nombre del jardin.
     */
    public Jardin(String p_nombre){
        this.setNombre(p_nombre);
        this.setFiguras(new ArrayList<FiguraGeometrica>());
    }
    
    //Setters
    private void setNombre(String p_nombre){this.nombre = p_nombre;}
    private void setFiguras(ArrayList<FiguraGeometrica> p_figuras){this.figuras = p_figuras;}
    
    //getters
    public String getNombre(){return this.nombre;}
    public ArrayList<FiguraGeometrica> getFiguras(){return this.figuras;}
    
    //Agregar una figura
    public boolean agregarFigura(FiguraGeometrica p_figura){
        return this.getFiguras().add(p_figura);
    }
    
    //Quitar una figura
    public boolean quitarFigura(FiguraGeometrica p_figura){
        return this.getFiguras().add(p_figura);
    }
    
    /**
     * Método para conocer la cantidad de litros que se necesitara.
     * recorre el array de figuras y va acumulando el total de la superficie.   
     */
    private double cuantosLitros(){
        return (this.cuantosMetros() / 20.0);
    }
    
    /**
     * método para conocer la cantidad de metros que hay con todas las figuras.
     * recorro el Array y voy sumando la superficie de cada uno,
     * luego lo retorno.
     */
    public double cuantosMetros(){
        double total = 0.0;
        for(FiguraGeometrica unaFigu: this.getFiguras()){
            total += unaFigu.superficie();
        }
        return total;
    }
    
    /**
     * método para saber cuantas latas hay que comprar.
     * redondea la cantidad de litros ya calculada.
     */
    public int cuantasLatas(){
        return (int)Math.ceil(this.cuantosLitros());
    }
    
    /**
     * método para mostrar los detalles de las figuras.
     */
    public void detalleFiguras(){
        System.out.println("Propuesta: " + this.getNombre());
        for(FiguraGeometrica unaFigu: this.getFiguras()){
            System.out.println("\n***** " + unaFigu.nombreFigura() + " *****");
            unaFigu.mostrarSuperficie();
            System.out.print("\n");
        }
        System.out.println("-----------------");
        System.out.printf("Total a cubrir: %.2f", this.cuantosMetros());
        System.out.println("Comprar " + this.cuantasLatas() + " latas.\n");
    }
}