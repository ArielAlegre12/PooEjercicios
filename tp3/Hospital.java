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
        setNombreHospital(p_nombreHospital);
        setDirector(p_director);
        setPaciente(p_paciente);
    }
    /**
     * métodos setters y getters que establecen los datos del hospital.
     */
    private void setNombreHospital(String p_nombreHospital){
        nombreHospital = p_nombreHospital;
    }
    private void setDirector(String p_director){
        nombreDirector = p_director;
    }
    private void setPaciente(Paciente p_paciente){
        paciente = p_paciente;
    }
    public String getNombreHospital(){
        return nombreHospital;
    }
    public String getDirector(){
        return nombreDirector;
    }
    public Paciente getPaciente(){
        return paciente;
    }
    /***
     * método que permite consultar los datos de los pacientes afiliados.
     */
    public void consultaDatosFilatorios(Paciente p_paciente){
        System.out.println("\nHospital: " + getNombreHospital() + "  Director: " + getDirector());
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("Paciente: " + getPaciente().getNombre() + "  Historia Clínica: " + getPaciente().getHistoria() + "   Domicilio: " + getPaciente().getDomicilio());
        System.out.println("Localidad: " + getPaciente().getVive().getNombre() + "   Provincia: " + getPaciente().getVive().getProvincia());
    }
}