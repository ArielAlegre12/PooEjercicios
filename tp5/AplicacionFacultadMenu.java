/**
 * Ejecutable de Aplicación de la facultad, para interacturar con los profesores y sus cargos
 */
import java.util.Scanner;
import java.util.*;
public class AplicacionFacultadMenu{
    static Scanner teclado = new Scanner(System.in);
    public static void main(String args[]){
        Facultad facu = crearFacultad();
        menu(facu);
    }
    
    /**
     * método para instanciar un cargo.
     */
    public static Cargo crearCargo(){
        System.out.println("\n**** CREAR CARGO ****");
        System.out.print("\nIngrese el nombre del cargo: ");
        String nombre = teclado.next();
        System.out.print("Ingrese el sueldo basico: ");
        double monto = teclado.nextDouble();
        System.out.print("Ingrese el año de ingreso: ");
        int anio = teclado.nextInt();
        System.out.print("Ingrese la cantidad de horas de docencia: ");
        int horasDocencia = teclado.nextInt();
        if(horasDocencia <= 10){
           return new Cargo(nombre, monto, anio, horasDocencia); 
        }else{
            System.out.println("Error! La cantidad de horas de docencia supera el limite de 10hs.");
            return null;
        }
    }
    
    /**
     * método para instanciar un cargo SemiExclusivo.
     *
     */
    public static SemiExclusivo crearCargoSemiexclusico(){
        System.out.println("\n**** CREAR CARGO SEMIEXCLUSIVO****");
        System.out.print("\nIngrese el nombre del cargo: ");
        String nombre = teclado.next();
        System.out.print("Ingrese el sueldo basico: ");
        double monto = teclado.nextDouble();
        System.out.print("Ingrese el año de ingreso: ");
        int anio = teclado.nextInt();
        System.out.print("Ingrese la cantidad de horas de docencia: ");
        int horasDocencia = teclado.nextInt();
        System.out.print("Ingrese las horas de investigacion: ");
        int horasInvestigacion = teclado.nextInt();
        if(horasDocencia >= 10 && (horasDocencia + horasInvestigacion) <= 20){
            return new SemiExclusivo(horasInvestigacion, nombre, monto, anio, horasDocencia);
        }else{
            System.out.println("Error! Supera el rango de horario total de 20hs o bien el rango minimo de horario de docencia de 10hs");
            return null;
        }
    }
    
    /**
     * método para instanciar un cargo Exclusivo.
     */
    public static Exclusivo crearCargoExclusivo(){
        System.out.println("\n**** CREAR CARGO EXCLUSIVO****");
        System.out.print("\nIngrese el nombre del cargo: ");
        String nombre = teclado.next();
        System.out.print("Ingrese el sueldo basico: ");
        double monto = teclado.nextDouble();
        System.out.print("Ingrese el año de ingreso: ");
        int anio = teclado.nextInt();
        System.out.print("Ingrese la cantidad de horas de docencia: ");
        int horasDocencia = teclado.nextInt();
        System.out.print("Ingrese las horas de investigacion: ");
        int horasInvestigacion = teclado.nextInt();
        System.out.print("Ingrese la cantidad de horas de extensión: ");
        int horasExtension = teclado.nextInt();
        
        return new Exclusivo(horasInvestigacion, horasExtension, nombre, monto, anio, horasDocencia);
    }
    
    /**
     * método para instanciar un profesor.
     */
    public static Profesor crearProfesor(){
        System.out.println("\n**** CREAR PROFESOR *****");
        System.out.print("\nIngrese el nombre del profesor: ");
        String nombre = teclado.next();
        System.out.print("Ingrese el apellido del profesor: ");
        String apellido = teclado.next();
        System.out.print("Ingrese el dni: ");
        int dni = teclado.nextInt();
        System.out.print("Ingerse el año de nacimiento: ");
        int anio = teclado.nextInt();
        teclado.nextLine();
        System.out.print("Ingrese el Titulo que posee: ");
        String titulo = teclado.nextLine();
        //Instancio un cargo simple, porque el profesor debe recibir al menos 1
        Cargo cargoSimple = crearCargo();
        
        return new Profesor(titulo, cargoSimple, dni, nombre, apellido, anio);
    }
    
    /**
     * método para instanciar una facultad.
     */
    public static Facultad crearFacultad(){
        System.out.println("\n**** CREAR FACULTAD *****");
        System.out.print("\nIngrese el nombre de la facultad: ");
        String nombre = teclado.nextLine();
        Profesor profe = crearProfesor();
        return new Facultad(nombre, profe);
    }
    
    /**
     * creo un menú para interacturar
     */
    public static void menu(Facultad p_facu){
        int opcion;
        do{
            System.out.println("\n---------------------------");
            System.out.println("----------- M E N Ú ---------");
            System.out.println("-----------------------------\n");
            System.out.println("\n1. Agregar Profesor.");
            System.out.println("2. Quitar Profesor.");
            System.out.println("3. Agregar Cargo a Profesor.");
            System.out.println("4. Quitar Cargo a Profesor.");
            System.out.println("5. Mostrar Nomina de Profesores.");
            System.out.println("6. Mostrar lista de detalles de Profesores.");
            System.out.println("7. Salir.");
            System.out.println("\nOpcion: ");
            opcion = teclado.nextInt();
            
            switch(opcion){
                case 1:
                    Profesor unProfe = crearProfesor();
                    p_facu.agregarProfesor(unProfe);
                    System.out.println("Hecho!");
                    break;
                case 2:
                    dniProfesores(p_facu);
                    System.out.println("Ingrese el dni: ");
                    int p_dni = teclado.nextInt();
                    eliminar(p_dni, p_facu);
                    break;
                case 3:
                    dniProfesores(p_facu);
                    System.out.println("Ingrese el dni del profe que quiere agregar el cargo: ");
                    int p_dniCargo = teclado.nextInt();
                    agregarUnCargo(p_dniCargo, p_facu);
                    break;
                case 4:
                    dniProfesores(p_facu);
                    System.out.println("Ingrese el dni: ");
                    int p_dniEliminar = teclado.nextInt();
                    eliminarCargoProfesor(p_dniEliminar, p_facu);
                    break;
                case 5:
                    p_facu.nomina();
                    break;
                case 6:
                    p_facu.listarProfesoresCargos();
                    break;
                case 7:
                    System.out.println("Saliendo.!");
                    break;
                default:
                    System.out.println("Opcion invalida!.");
                    break;
            }
            
        }while(opcion != 7);
    }
    
    /**
     * Muestra una lista de dni con nombre y apellido para que se pueda seleccionar con el que quiere trabajar..
     */
    public static void dniProfesores(Facultad p_facu){
        for(Profesor unProfe: p_facu.getProfesores()){
            System.out.println("DNI: " + unProfe.getDNI() + " Nombre y Apellido: " + unProfe.nomYape());
        }
    }
     /**
     * Permite agregar un cargo al profesor mientras no supere el limite
     */
    public static void agregarUnCargo(int p_dni, Facultad p_facu){
        for(Profesor unProfe: p_facu.getProfesores()){
            if(p_dni == unProfe.getDNI()){
                System.out.println("\n1. Agregar Cargo simple.");
                System.out.println("2. Agregar Cargo semiExclusivo.");
                System.out.println("3. Agregar Cargo exclusivo.");
                System.out.print("Opcion: ");
                int opcion = teclado.nextInt();
                switch(opcion){
                    case 1:
                        Cargo p_cargo = crearCargo();
                        if(unProfe.agregarCargo(p_cargo)){
                            System.out.println("\nHecho!");
                        }else{
                            System.out.println("\nError! Limite superado.");
                        }
                        break;
                    case 2:
                        SemiExclusivo p_semi = crearCargoSemiexclusico();
                        if(unProfe.agregarCargo(p_semi)){
                            System.out.println("\nHecho!");
                        }else{
                            System.out.println("\nError! Limite superado.");
                        }
                        break;
                    case 3:
                        Exclusivo p_exclusivo = crearCargoExclusivo();
                        if(unProfe.agregarCargo(p_exclusivo)){
                            System.out.println("\nHecho!");
                        }else{
                            System.out.println("\nError! Limite superado.");
                        }
                        break;
                    default:
                        System.out.println("\nOpción invalida!\n");
                        
                }
                break;
            }
        }
    }
    
    /**
     * método para quitar un cargo a un profeor.
     */
    public static void eliminarCargoProfesor(int p_dni, Facultad p_facu){
        for(Profesor unProfe: p_facu.getProfesores()){
            if(p_dni == unProfe.getDNI()){
                ArrayList<Cargo> cargos = unProfe.getCargos();
                for(int i = 0; i < cargos.size(); i++){
                    System.out.println((i+1) + ". " + cargos.get(i).getNombreCargo());
                }
                System.out.println("Seleccione el numero de cargo que quiere eliminar: ");
                int op = teclado.nextInt();
                if((op - 1) < cargos.size()){
                    Cargo cargoEliminar = cargos.get(op - 1);
                     if(unProfe.quitarCargo(cargoEliminar)){
                         
                        System.out.println("Cargo eliminado.");
                        }else{
                            System.out.println("No se pueden eliminar más cargos!");
                             }
                        }else{
                            System.out.println("Numero invalido!.");
                            }
                
               
                break;
            }
        }
    }
    
    /**
     * Elimina el Profesor eligiendo su dni.
     */
    public static void eliminar(int p_dni, Facultad p_facu){
        for(Profesor unProfe: p_facu.getProfesores()){
            if(p_dni == unProfe.getDNI()){
                p_facu.quitarProfesor(unProfe);
                System.out.println("Hecho!");
                break;
            }else{
                System.out.println("Error!");
            }
        }
    }
}

