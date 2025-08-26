/**
 * Creo clase Circulo
 */
public class Circulo{
    private double radio;
    private Punto centro;
    
    public Circulo(double p_radio, Punto p_centro){
        this.setCentro(p_centro);
        this.setRadio(p_radio);
    }
    public Circulo(){
        radio = 0;
        centro = new Punto(0, 0);
    }
    
    private void setCentro(Punto p_centro){
        centro = p_centro;
    }
    private void setRadio(double p_radio){
        radio = p_radio;
    }
    
    public Punto getCentro(){
        return centro;
    }
    public double getRadio(){
        return radio;
    }
    
    public void desplazar(double p_dx, double p_dy){
        centro.desplazar(p_dx, p_dy);
    }
    
    public void caracteristicas(){
        System.out.println(" ****** Circulo ****** ");
        System.out.println("Centro: " + this.getCentro().coordenadas() + "  -Radio: " + this.getRadio());
        System.out.println(String.format("Superficie: %.2f -Perímetro: %.2f\n", superficie(), perimetro()));
    }
    
    public double superficie(){
        return Math.PI * this.getRadio() * this.getRadio();
    }
    public double perimetro(){
        return 2 * Math.PI * this.getRadio();
    }
    
    public double distanciaA(Circulo otroCirculo){
        return this.getCentro().distanciaA(otroCirculo.getCentro());
    }
    
    public Circulo elMayor(Circulo otroCirculo){
        if(this.superficie() > otroCirculo.superficie()){
            return this;
        }else{
            return otroCirculo;
        }
    }
    
    
}