import java.util.*;
/**
 * clase que valida las entradas del socio.
 */
public class ValidarSocio{
    public static void validar(String nombre, String dniTexto, String tipoSocio, String campoExtra) throws ValidarIngresoSocioException{
        validarCamposObligatorios(nombre,campoExtra,tipoSocio);
        validarDni(dniTexto);
    }
    
    /**
     * comprueba los campos obligatorios
     */
    private static void validarCamposObligatorios(String nombre, String campoExtra, String tipoSocio) throws ValidarIngresoSocioException{
        if(nombre.trim().isEmpty()){
            throw new ValidarIngresoSocioException("El nombre no puede estar Vacío");
        }
        if(campoExtra.isEmpty()){
            String campo = tipoSocio.equalsIgnoreCase("Docente") ? "Área" : "Carrera";
            throw new ValidarIngresoSocioException("El " + campo + " no puede estar vacío");
        }
    }
    
    /**
     * validar el dni
     */
    private static void validarDni(String dniTexto) throws ValidarIngresoSocioException{
        try{
            int dni = Integer.parseInt(dniTexto.trim());
            if(dni <= 1000000){
                throw new ValidarIngresoSocioException("El DNI debe ser mayor  a un millón");
            }
        } catch(NumberFormatException e){
            throw new ValidarIngresoSocioException("El DNI tiene que ser un número válido");
        }
    }
}