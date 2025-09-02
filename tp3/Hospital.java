/**
 * Clase del tipo Hospital el cual representa un hospital y el manejo de los pacientes.
 */
public class Hospital{
    private String nombreHospital;
    private String nombreDirector;
    private Paciente paciente;
    /**
     * Inicializa al Hospital con sus respectivos datos.
     * @param p_nombreHospital
     * @param p_nombreDirector
     * @param p_paciente
     */
    public Hospital(String p_nombreHospital, String p_director, Paciente p_paciente){
        this.setNombreHospital(p_nombreHospital);
        this.setDirector(p_director);
        this.setPaciente(p_paciente);
    }
    /**
     * métodos setters y getters que establecen los datos del hospital.
     */
    private void setNombreHospital(String p_nombreHospital){
        this.nombreHospital = p_nombreHospital;
    }
    private void setDirector(String p_director){
        this.nombreDirector = p_director;
    }
    private void setPaciente(Paciente p_paciente){
        this.paciente = p_paciente;
    }
    public String getNombreHospital(){
        return this.nombreHospital;
    }
    public String getDirector(){
        return this.nombreDirector;
    }
    public Paciente getPaciente(){
        return this.paciente;
    }
    /***
     * método que permite consultar los datos de los pacientes afiliados.
     */
    public void consultaDatosFilatorios(Paciente p_paciente){
        System.out.println("\nHospital: " + this.getNombreHospital() + "  Director: " + this.getDirector());
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("Paciente: " + this.getPaciente().getNombre() + "  Historia Clínica: " + this.getPaciente().getHistoria() + "   Domicilio: " + this.getPaciente().getDomicilio());
        System.out.println("Localidad: " + this.getPaciente().getVive().getNombre() + "   Provincia: " + this.getPaciente().getVive().getProvincia());
    }
}