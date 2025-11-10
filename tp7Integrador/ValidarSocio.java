import java.util.*;
/**
 * clase que valida las entradas del socio.
 * 
 * @author Alegre Ariel Santiago
 */
public class ValidarSocio{
    public static void validar(String nombre, String dniTexto, String tipoSocio, String campoExtra) throws ValidarIngresoSocioException{
        validarCamposObligatorios(nombre,campoExtra,tipoSocio);
        validarDni(dniTexto);
        ValidarCampoExtra(campoExtra, tipoSocio);
        ValidarNombre(nombre);
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
    
    /**
     * Validar ingreso correcto del nombre, evita que ingrese números, evita que ingrese símbolos, exigir al menos 3 letras
     */
    private static void ValidarNombre(String nombre) throws ValidarIngresoSocioException{
        if(nombre.matches("-?\\d+")){
            throw new ValidarIngresoSocioException("El nombre no puede ser un número!");
        }
        if(nombre.length() < 3){
            throw new ValidarIngresoSocioException("El nombre debe tener al menos 3 letras!");
        }
    }
    
    /**
     * Validar ingreso correcto del area o carrera
     */
    private static void ValidarCampoExtra(String campoExtra, String tipoSocio) throws ValidarIngresoSocioException{
        if(campoExtra.matches("-?\\d+")){
            if(tipoSocio.equalsIgnoreCase("estudiante")){
                throw new ValidarIngresoSocioException("La carrera no puede ser un número!");
            }else{
                throw new ValidarIngresoSocioException("El Área no puede ser un número!");
            }
        }
        if(campoExtra.length() < 3){
            if(tipoSocio.equalsIgnoreCase("estudiante")){
                throw new ValidarIngresoSocioException("El campo de Carrera debe tener al menos 3 letras!");
            }else{
                throw new ValidarIngresoSocioException("El campo de Área debe tener al menos 3 letras!");
            }
        }
    }
}