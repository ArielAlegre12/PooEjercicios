/**
 * Clase Array de Punto donde trabajamos con un array de manera estatica. contiene 6 elementos.
 * lo recorremos a tráves de un for.
 * @Author Alegre Ariel, Agustín Antoniow.
 */
class ArrayDePunto{
    private Punto puntos[] = new Punto[6];
    
    /**
     * Constructor el cual recibe al menos 1 elemento.
     * @param p_puntos es el punto de tipo Punto que contiene las coordenadas.
     */
    public ArrayDePunto(Punto p_puntos){
        this.setPuntos(p_puntos);
    }
    /**
     * Constructor que no recibe nada. entonces sólo incializa el array.
     */
    public ArrayDePunto(){
        this.puntos = new Punto[6];
    }
    /**
     * Método mutador para asignar un punto al array.
     * una vez asignado en la posición más pronta y libre, sale del bucle.
     * @p_punto punto que recibe para asignar al array si hay espacio disponible.
     */
    private void setPuntos(Punto p_punto){
        for(int i= 0; i < this.getPuntos().length; i ++){
            if(this.getPuntos()[i] == null){
                this.puntos[i] = p_punto;
                break;
            }
        }
    }
    /**
     * Método para agregar un punto.
     */
    public void agregarPunto(Punto p_puntos){
        this.setPuntos(p_puntos);
    }
    public Punto[] getPuntos(){return this.puntos;}
    /**
     * Método para poder visualizar todos los elementos del array, mostrando sus coordenadas y la distancia que tiene el actual con el siguiente.
     * usamos length -1 para asi no sufrir un error al querer comparar con algo que no existe(en el caso del ultimo elemento).
     * Mostrara 5 distancias:
     * p1 y p2
     * p2 y p3
     * p3 y p4
     * p4 y p5
     * p5 y p6
     */
    
    public void recorrerArray(){
        for(int i = 0; i < this.getPuntos().length -1; i ++){
            Punto p1 = this.getPuntos()[i];
            Punto p2 = this.getPuntos()[i+1];
            if(p1 != null && p2 != null){
                double distancia = p1.distanciaA(p2);
                System.out.println("Distancia entre punto 1:" + p1.coordenadas() + " y punto 2: " + p2.coordenadas() + " es: " + distancia);
            }
        }
        System.out.println("Fin.");
    }
}