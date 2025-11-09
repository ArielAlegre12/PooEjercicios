import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class GestionBiblioteca {
    public static void main(String args[]) {
        Scanner leer = new Scanner(System.in);
        int opcion = 0;
        Biblioteca biblioteca = new Biblioteca("Biblioteca");


        // Agregacion de libros
        biblioteca.nuevoLibro("Códer house", 1, "Editorial 1", 2008);
        biblioteca.nuevoLibro("Programming", 2, "Editorial 2", 1999);
        biblioteca.nuevoLibro("Complete Program", 3, "Editorial 3", 2004);
        biblioteca.nuevoLibro("Diseños Uml", 4, "Editorial 4", 1994);
        biblioteca.nuevoLibro("Algoritmos y estructuras de datos", 5, "Editorial 5", 2009);
        biblioteca.nuevoLibro("JavaScript:", 1, "Editorial 5", 2008);
        biblioteca.nuevoLibro("Python's", 2, "Editorial 6", 2015);
        biblioteca.nuevoLibro("Coding", 3, "Editorial 7", 2011);
        biblioteca.nuevoLibro("Computer C", 1, "Editorial 8", 1968);
        biblioteca.nuevoLibro("Programando Con JAVA", 1, "Editorial 9", 2009);
        // Agregacion de docentes
        biblioteca.nuevoSocioDocente(32444552, "Juan Perez", "Informatica");
        biblioteca.nuevoSocioDocente(17982110, "Juan Fernandez", "Informatica");
        biblioteca.nuevoSocioDocente(10912002, "Maria Alegre", "Matematicas");
        biblioteca.nuevoSocioDocente(33492162, "Sebastian Taglia", "Quimica");
        // Agregacion de estudiantes
        biblioteca.nuevoSocioEstudiante(28987498, "Francisco Paenza", "Licenciatura en sistemas");
        biblioteca.nuevoSocioEstudiante(31987123, "Cesar Milstein", "Ingenieria en sistemas");
        // Prestamos vencidos
         Calendar fechaPrestamo = Calendar.getInstance();
         
        fechaPrestamo.add(Calendar.DAY_OF_MONTH, -25); // se setea el dia del prestamo 25 dias antes de el actual
        Calendar fechaPrestamo1 = Calendar.getInstance();
         fechaPrestamo1.add(Calendar.DAY_OF_MONTH,-15);
        biblioteca.prestarLibro(fechaPrestamo,biblioteca.buscarSocio(32444552),biblioteca.getLibros().get(9- 1));
        biblioteca.prestarLibro(fechaPrestamo,biblioteca.buscarSocio(28987498),biblioteca.getLibros().get(8 - 1));
        biblioteca.prestarLibro(fechaPrestamo1,biblioteca.buscarSocio(33492162),biblioteca.getLibros().get(7 - 1));
    
        
        
        
        // Entrada para los datos
        Scanner entradaOP = new Scanner(System.in);
        // OP:1.
  
        Scanner entradaTitulo = new Scanner(System.in);
        Scanner entradaEdicion = new Scanner(System.in);
        Scanner entradaEditoral = new Scanner(System.in);
        Scanner entradaAño = new Scanner(System.in);
        Scanner entradaNombre = new Scanner(System.in);
        Scanner entradaDNI = new Scanner(System.in);
        Scanner entradaTipo = new Scanner(System.in);
        Scanner entradaCarrera = new Scanner(System.in);
        Scanner entradaArea = new Scanner(System.in);
        try {
            do {
                System.out.println("###############/GESTION BIBLIOTECA/##################");
                System.out.println("(1)  AGREGAR SOCIO");
                System.out.println("(2)  REMOVER SOCIO");
                System.out.println("(3)  AGREGAR LIBRO");
                System.out.println("(4)  REMOVER LIBRO");
                System.out.println("(5)  PRESTAR LIBRO");
                System.out.println("(6)  DEVOLVER LIBRO");
                System.out.println("(7)  VER PRESTAMOS VENCIDOS");
                System.out.println("(8)  LISTA DE DOCENTES QUE NO ADEUDAN LIBROS");
                System.out.println("(9)  BUSCAR SI EL LIBRO ESTA PRESTADO");
                System.out.println("(10) BUSCAR SOCIO POR DNI");
                System.out.println("(11) LISTA DE SOCIOS");
                System.out.println("(12) LISTA DE SOCIOS POR TIPO");
                System.out.println("(13) LISTA DE LIBROS");
                System.out.println("(14) LISTAR TÍTULOS SIN REPETIR");

                System.out.println("(0)  SALIR");
                System.out.println("************************************************************");
                System.out.print("INGRESAR UNA OPCION: ");
                opcion = entradaOP.nextInt();

                int dni, numeroL;

                    switch (opcion) {
                    case 1:
                        // Estudiante
                        Scanner entradaDniE = new Scanner(System.in);
                        Scanner entradaNE = new Scanner(System.in);
                        Scanner entradaCE = new Scanner(System.in);
                        // Docente
                        Scanner entradaDniD = new Scanner(System.in);
                        Scanner entradaND = new Scanner(System.in);
                        Scanner entradaAD = new Scanner(System.in);

                        int opAS;
                        Scanner entradaOAS = new Scanner(System.in);
                        System.out.println("QUE TIPO DE SOCIO DESEA AGREGAR?");
                        System.out.println("[1] ESTUDIANTE");
                        System.out.println("[2] DOCENTE ");
                        System.out.print("INGRESAR OPCION QUE QUIERE USAR: ");
                        opAS = entradaOAS.nextInt();
                        if (opAS == 1) {
                        int dniE;
                        String nombreE, carreraE;
                        System.out.println("INGRESAR DNI DEL SOCIO.");
                        dniE = entradaDniE.nextInt();
                        entradaDniE.nextLine();  // Limpiar el salto de línea pendiente
                        System.out.println("INGRESAR NOMBRE COMPLETO DEL SOCIO.");
                        nombreE = entradaNE.nextLine();
                    System.out.println("INGRESAR CARRERA DEL ESTUDIANTE.");
                    carreraE = entradaCE.nextLine();
                    biblioteca.nuevoSocioEstudiante(dniE, nombreE, carreraE);
                    } else if (opAS == 2) {
                    int dniD;
                    String nombreD, areaD;
                    System.out.println("INGRESAR DNI DEL SOCIO.");
                    dniD = entradaDniD.nextInt();
                    entradaDniD.nextLine();  // Limpiar el salto de línea pendiente
                    System.out.println("INGRESAR NOMBRE COMPLETO DEL SOCIO.");
                    nombreD = entradaND.nextLine();
                        System.out.println("INGRESAR AREA DEL DOCENTE.");
                    areaD = entradaAD.nextLine();
                    biblioteca.nuevoSocioDocente(dniD, nombreD, areaD);
                }
                        break;
                    case 2:
                        System.out.println("***************************************************");
                        int dniR;
                        Scanner entradaDniR = new Scanner(System.in);
                        System.out.println("INGRESAR DNI DEL SOCIO A REMOVER.");
                        dniR = entradaDniR.nextInt();
                        Socio removerSocio = biblioteca.buscarSocio(dniR);
                        if (removerSocio != null) {
                            biblioteca.quitarSocio(removerSocio);
                            System.out.println("---------------------------");
                            System.out.println("SOCIO REMOVIDO EXITOSAMENTE!");
                            System.out.println("---------------------------");
                        } else {
                            System.out.println("NO SE ENCONTRÓ EL SOCIO...");
                        }
                        break;
                    case 3:
                        System.out.println("---------------------------------------------------");
                        String nombreL, editorialL;
                        int edicionL, añoL;
                        // Agregar libro
                        Scanner entradaNL = new Scanner(System.in);
                        Scanner entradaEdicionL = new Scanner(System.in);
                        Scanner entradaEditorial = new Scanner(System.in);
                        Scanner entradaAñoL = new Scanner(System.in);

                        System.out.println("INGRESAR NOMBRE DEL LIBRO");
                        nombreL = entradaNL.nextLine();
                        System.out.println("INGRESAR EDICION DEL LIBRO");
                        edicionL = entradaEdicionL.nextInt();
                        System.out.println("INGRESAR EDITORIAL DEL LIBRO");
                        editorialL = entradaEditorial.nextLine();
                        System.out.println("INGRESAR AÑO DEL LIBRO");
                        añoL = entradaAñoL.nextInt();

                        biblioteca.nuevoLibro(nombreL, edicionL, editorialL, añoL);
                        System.out.println("----------------------------");
                        System.out.println("LIBRO " + nombreL.toUpperCase() + " AGREGADO EXITOSAMENTE!");
                        System.out.println("-----------------------------");
                        break;
                    case 4:
                        System.out.println("-------------------------------------------------------------");
                        System.out.println(biblioteca.listaDeLibros());
                        int numeroLR;
                        Scanner entradaNLR = new Scanner(System.in);
                        System.out.println("-------------------------------------------------------------");
                        System.out.print("INGRESAR NÚMERO DEL LIBRO A REMOVER: ");
                        numeroLR = entradaNLR.nextInt();
                        if (biblioteca.getLibros().get(numeroLR - 1).prestado() == false) {
                            biblioteca.quitarLibro(biblioteca.getLibros().get(numeroLR - 1));
                            System.out.println("----------------------------");
                            System.out.println("LIBRO REMOVIDO EXITOSAMENTE!");
                            System.out.println("----------------------------");
                        } else {
                            System.out.println("NO ES POSIBLE REMOVER ESE LIBRO, INTENTE DE NUEVO.");
                        }
                        break;
                    case 5:
                        System.out.println("---------------------------------------------------------------");
                        Calendar fechaRetiro = Calendar.getInstance();
                        System.out.println("Ingrese el dni del socio: ");
                        dni = entradaDNI.nextInt();
                        System.out.println(biblioteca.listaDeLibros());
                        System.out.println("Ingrese el numero asignado al libro!");
                        numeroL = entradaTitulo.nextInt();
                        if (biblioteca.prestarLibro(fechaRetiro, biblioteca.buscarSocio(dni),
                                biblioteca.getLibros().get(numeroL - 1))) {      
                            System.out.println("-----------------------------------");
                            System.out.println(
                                "LIBRO " + biblioteca.getLibros().get(numeroL - 1) + " PRESTADO EXITOSAMENTE!");
                            System.out.println("---------------------------------");
                        } else {
                            System.out.println("---------------------------------");
                            System.out.println("NO EXISTE ESE LIBRO EN LA BIBLIOTECA!");
                            System.out.println("------------------------------------");
                        }
                        System.out.println("-------------------------------------------------------------");
                        break;
                    case 6:
                        System.out.println("----------------------------------------------------------------");
                        System.out.println(biblioteca.listaDeLibros());
                        System.out.println("Ingrese el numero asignado al libro!");
                        numeroL = entradaTitulo.nextInt();
                        biblioteca.devolverLibro(biblioteca.getLibros().get(numeroL - 1));
                        System.out.println("---------------------------");
                        System.out.println("LIBRO DEVUELTO A LA BIBLIOTECA!");
                        System.out.println("---------------------------");
                        break;
                    case 7:
                        System.out.println("------------------------------------------------------------");
                        System.out.println("************Lista de Prestamos Vencidos*****************");
                        System.out.println(biblioteca.prestamosVencidos());
                        System.out.println("-------------------------------------------------------------");
                        break;
                    case 8:
                        System.out.println("-------------------------------------------------------------");
                        System.out.println(biblioteca.listaDeDocentesResponsables());
                        System.out.println("-------------------------------------------------------------");
                        break;
                    case 9:
                        System.out.println("--------------------------------------------------------------");
                        System.out.println(biblioteca.listaDeLibros());
                        System.out.println("--------------------------------------------------------------");
                        System.out.println("Ingrese el numero asignado al libro!");
                        numeroL = entradaTitulo.nextInt();
                        System.out.println(biblioteca.quienTieneElLibro(biblioteca.getLibros().get(numeroL - 1)));
                        System.out.println("------------------------------------------------------------");
                        break;
                    case 10:
                        System.out.println("-------------------------------------------------------------");
                        System.out.println("Ingrese el dni del socio: ");
                        int p_dni = leer.nextInt();
                        Socio socio = biblioteca.buscarSocio(p_dni);
                        if (socio != null) {
                            System.out.println(socio.toString());
                        } else {
                            System.out.println("NO SE ENCONTRÓ EL SOCIO...");
                        }
                        System.out.println("*************************************************************");
                        break;
                    case 11:
                        System.out.println("***********************************************************");
                        System.out.println(biblioteca.listaDeSocios());
                        System.out.println("**************************************");
                        System.out.println("=============================================================");
                        break;
                    case 12:
                        System.out.println("=============================================================");
                        int opT;
                        Scanner entradaOT = new Scanner(System.in);
                        System.out.println("Ingrese el tipo de socio que quiere saber la cantidad!");

                        System.out.println("[1] ESTUDIANTE");
                        System.out.println("[2] DOCENTE ");
                        System.out.println("=============================================================");
                        System.out.print("INGRESAR OPCION QUE QUIERE USAR: ");
                        opT = entradaOT.nextInt();
                        if (opT == 1) {
                            System.out.println("*************************************************************");
                            System.out.println("Hay una cantidad de " + biblioteca.cantidadDeSociosPorTipo("Estudiante")
                                    + " socios estudiantes. ");
                            System.out.println("*************************************************************");
                        } else if (opT == 2) {
                            System.out.println("=============================================================");
                            System.out.println("Hay una cantidad de " + biblioteca.cantidadDeSociosPorTipo("Docente")
                                    + " socios docentes. ");
                            System.out.println("**************************************************************");
                        }
                        break;
                    case 13:
                        System.out.println("=============================================================");
                        System.out.println(biblioteca.listaDeLibros());
                        break;
                    case 14:
                       System.out.println(biblioteca.listaDeTitulos());
                       break;

                    case 0:
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                        System.out.println("****************************************");
                        System.out.println("  GRACIAS POR USAR LA APP!    ");
                        System.out.println("****************************************");
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                        break;
                    default:
                        System.out.println("Ingrese opcion valida...");
                        break;

                }
            } while (opcion != 0);
        } catch (Exception error) {
            System.out.println("\nDebe respetar el formato");
            System.out.println("\nExcepcion: " + error);
        }

        leer.close();
        entradaOP.close();
        entradaTitulo.close();
        entradaTipo.close();
        entradaNombre.close();
        entradaEditoral.close();
        entradaEdicion.close();
        entradaDNI.close();
        entradaCarrera.close();
        entradaAño.close();
        entradaArea.close();
    }
}


