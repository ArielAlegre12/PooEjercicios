import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.TitledBorder;
/**
 * Manejo de interfaz para usuario, biblioteca.
 * falta pulir muchas cosas, como la reutilización de código. efe
 * 
 * @author Alegre Ariel 
 */

public class InterfazBiblioteca{
    private JFrame ventana;
    private CardLayout layout;
    private JPanel contenedor;
    private Biblioteca biblioteca;
    private final Color colorFondo;
    private final Color colorBoton;
    private JTextArea areaLibros;
    private DefaultListModel<Libro> modeloLibros;
    private DefaultListModel<Socio> modeloSocios;
    private JScrollPane scrollLibros;
    private JScrollPane scrollSocios;
    
    /**
     * constructor 
     */
    public InterfazBiblioteca() {
        biblioteca = new Biblioteca("Biblioteca Arielo");
        colorFondo = new Color(227, 100, 100);
        modeloLibros = new DefaultListModel<>();
        modeloSocios = new DefaultListModel<>();
        colorBoton = Color.BLACK;
        inicializarVentana();
        incializarContenedor();
        agregarPantallas();
        mostrarVentana();
    }

    /**
     * método que incializa la ventana, con titulo(será el nombre de la biblioteca),
     * tamaño alto y ancho. y permitiendo cerrar el programa.
     */
    private void inicializarVentana() {
        ventana = new JFrame(biblioteca.getNombre());
        ventana.setSize(500, 400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
    }

    /**
     * método que incializa el contenedor
     */
    private void incializarContenedor() {
        layout = new CardLayout();
        contenedor = new JPanel(layout);
        ventana.add(contenedor);
    }

    /**
     * método para agregar pantallas
     */
    private void agregarPantallas() {
        contenedor.add(crearPantallaInicio(), "Inicio");
        contenedor.add(crearPantallaMenu(), "Menu");
        contenedor.add(agregarLibro(), "AgregarLibro");
        contenedor.add(crearPantallaListarLibros(), "ListarLibros");
        contenedor.add(crearPantallaGestionLibros(), "GestionLibros");
        contenedor.add(crearPantallaGestionSociosListar(), "GestionSocios");
        contenedor.add(crearPantallaAgregarQuitarSocios(), "AgregarQuitarSocios");
    }

    /**
     * método para mostrar la ventana
     */
    private void mostrarVentana() {
        ventana.setVisible(true);
    }

    /**
     * Creo una botonera en general para navegar por los paneles.
     * 
     */
    public JPanel crearBotonera(String panelAnterior, boolean mostrarVolver) {
        JPanel botonera = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        botonera.setBackground(colorFondo);
        JButton botonSalir = crearBoton("Salir", 130, e -> System.exit(0));

        // en caso de que sea la pantalla de incio jei
        if (mostrarVolver) {
            JButton botonVolver = crearBoton("Volver Atrás", 130, e -> layout.show(contenedor, panelAnterior));
            botonera.add(botonVolver);
        }
        botonera.add(botonSalir);
        return botonera;
    }

    /**
     * metodo que crea el panel con la pantalla ded inicio
     */
    private JPanel crearPantallaInicio() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(colorFondo);

        // creo el centro
        JPanel centro = new JPanel();
        centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));
        centro.setBackground(panel.getBackground());
        centro.setMaximumSize(new Dimension(600, Integer.MAX_VALUE));

        // agrego los paneles.
        centro.add(Box.createVerticalStrut(30));
        centro.add(Box.createVerticalGlue());
        centro.add(crearTituloConIcono(biblioteca.getNombre(), 32, Color.WHITE, colorFondo, "img/bibliotecaIcono.png"));
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
     * Método para crear el título
     */
    private JLabel crearTitulo(String nombre) {
        JLabel titulo = new JLabel(nombre, JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(Color.WHITE);
        titulo.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        return titulo;
    }

    /**
     * Método para envolver cualquier componente y centrarlo horizontalmente
     */
    private JPanel envolverCentrado(Component componente) {
        JPanel envoltorio = new JPanel(new FlowLayout(FlowLayout.CENTER));
        envoltorio.setBackground(colorFondo);
        envoltorio.add(componente);
        return envoltorio;
    }

    /**
     * método para crear la pantalla del menú
     */
    private JPanel crearPantallaMenu() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(colorFondo);
        // titulo
        JPanel titulo = crearTituloConIcono("Menú Principal", 24, Color.WHITE, colorFondo, "img/bibliotecaIcon.png");

        // subtitulo(especificación)
        JLabel subtitulo = new JLabel("Haga Click en una opción", JLabel.CENTER);
        subtitulo.setFont(new Font("Arial", Font.PLAIN, 16));
        subtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        subtitulo.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        // botón gestionar libros
        JButton botonLibros = crearBoton("Gestionar Libros", 250, e -> {
            refrescarListaLibros();
            layout.show(contenedor, "GestionLibros");
        });
        // instanciar la img para ponerla al aldo del boton
        botonLibros.setIcon(new ImageIcon(
                new ImageIcon("img/iconoLibros.jpg").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
        // boton gestionar socios
        JButton botonSocios = crearBoton("Gestionar Socios", 250, e -> {
            refrescarListaSocios();
            layout.show(contenedor, "GestionSocios");
        });
        botonSocios.setIcon(new ImageIcon(
                new ImageIcon("img/iconAlumProfe.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));

        // panel central con botones.
        JPanel opcionesPanel = new JPanel();
        opcionesPanel.setBackground(panel.getBackground());
        opcionesPanel.setLayout(new BoxLayout(opcionesPanel, BoxLayout.Y_AXIS));
        opcionesPanel.add(Box.createVerticalStrut(20));
        opcionesPanel.add(botonLibros);
        opcionesPanel.add(Box.createVerticalStrut(20));
        opcionesPanel.add(botonSocios);
        opcionesPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // le agregamos un envoltorio
        JPanel envoltorio = new JPanel(new FlowLayout(FlowLayout.CENTER));
        envoltorio.setBackground(panel.getBackground());
        envoltorio.add(opcionesPanel);

        // boton Volver
        JButton botonVolver = crearBoton("Volver Atrás", 130, e -> layout.show(contenedor, "Inicio"));
        // botonSalir
        JButton botonSalir = crearBoton("Salir", 130, e -> System.exit(0));
        JPanel volverPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        volverPanel.setBackground(panel.getBackground());
        volverPanel.add(botonVolver);
        volverPanel.add(botonSalir);

        // el armao final jei
        JPanel centro = new JPanel();
        centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));
        centro.setBackground(panel.getBackground());
        centro.add(Box.createVerticalStrut(30));
        centro.add(titulo);
        centro.add(subtitulo);
        centro.add(envoltorio);

        panel.add(centro, BorderLayout.CENTER);
        panel.add(volverPanel, BorderLayout.SOUTH);

        return panel;
    }

    /**
     * Método para crear el título con imagen
     */
    private JPanel crearTituloConIcono(String texto, int tamañoFuente, Color colorTexto, Color fondo,
            String rutaIcono) {
        // Instancio el título
        JLabel titulo = new JLabel(texto, JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, tamañoFuente));
        titulo.setForeground(colorTexto);

        // Instancio la imagen
        ImageIcon iconoOriginal = new ImageIcon(rutaIcono);
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        JLabel icono = new JLabel(new ImageIcon(imagenEscalada));

        // Instancio el panel
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
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
    private JPanel crearPanelImagenes(Color fondo) {
        ImageIcon profeOriginal = new ImageIcon(
                "img/docenteAnimado.jpg");
        Image profeEscalado = profeOriginal.getImage().getScaledInstance(50, 90, Image.SCALE_SMOOTH);
        JLabel profe = new JLabel(new ImageIcon(profeEscalado));

        ImageIcon alumnoOriginal = new ImageIcon(
                "img/estudiante animado.jpg");
        Image alumnoEscalado = alumnoOriginal.getImage().getScaledInstance(50, 90, Image.SCALE_SMOOTH);
        JLabel alumno = new JLabel(new ImageIcon(alumnoEscalado));

        // instancio el panel
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        panel.setBackground(fondo);
        panel.add(profe);
        panel.add(alumno);
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        return panel;
    }

    /**
     * crea el msj de bienvenida.
     */
    private JLabel crearMensajeBienvenida() {
        JLabel mensaje = new JLabel(
                "<html><div style='text-align: center;'>En esta app podrás gestionar tus libros prestados<br>a Docentes y Estudiantes.</div></html>",
                JLabel.CENTER);
        mensaje.setFont(new Font("Arial", Font.PLAIN, 16));
        mensaje.setForeground(Color.WHITE);
        mensaje.setAlignmentX(Component.CENTER_ALIGNMENT);
        return mensaje;
    }

    /**
     * crea los botones y los agrega al panel
     */
    private JPanel crearPanelBotonesPaginaPrincipal(Color fondo) {
        JButton botonIniciar = crearBoton("Iniciar", 130, e -> layout.show(contenedor, "Menu"));
        JButton botonSalir = crearBoton("Salir", 130, e -> System.exit(0));

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        panel.setBackground(fondo);
        panel.add(botonIniciar);
        panel.add(botonSalir);
        return panel;
    }

    /**
     * Método para crear la pantalla que lista los libros y permite quitar,
     * agregar(lleva al panel de agregar)
     * y ver que socio tiene el libro
     */
    private JPanel crearPantallaGestionLibros() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(colorFondo);

        // para mostrar msjs
        JLabel mensajeLabel = new JLabel("");
        mensajeLabel.setForeground(Color.WHITE);
        mensajeLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        mensajeLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 10, 0));
        mensajeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // titulo
        JPanel titulo = crearTituloConIcono("Gestión  de los Libros", 24, Color.WHITE, colorFondo,
                "img/bibliotecaIcon.png");

        // panel para titulo y mensaje(encabezado)
        JPanel encabezado = new JPanel();
        encabezado.setLayout(new BoxLayout(encabezado, BoxLayout.Y_AXIS));
        encabezado.setBackground(colorFondo);
        encabezado.add(titulo);
        encabezado.add(mensajeLabel);
        panel.add(encabezado, BorderLayout.NORTH);

        // Modelo de la lista
        modeloLibros.clear();
        for (Libro libro : biblioteca.getLibros()) {
            modeloLibros.addElement(libro);
        }

        // lista de libros
        JList<Libro> listaLibros = new JList<>(modeloLibros);
        listaLibros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaLibros.setFont(new Font("Arial", Font.BOLD, 14));
        scrollLibros = new JScrollPane(listaLibros);
        scrollLibros
                .setBorder(BorderFactory.createTitledBorder("Libros Disponibles: " + biblioteca.getLibros().size()));
        panel.add(scrollLibros, BorderLayout.CENTER);
        // boton quitar
        JButton botonQuitar = crearBoton("Quitar Libro", 150, e -> {
            Libro seleccionado = listaLibros.getSelectedValue();
            if (biblioteca.getLibros().size() == 0) {
                mostrarMensajetemporal(mensajeLabel, "No hay libros para eliminar", 3000);
            } else {
                if (seleccionado != null) {
                    if (!seleccionado.prestado()) {
                        biblioteca.quitarLibro(seleccionado);
                        modeloLibros.removeElement(seleccionado);
                        mostrarMensajetemporal(mensajeLabel, "Libro eliminado correctamente", 3000);
                    } else {
                        mostrarMensajetemporal(mensajeLabel, "No se puede eliminar un libro que está prestad, je",
                                3000);
                    }
                } else {
                    mostrarMensajetemporal(mensajeLabel, "Seleccione un libro para eliminar", 3000);
                }
            }
        });

        // botón para ver quien tiene el libro
        JButton botonVerSocio = crearBoton("¿Quién tiene el Libro?", 150, e -> {
            Libro seleccionado = listaLibros.getSelectedValue();
            if (seleccionado != null) {
                String resultado = biblioteca.quienTieneElLibro(seleccionado);
                mostrarMensajetemporal(mensajeLabel, resultado, 3000);
            } else {
                mostrarMensajetemporal(mensajeLabel, "Seleccione un libro para preguntar", 3000);
            }
        });

        // botón para agregar un libro
        JButton botonAgregar = crearBoton("Agregar Libro", 150, e -> {
            layout.show(contenedor, "AgregarLibro");
        });

        // boton para mostrar caracteristicas del libro, se usa hmtl para un texto más
        // centrado
        JButton botonVerDetalles = crearBoton("Ver Caracteristicas", 150, e -> {
            Libro seleccionado = listaLibros.getSelectedValue();
            if (seleccionado != null) {
                String estado;
                if (seleccionado.prestado()) {
                    estado = "Prestado";
                } else {
                    estado = "Disponible";
                }
                String detalles = "<html><body style='text-aling:center;'>"
                        + "<b>Titulo:</b> " + seleccionado.getTitulo() + "<br"
                        + "<b>Edicción:</b> " + seleccionado.getEdicion() + "<br>"
                        + "<b>Año:</b> " + seleccionado.getAnio() + "<br>"
                        + "<b>Estado:</b> " + estado + "<br>"
                        + "</body></html>";
                mostrarMensajetemporal(mensajeLabel, detalles, 10000);
            } else {
                mostrarMensajetemporal(mensajeLabel, "Seleccione un libro para ver sus caracteristicas", 3000);
            }
        });

        // Ajusto el tamaño de algunos botones que no se ven del todo
        botonVerSocio.setText("<html><center>¿Quién <br>tiene el libro?</center></html>");
        botonVerDetalles.setText("<html><center>Ver<br>características</center></html>");

        // para que los botones puedan verse acomodados, hay que ponerlos en dos filas
        JPanel botonesFila1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        botonesFila1.setBackground(colorFondo);
        botonesFila1.add(botonQuitar);
        botonesFila1.add(botonAgregar);

        JPanel botonesFila2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        botonesFila2.setBackground(colorFondo);
        botonesFila2.add(botonVerDetalles);
        botonesFila2.add(botonVerSocio);

        // centro
        JPanel centro = new JPanel();
        centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));
        centro.setBackground(colorFondo);
        centro.add(botonesFila2);
        centro.add(botonesFila1);
        // panel sur
        JPanel pie = new JPanel(new BorderLayout());
        pie.setBackground(colorFondo);
        pie.add(centro, BorderLayout.CENTER);
        pie.add(crearBotonera("Menu", true), BorderLayout.SOUTH);

        panel.add(pie, BorderLayout.SOUTH);
        return panel;
    }

    /**
     * Refresca la cantidad de elementos en el array de libros.
     */
    private void actualizarTituloListaLibros() {
        ((TitledBorder) scrollLibros.getBorder()).setTitle("Libros Disponibles: " + biblioteca.getLibros().size());
        scrollLibros.repaint();
    }

    /**
     * metodo para refrescar la lista de libros
     */
    public void refrescarListaLibros() {
        modeloLibros.clear();
        actualizarTituloListaLibros();
        for (Libro libro : biblioteca.getLibros()) {
            modeloLibros.addElement(libro);
        }
    }

    /**
     * método para listar los libros (generar la pantalla)
     */
    private JPanel crearPantallaListarLibros() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(colorFondo);

        JLabel titulo = new JLabel("Listado de Libros", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 32));
        titulo.setForeground(Color.WHITE);
        titulo.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));

        areaLibros = new JTextArea(15, 40);
        areaLibros.setEditable(false);
        areaLibros.setFont(new Font("Arial", Font.PLAIN, 14));
        areaLibros.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        String resultado = biblioteca.listaDeLibros();

        JScrollPane scroll = new JScrollPane(areaLibros);
        scroll.setPreferredSize(new Dimension(600, 300));

        // panel centro
        JPanel centro = new JPanel();
        centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));
        centro.setBackground(colorFondo);
        centro.add(titulo);
        centro.add(Box.createVerticalStrut(10));
        centro.add(scroll);
        centro.add(Box.createVerticalStrut(10));

        panel.add(centro, BorderLayout.CENTER);
        panel.add(crearBotonera("GestionLibros", true), BorderLayout.SOUTH);

        return panel;
    }

    /**
     * método para agregar libro
     */
    private JPanel agregarLibro() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(colorFondo);

        JPanel titulo = crearTituloConIcono("Agregar Libro ", 24, Color.WHITE, colorFondo, "img/bibliotecaIcon.png");

        // el msj de estado
        JLabel mensajeLabel = new JLabel("");
        mensajeLabel.setForeground(Color.WHITE);
        mensajeLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        mensajeLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 10, 0));
        mensajeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel encabezado = new JPanel();
        encabezado.setLayout(new BoxLayout(encabezado, BoxLayout.Y_AXIS));
        encabezado.setBackground(colorFondo);
        encabezado.add(titulo);
        encabezado.add(mensajeLabel);
        panel.add(encabezado, BorderLayout.NORTH);

        // campos para rellenar jei
        JTextField campoTitulo = new JTextField(20);
        JTextField campoEdicion = new JTextField(20);
        JTextField campoEditorial = new JTextField(20);
        JTextField campoAnio = new JTextField(20);

        // etiquetas
        JLabel labelTitulo = new JLabel("Titulo:");
        labelTitulo.setHorizontalAlignment(SwingConstants.RIGHT);
        labelTitulo.setBounds(50, 80, 100, 30);

        JLabel labelEdicion = new JLabel("Edición:");
        labelEdicion.setHorizontalAlignment(SwingConstants.RIGHT);
        JLabel labelEditorial = new JLabel("Editorial:");
        labelEditorial.setHorizontalAlignment(SwingConstants.RIGHT);
        JLabel labelAnio = new JLabel("Año:");
        labelAnio.setHorizontalAlignment(SwingConstants.RIGHT);

        // panel del formu
        JPanel formulario = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        formulario.add(new JLabel("Titulo:"), gbc);
        gbc.gridx = 1;
        formulario.add(campoTitulo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        formulario.add(new JLabel("Edicion:"), gbc);
        gbc.gridx = 1;
        formulario.add(campoEdicion, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        formulario.add(new JLabel("Editorial:"), gbc);
        gbc.gridx = 1;
        formulario.add(campoEditorial, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        formulario.add(new JLabel("Año:"), gbc);
        gbc.gridx = 1;
        formulario.add(campoAnio, gbc);

        // contenedor de formulario
        JPanel contenedorFormulario = new JPanel();
        contenedorFormulario.setLayout(new BoxLayout(contenedorFormulario, BoxLayout.Y_AXIS));
        contenedorFormulario.setAlignmentX(Component.CENTER_ALIGNMENT);
        contenedorFormulario.add(formulario);
        contenedorFormulario.setMaximumSize(new Dimension(400, formulario.getPreferredSize().height));

        // Boton agregar
        JButton botonAgregar = crearBoton("Agregar", 150, e -> {
            String tituloLibro = campoTitulo.getText().trim();
            String editorialLibro = campoEditorial.getText().trim();
            String edicionTexto = campoEdicion.getText().trim();
            String anioTexto = campoAnio.getText().trim();

            try {
                // la validacion externa
                ValidarLibro.validar(tituloLibro, editorialLibro, edicionTexto, anioTexto);
                // hace la conversión segura, si pasaron la validación
                int edicionLibro = Integer.parseInt(edicionTexto);
                int anioLibro = Integer.parseInt(anioTexto);

                // Instancia un libro y lo agrega a la biblioteca
                Libro nuevoLibro = new Libro(tituloLibro, edicionLibro, editorialLibro, anioLibro);
                biblioteca.agregarLibro(nuevoLibro);
                refrescarListaLibros();
                mostrarMensajetemporal(mensajeLabel, "Libro Agregado sastifactoriamente jeje", 3000);

                // limpiar los campos
                campoTitulo.setText("");
                campoEdicion.setText("");
                campoEditorial.setText("");
                campoAnio.setText("");
            } catch (ValidarIngresoLibrosException ex) {
                mostrarMensajetemporal(mensajeLabel, ex.getMessage(), 4000);
            }
        });

        // panel central
        JPanel centro = new JPanel();
        centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));
        centro.setBackground(colorFondo);
        centro.add(encabezado);
        centro.add(Box.createVerticalStrut(10));
        centro.add(contenedorFormulario);
        centro.add(Box.createVerticalStrut(10));
        centro.add(botonAgregar);

        panel.add(centro, BorderLayout.CENTER);
        panel.add(crearBotonera("GestionLibros", true), BorderLayout.SOUTH);
        return panel;
    }

    /**
     * método para mensaje temporal
     */
    private void mostrarMensajetemporal(JLabel destino, String mensaje, int milisegundos) {
        destino.setText(mensaje);
        Timer tiempo = new Timer(milisegundos, evt -> destino.setText(""));
        tiempo.setRepeats(false);
        tiempo.start();
    }

    /**
     * metodo para crear botones genericos.
     */
    private JButton crearBoton(String nombre, int ancho, ActionListener evento) {
        JButton boton = new JButton(nombre);
        boton.setFont(new Font("Arial", Font.BOLD, 15));
        boton.setBackground(colorBoton);
        boton.setForeground(Color.white);
        boton.setFocusPainted(false);
        boton.setPreferredSize(new Dimension(ancho, 40));
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        boton.addActionListener(evento);
        return boton;
    }

    /**
     * método para trabajar en la lista de socios y gestionarla
     */
    private JPanel crearPantallaGestionSociosListar() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(colorFondo);

        // el msj de estado
        JLabel mensajeLabel = new JLabel("");
        mensajeLabel.setForeground(Color.WHITE);
        mensajeLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        mensajeLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 10, 0));
        mensajeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // encabezado
        JPanel encabezado = new JPanel();
        encabezado.setLayout(new BoxLayout(encabezado, BoxLayout.Y_AXIS));
        encabezado.setBackground(colorFondo);
        encabezado.add(crearTituloConIcono("Gestión Socios", 24, Color.WHITE, colorFondo, "img/sociosIcon.png"));
        encabezado.add(mensajeLabel);
        panel.add(encabezado, BorderLayout.NORTH);

        // modelo de la lsita
        modeloSocios.clear();
        for (Socio socio : biblioteca.getSocios()) {
            modeloSocios.addElement(socio);
        }

        // lista de los socios
        JList<Socio> listaSocios = new JList<>(modeloSocios);
        listaSocios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaSocios.setFont(new Font("Arial", Font.BOLD, 14));
        scrollSocios = new JScrollPane(listaSocios);
        scrollSocios
                .setBorder(BorderFactory.createTitledBorder("Socios Registrados: " + biblioteca.getSocios().size()));
        panel.add(scrollSocios, BorderLayout.CENTER);

        // quitarSocio
        JButton botonQuitar = crearBoton("Quitar Socio", 150, e -> {
            Socio seleccionado = listaSocios.getSelectedValue();
            if (modeloSocios.isEmpty()) {
                mostrarMensajetemporal(mensajeLabel, "No hay socios para eliminar", 3000);
            } else if (seleccionado != null) {
                if (seleccionado.catLibrosPrestados() > 0) {
                    mostrarMensajetemporal(mensajeLabel, "No se puede eliminar un socio con libros prestados", 3000);
                } else {
                    biblioteca.quitarSocio(seleccionado);
                    modeloSocios.removeElement(seleccionado);
                    mostrarMensajetemporal(mensajeLabel, seleccionado.soyDeLaClase() + " eliminado correctamente",
                            3000);
                    refrescarListaSocios();
                }
            }
        });

        // btoon ver las caractersitcas
        JButton botonVerDetalles = crearBoton("Ver características", 150, e -> {
            Socio seleccionado = listaSocios.getSelectedValue();
            if (seleccionado != null) {
                String campoExtra = "";
                if (seleccionado instanceof Docente) {
                    campoExtra = ((Docente) seleccionado).getArea();
                } else if (seleccionado instanceof Estudiante) {
                    campoExtra = ((Estudiante) seleccionado).getCarrera();
                }
                String detalles = "<html><body style='text-align:center;'>"
                        + "<b>Nombre:</b> " + seleccionado.getNombre() + "<br>"
                        + "<b>DNI:</b> " + seleccionado.getDniSocio() + "<br>"
                        + "<b>Tipo:</b> " + (seleccionado instanceof Docente ? "Docente" : "Estudiante") + "<br>";

                if (seleccionado instanceof Docente) {
                    detalles += "<b>Área:</b> " + ((Docente) seleccionado).getArea() + "<br>";
                } else if (seleccionado instanceof Estudiante) {
                    detalles += "<b>Carrera:</b> " + ((Estudiante) seleccionado).getCarrera() + "<br>";
                }

                detalles += "</body></html>";

                mostrarMensajetemporal(mensajeLabel, detalles, 10000);
            } else {
                mostrarMensajetemporal(mensajeLabel, "Seleccione un socio para ver sus características", 3000);
            }
        });

        // ir a x socio
        JButton botonSeleccionar = crearBoton("Seleccionar Socio", 150, e -> {
            Socio seleccionado = listaSocios.getSelectedValue();
            if (seleccionado != null) {
                mostrarPantallaSocioOpExtras(seleccionado.soyDeLaClase());
            } else {
                mostrarMensajetemporal(mensajeLabel, "Seleccione un socio para continuar", 3000);
            }
        });

        // boton que lleva para agregar socio
        JButton botonAgregar = crearBoton("Agregar Socio", 150, e -> {
            layout.show(contenedor, "AgregarQuitarSocios");
        });

        // para que se vea mejor visualmente
        botonVerDetalles.setText("<html><center>Ver<br>características</center></html>");
        botonSeleccionar.setText("<html><center>Seleccionar<br>Socio</center></html>");

        // organizar en dos filas los botones
        JPanel botonesFila1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 5));
        botonesFila1.setBackground(colorFondo);
        botonesFila1.add(botonQuitar);
        botonesFila1.add(botonAgregar);

        JPanel botonesFila2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 5));
        botonesFila2.setBackground(colorFondo);
        botonesFila2.add(botonVerDetalles);
        botonesFila2.add(botonSeleccionar);

        // centro
        JPanel centro = new JPanel();
        centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));
        centro.setBackground(colorFondo);
        centro.add(Box.createVerticalStrut(10));
        centro.add(envolverCentrado(botonesFila2));
        centro.add(Box.createVerticalStrut(10));
        centro.add(envolverCentrado(botonesFila1));
        centro.add(Box.createVerticalStrut(10));

        // pie(olor a pata el que lee)
        JPanel pie = new JPanel(new BorderLayout());
        pie.setBackground(colorFondo);
        pie.add(centro, BorderLayout.CENTER);
        pie.add(crearBotonera("Menu", true), BorderLayout.SOUTH);

        panel.add(pie, BorderLayout.SOUTH);
        return panel;
    }

    /**
     * Pantalla para agregar o quitar socios
     */
    private JPanel crearPantallaAgregarQuitarSocios() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(colorFondo);

        // Creo el título
        JPanel titulo = crearTituloConIcono("Seleccionar tipo de Socio", 24, Color.WHITE, colorFondo,
                "img/sociosIcon.png");

        // Botones de selección
        JButton botonDocente = crearBoton("Docente", 150, e -> mostrarFormularioSocio("Docente"));
        botonDocente.setIcon(new ImageIcon(
                new ImageIcon("img/docenteIcon.png").getImage().getScaledInstance(30, 40, Image.SCALE_SMOOTH)));
        JButton botonEstudiante = crearBoton("Estudiante", 150, e -> mostrarFormularioSocio("Estudiante"));
        botonEstudiante.setIcon(new ImageIcon(
                new ImageIcon("img/alumnoIcon.png").getImage().getScaledInstance(30, 40, Image.SCALE_SMOOTH)));

        // Panel central
        JPanel centro = new JPanel();
        centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));
        centro.setBackground(colorFondo);

        centro.add(Box.createVerticalStrut(30));
        centro.add(titulo);
        centro.add(Box.createVerticalStrut(20));
        centro.add(envolverCentrado(botonDocente));
        centro.add(Box.createVerticalStrut(10));
        centro.add(envolverCentrado(botonEstudiante));

        panel.add(centro, BorderLayout.CENTER);
        panel.add(crearBotonera("GestionSocios", true), BorderLayout.SOUTH);

        return panel;
    }

    /**
     * refrescar la lista de socios
     */
    public void refrescarListaSocios() {
        modeloSocios.clear();
        actualizarTituloListaSocios();
        for (Socio socio : biblioteca.getSocios()) {
            modeloSocios.addElement(socio);
        }
    }

    /**
     * actualizar scroll de socios
     */
    public void actualizarTituloListaSocios() {
        if (scrollSocios != null) {
            scrollSocios.setBorder(
                    BorderFactory.createTitledBorder("Socios Registrados: " + biblioteca.getSocios().size()));
        }
    }
    /**
     * generar y trabajar en el panel del formu de socios, recibe el tipo de socio
     * y varia el ingreso de área/carrera. también la cantidad de dias asginados de prestamos.
     */

    private void mostrarFormularioSocio(String tipoSocio) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(colorFondo);

        JLabel titulo = crearTitulo("Formulario");

        // el msj de estado
        JLabel mensajeLabel = new JLabel("");
        mensajeLabel.setForeground(Color.WHITE);
        mensajeLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        mensajeLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 10, 0));
        mensajeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel encabezado = new JPanel();
        encabezado.setLayout(new BoxLayout(encabezado, BoxLayout.Y_AXIS));
        encabezado.setBackground(colorFondo);
        encabezado.add(titulo);
        encabezado.add(mensajeLabel);
        panel.add(encabezado, BorderLayout.NORTH);

        // Campos
        JTextField campoNombre = new JTextField(20);
        JTextField campoDni = new JTextField(20);
        JTextField campoExtra = new JTextField(20);

        JLabel labelNombre = new JLabel("Nombre:");
        JLabel labelDni = new JLabel("DNI:");
        JLabel labelExtra = new JLabel(tipoSocio.equalsIgnoreCase("Docente") ? "Área:" : "Carrera:");

        labelNombre.setHorizontalAlignment(SwingConstants.RIGHT);
        labelDni.setHorizontalAlignment(SwingConstants.RIGHT);
        labelExtra.setHorizontalAlignment(SwingConstants.RIGHT);

        // Formulario con GridBagLayout
        JPanel formulario = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        // nombre
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        formulario.add(labelNombre, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formulario.add(campoNombre, gbc);

        // dni
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        formulario.add(labelDni, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formulario.add(campoDni, gbc);

        // campo extra
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        formulario.add(labelExtra, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formulario.add(campoExtra, gbc);

        // Contenedor vertical
        JPanel contenedorFormulario = new JPanel();
        contenedorFormulario.setLayout(new BoxLayout(contenedorFormulario, BoxLayout.Y_AXIS));
        contenedorFormulario.setAlignmentX(Component.CENTER_ALIGNMENT);
        contenedorFormulario.add(formulario);
        contenedorFormulario.setMaximumSize(new Dimension(400, formulario.getPreferredSize().height));

        // Botón agregar
        JButton botonAgregar = crearBoton("Agregar", 150, e -> {
            String nombre = campoNombre.getText().trim();
            String dniTexto = campoDni.getText().trim();
            String campo = campoExtra.getText().trim();
            try {
                ValidarSocio.validar(nombre, dniTexto, tipoSocio, campo);
                int dni = Integer.parseInt(dniTexto);

                if (biblioteca.buscarSocio(dni) != null) {
                    mostrarMensajetemporal(mensajeLabel, "Ya existe un socio con ese DNI", 3000);
                    return;
                }

                if (tipoSocio.equalsIgnoreCase("Docente")) {
                    Docente nuevoDocente = new Docente(campo, dni, nombre, 5);
                    biblioteca.agregarSocio(nuevoDocente);
                } else {
                    Estudiante nuevoEstudiante = new Estudiante(campo, dni, nombre, 20);
                    biblioteca.agregarSocio(nuevoEstudiante);
                }

                mostrarMensajetemporal(mensajeLabel, tipoSocio + " agregado correctamente", 3000);
                campoNombre.setText("");
                campoDni.setText("");
                campoExtra.setText("");
                refrescarListaSocios();
            } catch (ValidarIngresoSocioException ex) {
                mostrarMensajetemporal(mensajeLabel, ex.getMessage(), 3000);
            }
        });

        // Panel central
        JPanel centro = new JPanel();
        centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));
        centro.setBackground(colorFondo);
        centro.add(encabezado);
        centro.add(Box.createVerticalStrut(10));
        centro.add(contenedorFormulario);
        centro.add(Box.createVerticalStrut(10));
        centro.add(botonAgregar);

        panel.add(centro, BorderLayout.CENTER);
        panel.add(crearBotonera("AgregarQuitarSocios", true), BorderLayout.SOUTH);

        String nombrePanel = "FormularioSocio_" + tipoSocio;
        panel.setName(nombrePanel);
        contenedor.add(panel, nombrePanel);
        contenedor.revalidate();
        contenedor.repaint();
        layout.show(contenedor, nombrePanel);
    }
    
    /**
     * crear la pantalla para tener más opciones del socio, pedir libro por ahora lo cual listara los libros 
     * podra seleccionarlo si el libro esta disponible.
     * aquí la seleccion dependera si es docente o estudiante al socio que hizo click
     */
    public void mostrarPantallaSocioOpExtras(String tipoSocio){
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(colorFondo);
        
        panel.add(crearBotonera("GestionSocios",true), BorderLayout.SOUTH);
        String nombrePanel = "Opciones_Extras_De_" + tipoSocio;
        panel.setName(nombrePanel);
        contenedor.add(panel);
        contenedor.revalidate();
        contenedor.repaint();
        layout.show(contenedor,nombrePanel);
    }

    /**
     * metodo main para ejecutar el programa
     */
    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> new InterfazBiblioteca());
    }
}