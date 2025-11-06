/**
 * Manejo de interfaz para usuario, biblioteca.
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.GridBagConstraints;
import javax.swing.JScrollPane;

public class InterfazBibliotecaArielGeneralizado{
    private JFrame ventana;
    private CardLayout layout;
    private JPanel contenedor;
    private Biblioteca biblioteca;
    private final Color colorFondo;
    private final Color colorBoton;
    private JTextArea areaLibros;
    private DefaultListModel<Libro> modeloLibros = new DefaultListModel<>();

    
    public InterfazBibliotecaArielGeneralizado(){
        biblioteca = new Biblioteca("Biblioteca Arielo");
        colorFondo = new Color(227,100,100);
        colorBoton = Color.BLACK;
        inicializarVentana();
        incializarContenedor();
        agregarPantallas();
        mostrarVentana();   
    }
    
    /**
     * método que incializa la ventana, con titulo(será el nombre de la biblioteca), tamaño alto y ancho. y permitiendo cerrar el programa.
     */
    private void inicializarVentana(){
        ventana = new JFrame(biblioteca.getNombre());
        ventana.setSize(500, 400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
    }
    
    /**
     * método que incializa el contenedor
     */
    private void incializarContenedor(){
        layout = new CardLayout();
        contenedor = new JPanel(layout);
        ventana.add(contenedor);
    }
    
    /**
     * método para agregar pantallas
     */
    private void agregarPantallas(){
        contenedor.add(crearPantallaInicio(), "Inicio");
        contenedor.add(crearPantallaMenu(), "Menu"); 
        contenedor.add(gestionarLibros(), "GestionLibros");
        contenedor.add(agregarLibro(), "AgregarLibro");
        contenedor.add(crearPantallaListarLibros(), "ListarLibros");
        contenedor.add(crearPantallaQuitarLibro(), "QuitarLibros");
    }
    
    /**
     * método para mostrar la ventana
     */
    private void mostrarVentana(){
        ventana.setVisible(true);
    }
    
    /**
     * Creo una botonera en general para navegar por los paneles.
     * 
     */
    public JPanel crearBotonera(String panelAnterior, boolean mostrarVolver){
        JPanel botonera = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        botonera.setBackground(colorFondo);
        JButton botonSalir = crearBoton("Salir",130,e->System.exit(0));
        
        //en caso de que sea la pantalla de incio jei
        if(mostrarVolver){
            JButton botonVolver  = crearBoton("Volver Atrás",130,e->layout.show(contenedor,panelAnterior));
            botonera.add(botonVolver);
        }
        botonera.add(botonSalir);
        return botonera;
    }
    
    /**
     * metodo que crea el panel con la pantalla ded inicio
     */
    private JPanel crearPantallaInicio(){
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(colorFondo);
        
        //creo el centro
        JPanel centro = new JPanel();
        centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));
        centro.setBackground(panel.getBackground());
        centro.setMaximumSize(new Dimension(600, Integer.MAX_VALUE));
        
        
        //agrego los paneles.
        centro.add(Box.createVerticalStrut(30));
        centro.add(Box.createVerticalGlue());
        centro.add(crearTituloConIcono(panel.getBackground()));
        centro.add(Box.createVerticalStrut(10));
        centro.add(crearPanelImagenes(panel.getBackground()));
        centro.add(Box.createVerticalStrut(20));
        centro.add(crearMensajeBienvenida());
        centro.add(Box.createVerticalStrut(20));
        centro.add(crearPanelBotonesPaginaPrincipal(panel.getBackground()));
        centro.add(Box.createVerticalGlue());
        
        panel.add(centro, BorderLayout.CENTER);
        return panel;
    }
    
    /**
     * método para crear la pantalla del menú
     */
    private JPanel crearPantallaMenu(){
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(colorFondo);
        //titulo
        JLabel titulo = new JLabel("Menú Principal", JLabel.CENTER);
        titulo.setFont(new Font("Arial",Font.BOLD,32));
        titulo.setForeground(Color.WHITE);
        titulo.setBorder(BorderFactory.createEmptyBorder(20,0,10,0));
        
        //subtitulo(especificación)
        JLabel subtitulo = new JLabel("Haga Click en una opción", JLabel.CENTER);
        subtitulo.setFont(new Font("Arial", Font.PLAIN, 16));
        subtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        subtitulo.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        //botón gestionar libros
        JButton botonLibros = crearBoton("Gestionar Libros",250,e->layout.show(contenedor, "GestionLibros"));
        //instanciar la img para ponerla al aldo del boton
        botonLibros.setIcon(new ImageIcon(new ImageIcon("D:/Descarga de IDM/Comprimidos/TrabajoIntegradorEjemplos/img/books-illustration-cartoon-books-books-vector.jpg").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
        //boton gestionar socios
        JButton botonSocios = crearBoton("Gestionar Socios",250,e->layout.show(contenedor, ""));
        botonSocios.setIcon(new ImageIcon(new ImageIcon("D:/Descarga de IDM/Comprimidos/TrabajoIntegradorEjemplos/img/iconAlumProfe.png").getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH)));
    
        //panel central con botones.
        JPanel opcionesPanel = new JPanel();
        opcionesPanel.setBackground(panel.getBackground());
        opcionesPanel.setLayout(new BoxLayout(opcionesPanel, BoxLayout.Y_AXIS));
        opcionesPanel.add(Box.createVerticalStrut(20));
        opcionesPanel.add(botonLibros);
        opcionesPanel.add(Box.createVerticalStrut(20));
        opcionesPanel.add(botonSocios);
        opcionesPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        //le agregamos un envoltorio
        JPanel envoltorio = new JPanel(new FlowLayout(FlowLayout.CENTER));
        envoltorio.setBackground(panel.getBackground());
        envoltorio.add(opcionesPanel);
        
        //boton Volver
        JButton botonVolver = crearBoton("Volver Atrás",130,e->layout.show(contenedor, "Inicio"));
        JPanel volverPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        volverPanel.setBackground(panel.getBackground());
        volverPanel.add(botonVolver);
        
        //el armao final jei
        JPanel centro = new JPanel();
        centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));
        centro.setBackground(panel.getBackground());
        centro.add(titulo);
        centro.add(subtitulo);
        centro.add(envoltorio);
        
        
        panel.add(centro, BorderLayout.CENTER);
        panel.add(volverPanel, BorderLayout.SOUTH);
        
        return panel;
    }
    
    /**
     * método para crear el titulo con imagen
     */
    private JPanel crearTituloConIcono(Color fondo){
        //instancio el titulo
        JLabel titulo = new JLabel(biblioteca.getNombre(), JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 32));
        titulo.setForeground(Color.WHITE);
        
        //instancio la imagen.
        ImageIcon IconoOriginal = new ImageIcon("D:/Descarga de IDM/Comprimidos/TrabajoIntegradorEjemplos/img/books-illustration-cartoon-books-books-vector.jpg");
        Image imagenEscalada = IconoOriginal.getImage().getScaledInstance(40,40,    Image.SCALE_SMOOTH);
        JLabel icono = new JLabel(new ImageIcon(imagenEscalada));
        
        //instancio el panel
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER,10,0));
        panel.setBackground(fondo);
        panel.add(titulo);
        panel.add(icono);
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        return panel;
    }
    
    /**
     * método para crear paneles de imagenes.
     * que será usado en el inicio
     */
    private JPanel crearPanelImagenes(Color fondo){
        ImageIcon profeOriginal = new ImageIcon("D:/Descarga de IDM/Comprimidos/TrabajoIntegradorEjemplos/img/docenteAnimado.jpg");
        Image profeEscalado = profeOriginal.getImage().getScaledInstance(50,90,Image.SCALE_SMOOTH);
        JLabel profe = new JLabel(new ImageIcon(profeEscalado));
        
        ImageIcon alumnoOriginal = new ImageIcon("D:/Descarga de IDM/Comprimidos/TrabajoIntegradorEjemplos/img/estudiante animado.jpg");
        Image alumnoEscalado = alumnoOriginal .getImage().getScaledInstance(50,90,Image.SCALE_SMOOTH);
        JLabel alumno = new JLabel(new ImageIcon(alumnoEscalado));
        
        //instancio el panel
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER,10,0));
        panel.setBackground(fondo);
        panel.add(profe);
        panel.add(alumno);
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        return panel;
    }
    
    /**
     * crea el msj de bienvenida.
     */
    private JLabel crearMensajeBienvenida(){
        JLabel mensaje = new JLabel("<html><div style='text-align: center;'>En esta app podrás gestionar tus libros prestados<br>a Docentes y Estudiantes.</div></html>", JLabel.CENTER);
        mensaje.setFont(new Font("Arial", Font.PLAIN,16));
        mensaje.setForeground(Color.WHITE);
        mensaje.setAlignmentX(Component.CENTER_ALIGNMENT);
        return mensaje;
    }
    
    /**
     * crea los botones y los agrega al panel
     */
    private JPanel crearPanelBotonesPaginaPrincipal(Color fondo){
        JButton botonIniciar = crearBoton("Iniciar",130,e->layout.show(contenedor, "Menu"));
        JButton botonSalir = crearBoton("Salir",130,e->System.exit(0));
        
        
        
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER,20,0));
        panel.setBackground(fondo);
        panel.add(botonIniciar);
        panel.add(botonSalir);
        return panel;
    }
    
    /**
     * método que representa el menu de gestion del socio.
     * este permite, agregar, quitar o listar libros. y tambien ver que socio tiene "x"libros.
     */
    private JPanel gestionarLibros(){
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(colorFondo);
        JLabel titulo = new JLabel("Libros", JLabel.CENTER);
        titulo.setFont(new Font("Arial",Font.BOLD,32));
        titulo.setForeground(Color.WHITE);
        titulo.setBorder(BorderFactory.createEmptyBorder(20,0,10,0));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        //creo los botones necesarios
        JButton botonAgregar = crearBoton("Agregar Libro",200,e->layout.show(contenedor,"AgregarLibro"));
        JButton botonQuitar = crearBoton("Quitar Libro", 200,e->{
            refrescarListaLibros(); //  actualiza el modelo
            layout.show(contenedor, "QuitarLibros"); 
        });
        JButton botonSocioTieneLibro = crearBoton("¿Qué socio tiene el libro?", 200,e->layout.show(contenedor, ""));
        JButton botonListarLibros = crearBoton("Listar Libros",200,e->{
            areaLibros.setText(biblioteca.listaDeLibros());
            layout.show(contenedor,"ListarLibros");
        });
        //panel central con botones
        JPanel opcionesPanel = new JPanel();
        opcionesPanel.setBackground(colorFondo);
        opcionesPanel.setLayout(new BoxLayout(opcionesPanel, BoxLayout.Y_AXIS));
        opcionesPanel.add(Box.createVerticalStrut(20));
        opcionesPanel.add(botonAgregar);
        opcionesPanel.add(Box.createVerticalStrut(10));
        opcionesPanel.add(botonQuitar);
        opcionesPanel.add(Box.createVerticalStrut(10));
        opcionesPanel.add(botonSocioTieneLibro);
        opcionesPanel.add(Box.createVerticalStrut(10));
        opcionesPanel.add(botonListarLibros);
        opcionesPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // Panel central
        JPanel centro = new JPanel();
        centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));
        centro.setBackground(panel.getBackground());
        centro.add(titulo);
        centro.add(Box.createVerticalStrut(10));
        centro.add(opcionesPanel);
        
        panel.add(centro, BorderLayout.CENTER);
        panel.add(crearBotonera("Menu",true), BorderLayout.SOUTH);
        return panel;
    }
    
    /**
     * Método para crear la pantalla que lista los libros y permite quitarlos.
     * deberian listarse en botones?
     */
    private JPanel crearPantallaQuitarLibro(){
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(colorFondo);
        
         //para mostrar msjs
        JLabel mensajeLabel = new JLabel("");
        mensajeLabel.setForeground(Color.WHITE);
        mensajeLabel.setFont(new Font("Arial", Font.PLAIN,14));
        mensajeLabel.setBorder(BorderFactory.createEmptyBorder(5,0,10,0));
        mensajeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        //titulo
        JLabel titulo = new JLabel("Quitar Libros", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD,24));
        titulo.setForeground(Color.WHITE);
        titulo.setBorder(BorderFactory.createEmptyBorder(20,0,10,0));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        //panel para titulo y mensaje
        JPanel encabezado = new JPanel();
        encabezado.setLayout(new BoxLayout(encabezado, BoxLayout.Y_AXIS));
        encabezado.setBackground(colorFondo);
        encabezado.add(titulo);
        encabezado.add(mensajeLabel);
        panel.add(encabezado, BorderLayout.NORTH);
        
        //Modelo de la lista 
        modeloLibros.clear();
        for(Libro libro: biblioteca.getLibros()){
            modeloLibros.addElement(libro);
        }
        
        //lista de libros
        JList<Libro> listaLibros = new JList<>(modeloLibros);
        listaLibros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaLibros.setFont(new Font("Arial", Font.BOLD,14));
        JScrollPane scroll = new JScrollPane(listaLibros);
        scroll.setBorder(BorderFactory.createTitledBorder("Libros Disponibles: " + biblioteca.getLibros().size()));
        //añado la lista de libros ya añadidas al scroll
        panel.add(scroll, BorderLayout.CENTER);
        //boton quitar
        JButton botonQuitar = crearBoton("Quitar Libro",150,e->{
           Libro seleccionado = listaLibros.getSelectedValue();
           if(biblioteca.getLibros().size() == 0){
               mostrarMensajetemporal(mensajeLabel,"No hay libros para eliminar",3000);
           }else{
           if(seleccionado != null){
               if(!seleccionado.prestado()){
                   biblioteca.quitarLibro(seleccionado);
                   modeloLibros.removeElement(seleccionado);
                   mostrarMensajetemporal(mensajeLabel,"Libro eliminado correctamente",3000);
                }else{
                   mostrarMensajetemporal(mensajeLabel,"No se puede eliminar un libro que está prestad, je", 3000);
                    }
                  }else{
               mostrarMensajetemporal(mensajeLabel,"Seleccione un libro para eliminar",3000);
                }
            }
        });
        
        //centro
        JPanel centro = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centro.setBackground(colorFondo);
        centro.add(botonQuitar);
        //panel sur
        JPanel pie = new JPanel(new BorderLayout());
        pie.setBackground(colorFondo);
        pie.add(centro, BorderLayout.CENTER);
        pie.add(crearBotonera("GestionLibros",true), BorderLayout.SOUTH);
               
        panel.add(pie, BorderLayout.SOUTH);
        return panel;
    }
    
    /**
     * metodo para refrescar la lista de libros
     */
    public void refrescarListaLibros() {
    modeloLibros.clear();
    for (Libro libro : biblioteca.getLibros()) {
        modeloLibros.addElement(libro);
        }
    }

    
    /**
     * método para listar los libros (generar la pantalla)
     */
    private JPanel crearPantallaListarLibros(){
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(colorFondo);
        
        JLabel titulo = new JLabel("Listado de Libros", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD,32));
        titulo.setForeground(Color.WHITE);
        titulo.setBorder(BorderFactory.createEmptyBorder(20,0,10,0));
        
        areaLibros = new JTextArea(15,40);
        areaLibros.setEditable(false);
        areaLibros.setFont(new Font("Arial", Font.PLAIN,14));
        areaLibros.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        String resultado = biblioteca.listaDeLibros();
        
        JScrollPane scroll = new JScrollPane(areaLibros);
        scroll.setPreferredSize(new Dimension(600,300));
        
        //panel centro
        JPanel centro = new JPanel();
        centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));
        centro.setBackground(colorFondo);
        centro.add(titulo);
        centro.add(Box.createVerticalStrut(10));
        centro.add(scroll);
        centro.add(Box.createVerticalStrut(10));
        
        
        panel.add(centro, BorderLayout.CENTER);
        panel.add(crearBotonera("GestionLibros",true), BorderLayout.SOUTH);
        
        return panel;
    }
    
    /**
     * método para agregar libro
     */
    private JPanel agregarLibro(){
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(colorFondo);
        
        JLabel titulo = new JLabel("Agregar Libro", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD,32));
        titulo.setForeground(Color.WHITE);
        titulo.setBorder(BorderFactory.createEmptyBorder(20,0,10,0));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        //campos para rellenar jei
        JTextField campoTitulo = new JTextField(20);
        JTextField campoEdicion = new JTextField(20);
        JTextField campoEditorial = new JTextField(20);
        JTextField campoAnio = new JTextField(20);
        
        //etiquetas
        JLabel labelTitulo = new JLabel("Titulo:");
        labelTitulo.setHorizontalAlignment(SwingConstants.RIGHT);
        labelTitulo.setBounds(50, 80, 100, 30);
        
        JLabel labelEdicion  = new JLabel("Edición:");
        labelEdicion.setHorizontalAlignment(SwingConstants.RIGHT);
        JLabel labelEditorial = new JLabel("Editorial:");
        labelEditorial.setHorizontalAlignment(SwingConstants.RIGHT);
        JLabel labelAnio = new JLabel("Año:");
        labelAnio.setHorizontalAlignment(SwingConstants.RIGHT);

        
        //panel del formu
        JPanel formulario = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,10);
        gbc.anchor = GridBagConstraints.WEST;
        
        
        gbc.gridx = 0; gbc.gridy = 0;
        formulario.add(new JLabel("Titulo:"), gbc);
        gbc.gridx = 1;
        formulario.add(campoTitulo, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        formulario.add(new JLabel("Edicion:"), gbc);
        gbc.gridx = 1;
        formulario.add(campoEdicion, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        formulario.add(new JLabel("Editorial:"), gbc);
        gbc.gridx = 1;
        formulario.add(campoEditorial, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3;
        formulario.add(new JLabel("Año:"), gbc);
        gbc.gridx = 1;
        formulario.add(campoAnio, gbc);
        //mensaje de estado
        JLabel mensajeEstado = new JLabel("", JLabel.CENTER);
        mensajeEstado.setForeground(Color.YELLOW);
        mensajeEstado.setFont(new Font("Arial", Font.PLAIN,14));
        
        //contenedor de formulario
        JPanel contenedorFormulario = new JPanel();
        contenedorFormulario.setLayout(new BoxLayout(contenedorFormulario, BoxLayout.Y_AXIS));
        contenedorFormulario.setBackground(panel.getBackground());
        contenedorFormulario.setAlignmentX(Component.CENTER_ALIGNMENT);
        contenedorFormulario.add(formulario);
        contenedorFormulario.add(Box.createVerticalStrut(10));
        contenedorFormulario.add(mensajeEstado);
        contenedorFormulario.setMaximumSize(new Dimension(400, formulario.getPreferredSize().height));
        
        
        
        //Boton agregar
        JButton  botonAgregar = crearBoton("Agregar",150, e->{
            String tituloLibro = campoTitulo.getText().trim();
            String editorialLibro = campoEditorial.getText().trim();
            //uso de excepcion para comprobar el correcto ingreso de los datos que son int ;-;.
            try{
                int edicionLibro = Integer.parseInt(campoEdicion.getText().trim());//trim() lo que hace es eliminar los espacios en blanco al principio y final de la cadena
                int anioLibro = Integer.parseInt(campoAnio.getText().trim());
                
                if(!tituloLibro.isEmpty() && !editorialLibro.isEmpty()){
                    Libro nuevoLibro = new Libro(tituloLibro, edicionLibro, editorialLibro, anioLibro);
                    biblioteca.agregarLibro(nuevoLibro);
                    mostrarMensajetemporal(mensajeEstado, "Libro agregado correctamente.", 3000);
                    campoTitulo.setText("");
                    campoEdicion.setText("");
                    campoEditorial.setText("");
                    campoAnio.setText("");
                }else{
                    mostrarMensajetemporal(mensajeEstado, "Completa los campos CRACK!", 3000);
                }
            } catch(NumberFormatException ex){
                mostrarMensajetemporal(mensajeEstado, "Los campos de Edición y año deben tener números!.", 3000);
            }
        });
        
        //panel central
        JPanel centro = new JPanel();
        centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));
        centro.setBackground(colorFondo);
        centro.add(titulo);
        centro.add(Box.createVerticalStrut(10));
        centro.add(contenedorFormulario);
        centro.add(Box.createVerticalStrut(10));
        centro.add(botonAgregar);
        
        panel.add(centro, BorderLayout.CENTER);
        panel.add(crearBotonera("GestionLibros",true), BorderLayout.SOUTH);
        return panel;
    }
    
    /**
     * método para mensaje temporal
     */
    private void mostrarMensajetemporal(JLabel destino, String mensaje, int milisegundos){
        destino.setText(mensaje);
        Timer tiempo = new Timer(milisegundos, evt->destino.setText(""));
        tiempo.setRepeats(false);
        tiempo.start();
    }
    
    /**
     * metodo para crear botones genericos.
     */
    private JButton crearBoton(String nombre, int ancho, ActionListener evento){
        JButton boton = new JButton(nombre);
        boton.setFont(new Font("Arial", Font.BOLD,15));
        boton.setBackground(colorBoton);
        boton.setForeground(Color.white);
        boton.setFocusPainted(false);
        boton.setPreferredSize(new Dimension(ancho,40));
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        boton.addActionListener(evento);
        return boton;
    }
    
    /**
     * metodo main para ejecutar el programa
     */
    public static void main(String args[]){
        SwingUtilities.invokeLater(()->new InterfazBibliotecaArielGeneralizado());
    }
}
