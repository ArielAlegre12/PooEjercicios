/**
 * SuperClase Elipse que representa la misma.
 * 
 * @author Alegre Ariel, Antoniow Agustín
 */
public class Elipse{
    private double sEjeMayor;
    private double sEjeMenor;
    private Punto centro;
    
    /**
     * Constructor que recibe los ejes, y el centro
     * @param p_sEjeMayor es el eje mayor de la elipse.
     * @param p_sEjeMenor es el eje menor de la elipse.
     * @param p_centro centro de la elipse
     */
    public Elipse(double p_sEjeMayor, double p_sEjeMenor, Punto p_centro){
        setEjeMayor(p_sEjeMayor);
        setEjeMenor(p_sEjeMenor);
        setCentro(p_centro);
    }
    
    /**
     * Constructor que no recibe nada.
     */
    public Elipse(){
        setEjeMayor(0.0);
        setEjeMenor(0.0);
        setCentro(new Punto(0.0, 0.0));
    }
    
    /**
     * métodos setters y getters.
     */
    private void setEjeMayor(double p_sEjeMayor){this.sEjeMayor = p_sEjeMayor;}
    private void setEjeMenor(double p_sEjeMenor){this. sEjeMenor = p_sEjeMenor;}
    private void setCentro(Punto p_centro){this.centro = p_centro;}
    
    public double getEjeMayor(){return this.sEjeMayor;}
    public double getEjeMenor(){return this.sEjeMenor;}
    public Punto getCentro(){return this.centro;}
    
    /**
     * método que retorna el nombre de la figura dependiendo de sus caracteristicas
     */
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
        System.out.println("Centro: " + this.getCentro().coordenadas() + " - Semieje Mayor: " +
                            this.getEjeMayor() + " - Semieje Menor: " + this.getEjeMenor());
        System.out.println(String.format("Superficie: %.2f ", this.superficie()));;
        }else{
            System.out.println("Centro: " + this.getCentro().coordenadas() + "  -Radio: " + this.getEjeMayor());
            System.out.println(String.format("Superficie: %.2f ", this.superficie()));
        }
    }
    
    /**
     * método para obtener la superficie  de la elipse
     */
    public double superficie(){
        if(this.getEjeMayor() != this.getEjeMenor()){
        return (Math.PI * this.getEjeMayor() * this.getEjeMenor());
        
        }else{
        return (Math.PI * this.getEjeMayor() * this.getEjeMayor());
        }
    }
    
    /**
     * método para desplazar elipse o circulo.
     */
    public void desplazar(double p_dx, double p_dy){
        this.getCentro().desplazar(p_dx, p_dy);
    }
    
    /**
     * método para saber la distancia de una elipse a otra.
     */
    public double distanciaA(Elipse otraElipse){
        return this.getCentro().distanciaA(otraElipse.getCentro());
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