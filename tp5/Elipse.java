/**
 * SuperClase Elipse que representa la misma.
 * 
 * @author Alegre Ariel, Antoniow Agustín
 */
public class Elipse extends FiguraGeometrica{
    private double sEjeMayor;
    private double sEjeMenor;
    
    /**
     * Constructor que recibe los ejes, y el centro
     * @param p_sEjeMayor es el eje mayor de la elipse.
     * @param p_sEjeMenor es el eje menor de la elipse.
     * @param p_centro centro de la elipse
     */
    public Elipse(double p_sEjeMayor, double p_sEjeMenor, Punto p_centro){
        super(p_centro);
        setEjeMayor(p_sEjeMayor);
        setEjeMenor(p_sEjeMenor);
    }
    
    /**
     * Constructor que no recibe nada.
     */
    public Elipse(){
        super(new Punto(0.0, 0.0));
        this.setEjeMayor(0.0);
        this.setEjeMenor(0.0);
    }
    
    /**
     * métodos setters y getters.
     */
    private void setEjeMayor(double p_sEjeMayor){this.sEjeMayor = p_sEjeMayor;}
    private void setEjeMenor(double p_sEjeMenor){this. sEjeMenor = p_sEjeMenor;}
    
    public double getEjeMayor(){return this.sEjeMayor;}
    public double getEjeMenor(){return this.sEjeMenor;}
    
    /**
     * método que retorna el nombre de la figura dependiendo de sus caracteristicas
     */
    @Override
    public String nombreFigura(){
        if(this.getEjeMayor() == this.getEjeMenor()){
            return "****** Circulo ******";
        }else{
            return "****** Elipse ******";
        }
    }
    
    /**
     * método para mostrar las caracteristicas de la elipse
     */
    public void caracteristicas(){
        System.out.println(this.nombreFigura());
        if(this.getEjeMayor() != this.getEjeMenor()){
        System.out.println("Centro: " + super.getOrigen().coordenadas() + " - Semieje Mayor: " +
                            this.getEjeMayor() + " - Semieje Menor: " + this.getEjeMenor());
        System.out.println(String.format("Superficie: %.2f ", this.superficie()));;
        }else{
            System.out.println("Centro: " + super.getOrigen().coordenadas() + "  -Radio: " + this.getEjeMayor());
            System.out.println(String.format("Superficie: %.2f ", this.superficie()));
        }
    }
    
    /**
     * método para obtener la superficie  de la elipse
     */
    @Override
    public double superficie(){
        if(this.getEjeMayor() != this.getEjeMenor()){
        return (Math.PI * this.getEjeMayor() * this.getEjeMenor()); //para cualquier elipse
        
        }else{
        return (Math.PI * this.getEjeMayor() * this.getEjeMayor()); //para un circulo
        }
    }
    
    /**
     * método para desplazar elipse o circulo.
     */
    public void desplazar(double p_dx, double p_dy){
        super.getOrigen().desplazar(p_dx, p_dy);
    }
    
    /**
     * método para saber la distancia de una elipse a otra.
     */
    public double distanciaA(Elipse otraElipse){
        return super.getOrigen().distanciaA(otraElipse.getOrigen());
    }
    
    /**
     * método para saber cual es la mayor elipse
     */
    public Elipse elMayor(Elipse otraElipse){
        if(this.superficie() > otraElipse.superficie()){
            return this;
        }else{
            return otraElipse;
        }
    }
    
    
}