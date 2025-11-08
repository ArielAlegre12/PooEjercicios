import java.util.*;
/**
 * Clase exception para validar los errores comunes que puede tener al ingresar datos del libro
 */
public class ValidarLibro{
    public static void validar(String titulo, String editorial, String edicion, String anio) throws ValidarIngresoLibrosException {
        //validarCamposObligatorios(titulo, editorial);
        //validarNumericos(edicion, anio);
        //validarLogicaFechas(edicion, anio);
        validarAnioLogico(anio);
        //ValidarEdicionSuperior(edicion);
    }
    
    private static void validarCamposObligatorios(String titulo, String editorial) throws ValidarIngresoLibrosException {
        if(titulo.trim().isEmpty() || editorial.trim().isEmpty()){
            throw new ValidarIngresoLibrosException("Campos Incompletos!");
        }
    }
    
    private static void validarNumericos(String edicion, String anio) throws ValidarIngresoLibrosException{
        try{
           int intEdicion = Integer.parseInt(edicion.trim());
           int intAnio = Integer.parseInt(anio.trim());
           
           if(intEdicion <= 0 || intAnio <= 0){
               throw new ValidarIngresoLibrosException("La edición y el año deben ser mayor a cero!");
           }
        } catch(NumberFormatException e){
            throw new ValidarIngresoLibrosException("Los campos de Edicción y Año deben tener números!");
        }
    }
    
    private static void validarLogicaFechas(String edicion, String anio) throws ValidarIngresoLibrosException {
        int intEdicion = Integer.parseInt(edicion.trim());
        int intAnio = Integer.parseInt(anio.trim());
        
        if(intEdicion < intAnio){
            throw new ValidarIngresoLibrosException("La edición no puede ser anterior al año de publicación!");
        }
    }
    
    private static void validarAnioLogico(String anio) throws ValidarIngresoLibrosException{
        int intAnio = Integer.parseInt(anio);
        if(intAnio < 1800 || intAnio >= 2026){
            throw new ValidarIngresoLibrosException("Ingresa un año dentro del rango(1800 - 2025). CRACK!");
        }
    }
    
    private static void ValidarEdicionSuperior(String edicion) throws ValidarIngresoLibrosException {
        int intEdiccion = Integer.parseInt(edicion);
        Calendar fechaActual = new GregorianCalendar().getInstance();
        if(intEdiccion > fechaActual.get(Calendar.YEAR)){
            throw new ValidarIngresoLibrosException("El año de edición no puede ser mayor al año actual.");
        }
    }
}