/**
 * Creo la clase Rectangulo
 */
public class Rectangulo{
    private Punto origen;
    private double ancho;
    private double alto;
    
    public Rectangulo(Punto p_origen, double p_ancho, double p_alto){
        this.setOrigen(p_origen);
        this.setAncho(p_ancho);
        this.setAlto(p_alto);
    }
    public Rectangulo(double p_ancho, double p_alto){
        this.setAncho(p_ancho);
        this.setAlto(p_alto);
    }
    //setters
    private void setOrigen(Punto p_origen){
        this.origen = p_origen;
    }
    private void setAncho(double p_ancho){
        this.ancho = p_ancho;
    }
    private void setAlto(double p_alto){
        this.alto = p_alto;
    }
    //getters 
    public Punto getOrigen(){
        return this.origen;
    }
    public double getAncho(){
        return this.ancho;
    }
    public double getAlto(){
        return this.alto;
    }
    
    public void desplazar(double p_dx, double p_dy){
        this.getOrigen().desplazar(p_dx, p_dy);
    }
    
    public void caracateristicas(){
        System.out.println("****** Rectangulo ******");
        System.out.println("Orgien: " + this.getOrigen().coordenadas() + " - Alto: "+ this.getAlto() + " - Ancho: " + getAncho());
        System.out.println("Superficie: " + superficie() + " - Perímetro: " + perimetro());
    }
    
    public double superficie(){
       return this.getAlto() * this.getAncho();
    }
    
    public double perimetro(){
        return 2 * (this.getAlto() + this.getAncho());
    }
    
    public double distanciaA(Rectangulo otroRectangulo){
        double distancia = this.getOrigen().distanciaA(otroRectangulo.getOrigen());
        return distancia;
    }
    
    public Rectangulo elMayor(Rectangulo otroRectangulo){
        if(this.superficie() > otroRectangulo.superficie()){
            return this ;
        }else{
            return otroRectangulo;
        }
    }
    
}