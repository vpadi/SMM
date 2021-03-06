package sm.vpc.iu;

import java.awt.Color;
import java.awt.KeyboardFocusManager;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import javax.swing.JFileChooser;
import sm.vpc.iu.Lienzo2D;
import sm.vpc.iu.ventanaDimensionImagen;
import sm.vpc.iu.ventanaInterna;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Víctor Padi
 */
public class MainWindow extends javax.swing.JFrame {
    private ventanaDimensionImagen ventDim;
    
    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
        
        ventDim = new ventanaDimensionImagen(this, rootPaneCheckingEnabled);
        
        colorShow.setBackground(Color.BLACK);
        
        KeyboardFocusManager focusManager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        focusManager.addPropertyChangeListener(new FocusManagerListener());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoHerramientas = new javax.swing.ButtonGroup();
        jSeparator1 = new javax.swing.JSeparator();
        barraInferior = new javax.swing.JPanel();
        infoPanel = new javax.swing.JPanel();
        herramientaText = new javax.swing.JLabel();
        mousePosicionText = new javax.swing.JLabel();
        atributosPanel = new javax.swing.JPanel();
        colorPanel = new javax.swing.JPanel();
        rojoSlider = new javax.swing.JSlider();
        rojoTexto = new javax.swing.JTextField();
        verdeSlider = new javax.swing.JSlider();
        verdeTexto = new javax.swing.JTextField();
        azulSlider = new javax.swing.JSlider();
        azulTexto = new javax.swing.JTextField();
        colorShow = new javax.swing.JTextField();
        grosorPanel = new javax.swing.JPanel();
        grosorSpinner = new javax.swing.JSpinner();
        barraHerramientas = new javax.swing.JToolBar();
        nuevoArchivoBoton = new javax.swing.JButton();
        abrirArchivoBoton = new javax.swing.JButton();
        guardarArchivoBoton = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        puntoHerramienta = new javax.swing.JToggleButton();
        lineaHerramienta = new javax.swing.JToggleButton();
        rectanguloHerramienta = new javax.swing.JToggleButton();
        elipseHerramienta = new javax.swing.JToggleButton();
        editarHerramienta = new javax.swing.JToggleButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        rellenoHerramienta = new javax.swing.JToggleButton();
        alisadoHerramienta = new javax.swing.JToggleButton();
        transparenciaHerramienta = new javax.swing.JToggleButton();
        escritorioTrabajo = new javax.swing.JDesktopPane();
        barraMenu = new javax.swing.JMenuBar();
        archivoMenu = new javax.swing.JMenu();
        nuevoArchivo = new javax.swing.JMenuItem();
        abrirArchivo = new javax.swing.JMenuItem();
        guardarArchivo = new javax.swing.JMenuItem();
        verMenu = new javax.swing.JMenu();
        verBarraEstado = new javax.swing.JCheckBoxMenuItem();
        verBarraAtributos = new javax.swing.JCheckBoxMenuItem();
        verBarraFormas = new javax.swing.JCheckBoxMenuItem();
        imagenMenu = new javax.swing.JMenu();
        cambiarTamMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        barraInferior.setLayout(new java.awt.BorderLayout());

        infoPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        infoPanel.setAlignmentX(0.1F);
        infoPanel.setFocusable(false);
        infoPanel.setLayout(new java.awt.BorderLayout());

        herramientaText.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        infoPanel.add(herramientaText, java.awt.BorderLayout.LINE_START);
        infoPanel.add(mousePosicionText, java.awt.BorderLayout.LINE_END);

        barraInferior.add(infoPanel, java.awt.BorderLayout.PAGE_END);

        atributosPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        colorPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Color", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 3, 14))); // NOI18N

        rojoSlider.setMaximum(255);
        rojoSlider.setToolTipText("Barra para seleccionar la cantidad de rojo");
        rojoSlider.setValue(0);
        rojoSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rojoSliderStateChanged(evt);
            }
        });

        rojoTexto.setEditable(false);
        rojoTexto.setBackground(new java.awt.Color(204, 204, 204));
        rojoTexto.setForeground(new java.awt.Color(0, 0, 0));
        rojoTexto.setText("R");
        rojoTexto.setToolTipText("");
        rojoTexto.setBorder(null);

        verdeSlider.setMaximum(255);
        verdeSlider.setToolTipText("Barra para seleccionar la cantidad de verde");
        verdeSlider.setValue(0);
        verdeSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                verdeSliderStateChanged(evt);
            }
        });

        verdeTexto.setEditable(false);
        verdeTexto.setBackground(new java.awt.Color(204, 204, 204));
        verdeTexto.setText("G");
        verdeTexto.setBorder(null);

        azulSlider.setMaximum(255);
        azulSlider.setToolTipText("Barra para seleccionar la cantidad de azul");
        azulSlider.setValue(0);
        azulSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                azulSliderStateChanged(evt);
            }
        });

        azulTexto.setEditable(false);
        azulTexto.setBackground(new java.awt.Color(204, 204, 204));
        azulTexto.setText("B");
        azulTexto.setBorder(null);

        colorShow.setEditable(false);
        colorShow.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout colorPanelLayout = new javax.swing.GroupLayout(colorPanel);
        colorPanel.setLayout(colorPanelLayout);
        colorPanelLayout.setHorizontalGroup(
            colorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(colorPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(colorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(colorPanelLayout.createSequentialGroup()
                        .addComponent(verdeTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(verdeSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(colorPanelLayout.createSequentialGroup()
                        .addComponent(azulTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(azulSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(colorPanelLayout.createSequentialGroup()
                        .addComponent(rojoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rojoSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(colorShow, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        colorPanelLayout.setVerticalGroup(
            colorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(colorPanelLayout.createSequentialGroup()
                .addGroup(colorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(colorPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(colorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rojoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rojoSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addGroup(colorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(verdeTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verdeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, colorPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(colorShow, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)))
                .addGroup(colorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(azulSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(azulTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        atributosPanel.add(colorPanel);

        grosorPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Grosor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 3, 14))); // NOI18N
        grosorPanel.setPreferredSize(new java.awt.Dimension(159, 150));

        grosorSpinner.setValue(1);
        grosorSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                grosorSpinnerStateChanged(evt);
            }
        });

        javax.swing.GroupLayout grosorPanelLayout = new javax.swing.GroupLayout(grosorPanel);
        grosorPanel.setLayout(grosorPanelLayout);
        grosorPanelLayout.setHorizontalGroup(
            grosorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(grosorPanelLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(grosorSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        grosorPanelLayout.setVerticalGroup(
            grosorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, grosorPanelLayout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addComponent(grosorSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        atributosPanel.add(grosorPanel);

        barraInferior.add(atributosPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(barraInferior, java.awt.BorderLayout.PAGE_END);

        barraHerramientas.setRollover(true);

        nuevoArchivoBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/nuevo.png"))); // NOI18N
        nuevoArchivoBoton.setToolTipText("Crea un nueva venta en blanco");
        nuevoArchivoBoton.setFocusable(false);
        nuevoArchivoBoton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nuevoArchivoBoton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        nuevoArchivoBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoArchivoBotonActionPerformed(evt);
            }
        });
        barraHerramientas.add(nuevoArchivoBoton);

        abrirArchivoBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/abrir.png"))); // NOI18N
        abrirArchivoBoton.setToolTipText("Abre un archivo y lo carga en una ventana nueva");
        abrirArchivoBoton.setFocusable(false);
        abrirArchivoBoton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        abrirArchivoBoton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        abrirArchivoBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirArchivoBotonActionPerformed(evt);
            }
        });
        barraHerramientas.add(abrirArchivoBoton);

        guardarArchivoBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/guardar.png"))); // NOI18N
        guardarArchivoBoton.setToolTipText("Guarda la ventana seleccionada en una imagen");
        guardarArchivoBoton.setFocusable(false);
        guardarArchivoBoton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        guardarArchivoBoton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        guardarArchivoBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarArchivoBotonActionPerformed(evt);
            }
        });
        barraHerramientas.add(guardarArchivoBoton);
        barraHerramientas.add(jSeparator2);

        grupoHerramientas.add(puntoHerramienta);
        puntoHerramienta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/punto.png"))); // NOI18N
        puntoHerramienta.setToolTipText(" Herramienta punto (cuadrado)");
        puntoHerramienta.setFocusable(false);
        puntoHerramienta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        puntoHerramienta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        puntoHerramienta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                puntoHerramientaActionPerformed(evt);
            }
        });
        barraHerramientas.add(puntoHerramienta);

        grupoHerramientas.add(lineaHerramienta);
        lineaHerramienta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/linea.png"))); // NOI18N
        lineaHerramienta.setToolTipText("Dibuja una línea desde un primer punto seleccionado hasta donde se arrastre el ratón");
        lineaHerramienta.setFocusable(false);
        lineaHerramienta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lineaHerramienta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lineaHerramienta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lineaHerramientaActionPerformed(evt);
            }
        });
        barraHerramientas.add(lineaHerramienta);

        grupoHerramientas.add(rectanguloHerramienta);
        rectanguloHerramienta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/rectangulo.png"))); // NOI18N
        rectanguloHerramienta.setToolTipText("Herramienta para dibujar un cuadrado");
        rectanguloHerramienta.setFocusable(false);
        rectanguloHerramienta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        rectanguloHerramienta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        rectanguloHerramienta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rectanguloHerramientaActionPerformed(evt);
            }
        });
        barraHerramientas.add(rectanguloHerramienta);

        grupoHerramientas.add(elipseHerramienta);
        elipseHerramienta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/elipse.png"))); // NOI18N
        elipseHerramienta.setToolTipText("Herramienta para dibujar una elipse");
        elipseHerramienta.setFocusable(false);
        elipseHerramienta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        elipseHerramienta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        elipseHerramienta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elipseHerramientaActionPerformed(evt);
            }
        });
        barraHerramientas.add(elipseHerramienta);

        grupoHerramientas.add(editarHerramienta);
        editarHerramienta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/seleccion.png"))); // NOI18N
        editarHerramienta.setToolTipText("Herramienta para recolocar figuras");
        editarHerramienta.setFocusable(false);
        editarHerramienta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        editarHerramienta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        editarHerramienta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarHerramientaActionPerformed(evt);
            }
        });
        barraHerramientas.add(editarHerramienta);
        barraHerramientas.add(jSeparator5);

        rellenoHerramienta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/rellenar.png"))); // NOI18N
        rellenoHerramienta.setToolTipText("Activar el relleno de las figuras");
        rellenoHerramienta.setFocusable(false);
        rellenoHerramienta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        rellenoHerramienta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        rellenoHerramienta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rellenoHerramientaActionPerformed(evt);
            }
        });
        barraHerramientas.add(rellenoHerramienta);

        alisadoHerramienta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/alisar.png"))); // NOI18N
        alisadoHerramienta.setToolTipText("Activa el suavizado de bordes");
        alisadoHerramienta.setFocusable(false);
        alisadoHerramienta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        alisadoHerramienta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        alisadoHerramienta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alisadoHerramientaActionPerformed(evt);
            }
        });
        barraHerramientas.add(alisadoHerramienta);

        transparenciaHerramienta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/transparencia.png"))); // NOI18N
        transparenciaHerramienta.setToolTipText("Activa la transparencia de figuras (alfa = 0.5)");
        transparenciaHerramienta.setFocusable(false);
        transparenciaHerramienta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        transparenciaHerramienta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        transparenciaHerramienta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transparenciaHerramientaActionPerformed(evt);
            }
        });
        barraHerramientas.add(transparenciaHerramienta);

        getContentPane().add(barraHerramientas, java.awt.BorderLayout.PAGE_START);

        escritorioTrabajo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                escritorioTrabajoMouseMoved(evt);
            }
        });

        javax.swing.GroupLayout escritorioTrabajoLayout = new javax.swing.GroupLayout(escritorioTrabajo);
        escritorioTrabajo.setLayout(escritorioTrabajoLayout);
        escritorioTrabajoLayout.setHorizontalGroup(
            escritorioTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1143, Short.MAX_VALUE)
        );
        escritorioTrabajoLayout.setVerticalGroup(
            escritorioTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 356, Short.MAX_VALUE)
        );

        getContentPane().add(escritorioTrabajo, java.awt.BorderLayout.CENTER);

        archivoMenu.setText("Archivo");

        nuevoArchivo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        nuevoArchivo.setText("Nuevo");
        nuevoArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoArchivoActionPerformed(evt);
            }
        });
        archivoMenu.add(nuevoArchivo);

        abrirArchivo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        abrirArchivo.setText("Abrir");
        abrirArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirArchivoActionPerformed(evt);
            }
        });
        archivoMenu.add(abrirArchivo);

        guardarArchivo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        guardarArchivo.setText("Guardar");
        guardarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarArchivoActionPerformed(evt);
            }
        });
        archivoMenu.add(guardarArchivo);

        barraMenu.add(archivoMenu);

        verMenu.setText("Ver");

        verBarraEstado.setSelected(true);
        verBarraEstado.setText("Barra de estado");
        verBarraEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verBarraEstadoActionPerformed(evt);
            }
        });
        verMenu.add(verBarraEstado);

        verBarraAtributos.setSelected(true);
        verBarraAtributos.setText("Barra de atributos");
        verBarraAtributos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verBarraAtributosActionPerformed(evt);
            }
        });
        verMenu.add(verBarraAtributos);

        verBarraFormas.setSelected(true);
        verBarraFormas.setText("Barra de Formas");
        verBarraFormas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verBarraFormasActionPerformed(evt);
            }
        });
        verMenu.add(verBarraFormas);

        barraMenu.add(verMenu);

        imagenMenu.setText("Imagen");

        cambiarTamMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        cambiarTamMenu.setText("Cambiar tamaño de la imágen");
        cambiarTamMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarTamMenuActionPerformed(evt);
            }
        });
        imagenMenu.add(cambiarTamMenu);

        barraMenu.add(imagenMenu);

        setJMenuBar(barraMenu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void actualizarColor(){
        Color color;

        color = new Color(rojoSlider.getValue(), verdeSlider.getValue(), azulSlider.getValue(), 255);
        
        colorShow.setBackground(color);
        
        ventanaInterna vi;
        vi = (ventanaInterna)escritorioTrabajo.getSelectedFrame();
       
        if(vi != null)
            vi.getLienzo().setColor(rojoSlider.getValue(), verdeSlider.getValue(), azulSlider.getValue());
    }
    
    private void nuevaVentana(){
        ventanaInterna vi = new ventanaInterna(this, ventDim.getAncho(), ventDim.getAlto());
       
        escritorioTrabajo.add(vi);
        vi.setVisible(true);
                
        puntoHerramienta.doClick();
        
        rojoSlider.setValue(0);
        verdeSlider.setValue(0);
        azulSlider.setValue(0);
        
        grosorSpinner.setValue(1);
        
        rellenoHerramienta.setSelected(false);
        alisadoHerramienta.setSelected(false);
        transparenciaHerramienta.setSelected(false);
    }
    
    private void abrirArchivo(){
        JFileChooser dlg = new JFileChooser();
        int resp = dlg.showOpenDialog(this);
        
        if( resp == JFileChooser.APPROVE_OPTION) {
            File f = dlg.getSelectedFile();
            //Código
        }
    }
    
    private void guardarArchivo(){
        JFileChooser dlg = new JFileChooser();
        int resp = dlg.showSaveDialog(this);
        
        if( resp == JFileChooser.APPROVE_OPTION) {
            File f = dlg.getSelectedFile();
            //Código
        }
    }
    
    private void nuevoArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoArchivoActionPerformed
        this.nuevaVentana();
    }//GEN-LAST:event_nuevoArchivoActionPerformed

    private void lineaHerramientaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lineaHerramientaActionPerformed
        ventanaInterna vi;
        vi = (ventanaInterna)escritorioTrabajo.getSelectedFrame();
        
        herramientaText.setText("Línea");

        if(vi != null)
            vi.getLienzo().setHerramienta("linea");
        
    }//GEN-LAST:event_lineaHerramientaActionPerformed

    private void puntoHerramientaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_puntoHerramientaActionPerformed
        ventanaInterna vi;
        vi = (ventanaInterna)escritorioTrabajo.getSelectedFrame();
    
        if(vi != null)
            vi.getLienzo().setHerramienta("punto");
        
        herramientaText.setText("Punto");
    }//GEN-LAST:event_puntoHerramientaActionPerformed

    private void rectanguloHerramientaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rectanguloHerramientaActionPerformed
        ventanaInterna vi;
        vi = (ventanaInterna)escritorioTrabajo.getSelectedFrame();
        
        if(vi != null)
            vi.getLienzo().setHerramienta("rectangulo");
        
        herramientaText.setText("Rectangulo");
    }//GEN-LAST:event_rectanguloHerramientaActionPerformed

    private void elipseHerramientaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elipseHerramientaActionPerformed
        ventanaInterna vi;
        vi = (ventanaInterna)escritorioTrabajo.getSelectedFrame();
        
        if(vi != null)
            vi.getLienzo().setHerramienta("elipse");
        
      herramientaText.setText("Elipse");
    }//GEN-LAST:event_elipseHerramientaActionPerformed

    private void rojoSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rojoSliderStateChanged
        this.actualizarColor();
    }//GEN-LAST:event_rojoSliderStateChanged

    private void verdeSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_verdeSliderStateChanged
        this.actualizarColor();
    }//GEN-LAST:event_verdeSliderStateChanged

    private void azulSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_azulSliderStateChanged
        this.actualizarColor();
    }//GEN-LAST:event_azulSliderStateChanged

    private void rellenoHerramientaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rellenoHerramientaActionPerformed
        ventanaInterna vi;
        vi = (ventanaInterna)escritorioTrabajo.getSelectedFrame();
        
        if(vi != null)
            vi.getLienzo().setRelleno(rellenoHerramienta.isSelected());
    }//GEN-LAST:event_rellenoHerramientaActionPerformed

    private void grosorSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_grosorSpinnerStateChanged
        ventanaInterna vi;
        vi = (ventanaInterna)escritorioTrabajo.getSelectedFrame();
       
        if(vi != null)
            vi.getLienzo().setGrosor((int)grosorSpinner.getValue());
    }//GEN-LAST:event_grosorSpinnerStateChanged

    private void alisadoHerramientaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alisadoHerramientaActionPerformed
        ventanaInterna vi;
        vi = (ventanaInterna)escritorioTrabajo.getSelectedFrame();
        
        if(vi != null)
            vi.getLienzo().setAlisado(alisadoHerramienta.isSelected());
    }//GEN-LAST:event_alisadoHerramientaActionPerformed

    private void transparenciaHerramientaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transparenciaHerramientaActionPerformed
        ventanaInterna vi;
        vi = (ventanaInterna)escritorioTrabajo.getSelectedFrame();
        
        if(vi != null)
            vi.getLienzo().setTransparencia(transparenciaHerramienta.isSelected());
    }//GEN-LAST:event_transparenciaHerramientaActionPerformed

    private void guardarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarArchivoActionPerformed
        this.guardarArchivo();
    }//GEN-LAST:event_guardarArchivoActionPerformed

    private void verBarraEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verBarraEstadoActionPerformed
       infoPanel.setVisible(verBarraEstado.getState());
    }//GEN-LAST:event_verBarraEstadoActionPerformed

    private void verBarraAtributosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verBarraAtributosActionPerformed
        colorPanel.setVisible(verBarraAtributos.getState());
        grosorPanel.setVisible(verBarraAtributos.getState());
        
        alisadoHerramienta.setVisible(verBarraAtributos.getState());
        rellenoHerramienta.setVisible(verBarraAtributos.getState());
        transparenciaHerramienta.setVisible(verBarraAtributos.getState());
    }//GEN-LAST:event_verBarraAtributosActionPerformed

    private void verBarraFormasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verBarraFormasActionPerformed
        puntoHerramienta.setVisible(verBarraFormas.getState());
        lineaHerramienta.setVisible(verBarraFormas.getState());
        rectanguloHerramienta.setVisible(verBarraFormas.getState());
        elipseHerramienta.setVisible(verBarraFormas.getState());
        editarHerramienta.setVisible(verBarraFormas.getState());
    }//GEN-LAST:event_verBarraFormasActionPerformed

    private void editarHerramientaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarHerramientaActionPerformed
        ventanaInterna vi;
        vi = (ventanaInterna)escritorioTrabajo.getSelectedFrame();

        if(vi != null)
            vi.getLienzo().setEditar(editarHerramienta.isSelected());
        
        herramientaText.setText("Editar");
    }//GEN-LAST:event_editarHerramientaActionPerformed

    private void abrirArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirArchivoActionPerformed
        this.abrirArchivo();
    }//GEN-LAST:event_abrirArchivoActionPerformed

    private void abrirArchivoBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirArchivoBotonActionPerformed
        this.abrirArchivo();
    }//GEN-LAST:event_abrirArchivoBotonActionPerformed

    private void guardarArchivoBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarArchivoBotonActionPerformed
        this.guardarArchivo();
    }//GEN-LAST:event_guardarArchivoBotonActionPerformed

    private void nuevoArchivoBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoArchivoBotonActionPerformed
        this.nuevaVentana();
    }//GEN-LAST:event_nuevoArchivoBotonActionPerformed

    private void escritorioTrabajoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_escritorioTrabajoMouseMoved
        mousePosicionText.setText("( X: " + evt.getX() + ", Y: " + evt.getY() + ")");
    }//GEN-LAST:event_escritorioTrabajoMouseMoved

    private void cambiarTamMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarTamMenuActionPerformed
        ventDim.setVisible(true);
    }//GEN-LAST:event_cambiarTamMenuActionPerformed

    public void setPosicionText(String str){
        mousePosicionText.setText(str);
    }
    
    public class FocusManagerListener implements PropertyChangeListener {
        @Override
        public void propertyChange(PropertyChangeEvent e) {
            ventanaInterna vi;
            vi = (ventanaInterna)escritorioTrabajo.getSelectedFrame();

            Lienzo2D lienzo = null;

            if(vi != null)
                lienzo = vi.getLienzo();

            String herramienta;

            if(lienzo != null){
                editarHerramienta.setSelected(lienzo.getEditar());

                alisadoHerramienta.setSelected(lienzo.getAlisar());

                rellenoHerramienta.setSelected(lienzo.getRelleno());
                
                transparenciaHerramienta.setSelected(lienzo.getTransparencia());

                Color c = lienzo.getColor();

                rojoSlider.setValue(c.getRed());
                verdeSlider.setValue(c.getGreen());
                azulSlider.setValue(c.getBlue());

                grosorSpinner.setValue(lienzo.getGrosor());

                if(!lienzo.getEditar()){
                    herramienta = lienzo.getHerramienta();

                    switch(herramienta){
                        case "punto":
                            puntoHerramienta.setSelected(true);
                            break;
                        case "linea":
                            lineaHerramienta.setSelected(true);
                            break;
                        case "rectangulo":
                            rectanguloHerramienta.setSelected(true);
                            break;
                        case "elipse":
                            elipseHerramienta.setSelected(true);
                            break;
                    }
                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem abrirArchivo;
    private javax.swing.JButton abrirArchivoBoton;
    private javax.swing.JToggleButton alisadoHerramienta;
    private javax.swing.JMenu archivoMenu;
    private javax.swing.JPanel atributosPanel;
    private javax.swing.JSlider azulSlider;
    private javax.swing.JTextField azulTexto;
    private javax.swing.JToolBar barraHerramientas;
    private javax.swing.JPanel barraInferior;
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JMenuItem cambiarTamMenu;
    private javax.swing.JPanel colorPanel;
    private javax.swing.JTextField colorShow;
    private javax.swing.JToggleButton editarHerramienta;
    private javax.swing.JToggleButton elipseHerramienta;
    private javax.swing.JDesktopPane escritorioTrabajo;
    private javax.swing.JPanel grosorPanel;
    private javax.swing.JSpinner grosorSpinner;
    private javax.swing.ButtonGroup grupoHerramientas;
    private javax.swing.JMenuItem guardarArchivo;
    private javax.swing.JButton guardarArchivoBoton;
    private javax.swing.JLabel herramientaText;
    private javax.swing.JMenu imagenMenu;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToggleButton lineaHerramienta;
    private javax.swing.JLabel mousePosicionText;
    private javax.swing.JMenuItem nuevoArchivo;
    private javax.swing.JButton nuevoArchivoBoton;
    private javax.swing.JToggleButton puntoHerramienta;
    private javax.swing.JToggleButton rectanguloHerramienta;
    private javax.swing.JToggleButton rellenoHerramienta;
    private javax.swing.JSlider rojoSlider;
    private javax.swing.JTextField rojoTexto;
    private javax.swing.JToggleButton transparenciaHerramienta;
    private javax.swing.JCheckBoxMenuItem verBarraAtributos;
    private javax.swing.JCheckBoxMenuItem verBarraEstado;
    private javax.swing.JCheckBoxMenuItem verBarraFormas;
    private javax.swing.JMenu verMenu;
    private javax.swing.JSlider verdeSlider;
    private javax.swing.JTextField verdeTexto;
    // End of variables declaration//GEN-END:variables
}
