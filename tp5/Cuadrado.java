/**
 * Clase Cuadrado que se especializa a partir de la clase Rectangulo.
 */
public class Cuadrado extends Rectangulo{
    
    /**
     * Constructo Cuadrado que recibe el origen y el lado del cuadrado
     * luego utiliza la superclase para iniciar el origen y los lados.
     */
    public Cuadrado(Punto p_origen, double  p_lado){
        super(p_origen, p_lado, p_lado);
    }
    
    /**
     * Método que retorna el valor de la figura.
     */
    public String nombreFigura(){
        if(super.getAncho() == super.getAlto()){
            return "****** Cuadrado ******";
        }else{
            return "****** Rectangulo ******";
        }
    }
     /**
      * Método que muestra la caracteristicas de la figura.
      */
     public void caracteristicas(){
         System.out.println(this.nombreFigura());
         System.out.println("Origen: " + super.getOrigen().coordenadas() + " - Lado: "
                            + super.getAlto());
         System.out.println("Superficie: " + super.superficie() + " - Perimetro: " + super.perimetro());
     }
}