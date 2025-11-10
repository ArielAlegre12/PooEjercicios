------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all they need to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE: Biblioteca
PURPOSE OF PROJECT: Representar un gestor de biblioteca que permite administrar los préstamos de libros a Docentes o Estudiantes.
VERSION or DATE: 1.5
HOW TO START THIS PROJECT: Este proyecto empezó como propuesta de trabajo integrador de la cátedra de Programación Orientada a Objetos.
AUTHORS: Alegre Ariel Santiago, Antoniow Agustín, Colman Lucas, Boilini Uriel, Barrios Guadalupe, Alfonso Mariana.
USER INSTRUCTIONS:
- Primero debe ejecutar "InterfazBiblioteca", hacer click derecho sobre la clase y seleccionar "void main(String[] args)".
- Se inicia la interfaz, en la primera pantalla tendrá la ventana de "Inicio" donde se visualiza el título de la Biblioteca, y las opciones 
 "Iniciar" y "Salir".
- En la pantalla de "Iniciar", tendrá el menú principal, con opciones para trabajar con los libros o con socios.

  PANTALLA GESTIONAR LIBROS
  
- En la pantalla de "Gestionar Libros", tendrá la lista de libros agregados, botón para poder ver las características de un libro seleccionado
 (si o si debe seleccionar el elemento con el que quiere trabajar), botones de consultar quién posee el libro, quitar un libro o agregar un libro.
- Al presionar el de agregar un libro lo llevara al formulario de ingreso de datos, este cuenta con 4 campos (Título (título del libro/texto), Edición (número de edición/números), 
  Editorial (nombre de la editorial/texto) y Año (año de publicación/número)), estos campos cuentan con validaciones como:
   - Ingreso de datos en todos los campos (sin campos vacíos).
   - Ingreso correcto de datos en distintos campos (que sean del tipo de datos que deben ser o que tengan una longitud razonable).
   - Ingreso de un año lógico (que esté en el rango de 1800 a año actual).
- Una vez cargado los datos y agregados. el sistema automáticamente guarda estos, así que puede cerrar el sistema sin problemas que al
  volver a entrar, estarán.
  
  PANTALLA GESTIONAR SOCIOS
  
- En la pantalla de "Gestionar Socios", tendrá la lista de socios agregados (con sus características individuales y si tienen prestamos), tendrá 
  botones para ver las características, seleccionar un socio (esto permite ir a una pantalla para pedir libros o devolver libros, si es docente 
  tendrá permitido pedir más días luego de comprobar si es responsable, por el momento tiene tope de 60 días, también para comprobar si tiene el préstamo
  vencido), quitar socio o agregar socio.
- Al presionar el de agregar socio lo llevara al formulario de ingreso de datos, este pedirá que ingrese si va a registrar un Docente o Estudiante.
- Si eligió un Docente tendrá los campos de Nombre (nombre del docente/texto), DNI (dni del docente/números) y Área (área de especialidad/texto).
  Este cuenta con distintas validaciones similares a las de un libro en cuanto a ingreso de datos, por ej.:
   - Ingreso de datos en todos los campos (Sin campos vacíos).
   - Ingreso correcto de los datos en los distintos campos (que sean del tipo de datos que deben ser o que tengan una longitud razonable).
   - Ingreso de un DNI lógico (que al menos supere al millón).
   - Ingreso de un DNI que no haya sido ya registrado.
   

  
