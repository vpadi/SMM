package sm.vpc.iu;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import sm.vpc.graficos.Cuadratica;
import sm.vpc.graficos.CustomForm;
import sm.vpc.graficos.Elipse;
import sm.vpc.graficos.Geometrix;
import sm.vpc.graficos.Linea;
import sm.vpc.graficos.Rectangulo;
import sm.vpc.graficos.Trazo;

/**
 *
 * Clase representante de un lienzo que hereda de JPanel. 
 * Básicamente es un componente gráfico que se le puede aplicar
 * una imagen y dibujar formas sobre él.
 * @author Víctor Padilla
 * @version 1.0
 */
public class Canvas extends javax.swing.JPanel {
    /**
     * Vector de Formas Geometricas. Conforme menor sea el índice
     * de la figura, más al fondo está.
     */
    protected ArrayList<Geometrix> vGeometrx = new ArrayList();
    /**
     * Rectangulo para representar la "boundingBox" de las figuras.
     */
    protected Rectangulo contorno;
    /**
     * Indica la herramienta seleccionada para crear y dibujar figuras.
     */
    
    protected String herramienta = new String();
    /**
     * Indica si se está en modo editar.
     */
    protected boolean editar = false;
    /**
     * Controla la forma seleccionada (Que se está editando o creando).
     */
    protected Geometrix currentShape;
    
    /**
     * Punto de referencia para la creación/gestión de figuras.
     */
    protected Point p_ini = new Point(), 
                  p_fin = new Point(),
                  p_control = new Point();
    /**
     * Controla el paso de secuencias "pressed-dragged-released" por el
     * que se va.
     */
    protected int paso = 0;
    
    /**
     * Color seleccionado para la creación/modificación de las figuras.
     */
    protected Color selectedFillerColor = new Color(0,0,0),
                  selectedStrokeColor = new Color(0,0,0);
    
    /**
     * Color seleccionado para la gestión del gradiente de las figuras.
     */
    protected Color selectedStartColor = new Color(0,0,0),
                  selectedEndColor = new Color(0,0,0);
    
    /**
     * Valor entero seleccionado para el grosor de las figuras.
     */
    protected int grosor;
    
    /**
     * Valor entero seleccionado para el grado de trasnparencia de las figuras.
     */
    protected int alpha;
    
    /**
     * Valor booleano que especifica si el atributo en cuestión está activado o no.
     */
    protected boolean relleno = false,
                    alisado = false,
                    degradado = false,
                    esVertical = true,
                    discontinuidad = false;
    
    /**
     * Imagen de fondo asociada al lienzo.
     */
    protected BufferedImage img = null;
    
    /**
     * Creación del lienzo con los elementos estándar. 
     */
    public Canvas() {
        initComponents();
        
        grosor = 1;
        alpha = 255;
        
        this.setBackground(Color.WHITE);
    }
    
    /**
     * Pinta en el componente gráfico todas las formas
     * creadas. Se limita al diseño especificado por la práctica más
     * la adición del cuadrado contorneante.
     * @param g Elemento gráfico que dibuja las formas y los componentes
     */
    public void paint(Graphics g){
        super.paint(g);
        
        for(Geometrix geom: vGeometrx) { //Para cada figura del vector
            geom.draw(g);
            
            if(editar && geom == currentShape)
                geom.drawEditBox(g);
        }
        
        //Dibujamos también el contorno de la figura si estamos en modo editar:
    }
    
    /**
     * Asignación de la herramienta. Existen 7: "punto", "linea", "rectangulo",
     * "cuadratica", "elipse", "area" y "trazo".
     * @param h String que indica el tipo de herramienta
     */
    public void setTool(String h) {
        herramienta = h;
        
        editar = false;
    }
    
    /**
     * Asignación del color del relleno.
     * @param c Nuevo Color del relleno.
     */
    
    public void setFillerColor(Color c){
        selectedFillerColor = c;

        if(editar && currentShape != null)
            currentShape.setFillerColor(c);
        
        this.repaint();
    }
    
    /**
     * Asignación del color del relleno. Formato por componentes.
     * @param r Nuevo valor de rojo.
     * @param g Nuevo valor de verde.
     * @param b Nuevo valor de azul.
     */
    
    public void setFillerColor(int r, int g, int b){
        selectedFillerColor = new Color(r,g,b);
        
        if(editar && currentShape != null)
            currentShape.setFillerColor(r, g, b);
    
        this.repaint();
    }
    
    /**
     * Asignación del color del trazo.
     * @param c Nuevo Color del trazo.
     */
    
    public void setStrokeColor(Color c){
        selectedStrokeColor = c;

        if(editar && currentShape != null)
            currentShape.setStrokeColor(c);
        
        this.repaint();
    }
    
    /**
     * Asignación del color del trazo. Formato por componentes.
     * @param r Nuevo valor de rojo.
     * @param g Nuevo valor de verde.
     * @param b Nuevo valor de azul.
     */
    
    public void setColor(int r, int g, int b){
        selectedStrokeColor = new Color(r,g,b);
        
        if(editar && currentShape != null)
            currentShape.setStrokeColor(r, g, b);
    
        this.repaint();
    }
    
    /**
     * Asignación del componente alfa.
     * @param trans Nuevo valor del canal alfa (transparencia).
     */
    
    public void setTransparency(int trans){
        alpha = trans;
        
        if(editar && currentShape != null)
            currentShape.setTransparency(trans);
            
        this.repaint();
    }
    
    /**
     * Método para definir y activar/desactivar el gradiente de relleno.
     * @param activar "true" si se activa, "false" de lo contrario.
     * @param frente Color de Frente del Gradiente.
     * @param fondo Color de Fondo del Gradiente.
     * @param vertical "true" si el gradiente es en el eje vertical, "false" si es en el horizontal.
     */
    
    public void setGradient(boolean activar, Color frente, Color fondo, boolean vertical){
        degradado = activar;
        selectedStartColor = frente;
        selectedEndColor = fondo;
        esVertical = vertical;
        
        if(editar && currentShape != null && degradado)
            currentShape.setGradient(frente, fondo, vertical);
        
        this.repaint();
    }
    
    /**
     * Asignación del grosor del trazo.
     * @param grs Nuevo valor del grosor del trazo.
     */
    
    public void setThickness(int grs){
        grosor = grs;
        
        if(editar && currentShape != null)
            currentShape.setThickness(grs);
        
        this.repaint();
    }
    
    /**
     * Activa o desactiva el suavizado de bordes.
     * @param al "true" si se activa, "false" si se desactiva.
     */
    
    public void setAliasing(boolean al){
        alisado = al;
        
        if(editar && currentShape != null)
            currentShape.setAliasing(al);
        
        this.repaint();
    }
    
    /**
     * Activa o desactiva el relleno de la figura
     * @param r "true" si se activa, "false" si se desactiva.
     */
    
    public void setFill(boolean r){
        relleno = r;
        
        if(editar && currentShape != null)
            currentShape.setFill(r);
        
        this.repaint();
    }
    
    /**
     * Activa o desactiva el modo Editar. 
     * @param edit "true" si se activa, "false" si se desactiva.
     */
    
    public void setEdit(boolean edit){
        editar = edit;
    }
    
    /**
     * Activa o desactiva el trazo discontinuo.
     * @param disc "true" si se activa, "false" si se desactiva.
     */
    
    public void setDiscontStroke(boolean disc){
        discontinuidad = disc;
        
        if(editar && currentShape != null)
            currentShape.setDiscontStroke(disc);
        
        this.repaint();
    }
    
    /**
     * "Getter" booleano sobre si el trazo es discontinuo
     * @return "true" si es discontinuo, "false" si trazo continuo.
     */
    
    public boolean getDiscontStroke(){
        return discontinuidad;
    }
    
    /**
     * "Getter" del tipo de herramienta.
     * @return String con el tipo de herramienta (de manera descriptiva).
     * @see setTool
     */
    
    public String getTool(){
        return herramienta;
    }
    
    /**
     * "Getter" del valor de la transparencia.
     * @return Valor entero de la transparencia (0 a 255).
     */
    
    public int getTransparency(){
        return alpha;
    }
    
    /**
     * "Getter" sobre si el relleno está activo o no.
     * @return "true" si el relleno está activo, de lo contrario "false".
     */
    
    public boolean getFill(){
        return relleno;
    }
    
    /**
     * "Getter" sobre si el modo Editar está activo o no.
     * @return "true" si el modo Editar está activo, de lo contrario "false".
     */
    
    public boolean getEdit(){
        return editar;
    }
    
    /**
     * "Getter" sobre si el alisado de bordes está activo o no.
     * @return "true" si el alisado está activo, de lo contrario "false".
     */
    
    public boolean getAliasing(){
        return alisado;
    }
    
    /**
     * "Getter" del color del contorno.
     * @return El color del contorno.
     */
    
    public Color getStrokeColor(){
        return selectedStrokeColor;
    }
    
    /**
     * "Getter" del color del relleno.
     * @return El color del relleno.
     */
    
    public Color getFillerColor(){
        return selectedFillerColor;
    }    
    
    /**
     * "Getter" del grosor del contorno.
     * @return Valor entero del grosor. 
     */
    
    public int getThickness(){
        return grosor;
    }
    
    /**
     * Dado un punto p, devuelve la figura más al frente que contenga
     * a p, si no devuelve nulo.
     * @param p Point2D con las coordenadas deseadas.
     * @return El objeto Geometrix con el índice más alto del vector de figuras 
     *         si contiene a p; null en caso contrario.
     */
    
    private Geometrix getSelectedShape(Point2D p){
        Geometrix aux = null; 
        
        for(Geometrix geom : vGeometrx)
            if(geom.contains(p))
                aux = geom;
        
        return aux;
    }
    
    /**
     * Crea una figura nueva con los valores correspondientes que tienen
     * los distintos atributos de la clase y dependiendo del valor del String
     * herramienta. Hay 7 tipos de herramientas que vienen denotados por 
     * tal String: "punto", "linea", "rectangulo", "elipse", "cuadratica",
     * "trazo" y "area". La figura nueva se asigna a currentShape.
     */
    
    private void createShape(){
        switch(herramienta){
            case "punto":
                Linea punto = new Linea(p_ini, p_ini);
                
                currentShape = (Geometrix) punto;
                
                vGeometrx.add(punto);
                
                break;
            
            case "linea":
                Linea lin = new Linea();
                                
                currentShape = lin;
                vGeometrx.add(lin);
                
                break;
            
            case "rectangulo":
                Rectangulo rect =  new Rectangulo();
                
                currentShape = rect;
                
                vGeometrx.add(rect);
                
                break;
            
            case "elipse":
                Elipse elipse = new Elipse();
                
                currentShape = elipse;
                vGeometrx.add(elipse);
                
                break;
                
            case "cuadratica":
                Cuadratica quad = new Cuadratica();
                
                currentShape = quad;
                vGeometrx.add(quad);
                
                break;
            case "trazo":
                Trazo trz = new Trazo(p_ini);
                
                currentShape = trz;
                
                vGeometrx.add(trz);
                
                break;
            case "area":
                CustomForm custom = new CustomForm();
                
                currentShape = custom;
                
                vGeometrx.add(custom);
                
                break;
        }
        
        if(currentShape != null){
            currentShape.setFillerColor(selectedFillerColor);
            currentShape.setStrokeColor(selectedStrokeColor);
            
            if(degradado)
                currentShape.setGradient(selectedStartColor, selectedEndColor, esVertical);
            
            currentShape.setThickness(grosor);
            currentShape.setFill(relleno);
            currentShape.setAliasing(alisado);
            currentShape.setTransparency(alpha);
            currentShape.setDiscontStroke(discontinuidad);
        }
    }
    
    /**
     * Actualiza la figura creada en createShape.
     * Si la figura actual (currentShape) esta creada, entonces se procede 
     * a actualizarlas correspondiendo al tipo de herramienta seleccionada y
     * a un segundo punto que delimita la figura (y otro punto de control que 
     * necesitan algunas figura). Si se está en modo Editar, entonces actualiza
     * la posición de la figura actual a una nueva posición designada por p_fin
     * llamando al metodo updateLocation de las figuras.
     */
    
    private void updateShape(){
        if(currentShape != null){
            if(editar)
                currentShape.updateLocation(p_fin);
            else{
                switch(herramienta){
                    case "linea":                
                        Linea linea = (Linea) currentShape;

                        linea.setLine(p_ini, p_fin);

                        break;

                    case "rectangulo":
                        Rectangulo rectan = (Rectangulo) currentShape;

                        rectan.setFrameFromDiagonal(p_ini, p_fin); 

                        break;

                    case "elipse":
                        Elipse elipse = (Elipse) currentShape;

                        elipse.setFrameFromDiagonal(p_ini, p_fin);

                        break;

                    case "cuadratica":
                        ((Cuadratica) currentShape).setCurve(p_ini, p_control, p_fin);

                        break;
                        
                    case "trazo":
                        ((Trazo) currentShape).addLine(p_fin);
                        
                        break;
                        
                    case "area":
                        ((CustomForm) currentShape).setForm(p_ini, p_fin);
                        
                        break;
                }
            }
        }
    }                                        
    
    /**
     * Asigna la imagen de fondo del lienzo
     * @param i la imagen de fondo
     */
    
    public void setImagen(BufferedImage i){
        this.img = i;
        
        if(img!=null) {
            this.setPreferredSize(new Dimension(img.getWidth(),img.getHeight()));
        }
    }
    
    /**
     * "Getter" de la imagen de fondo del lienzo
     * @return el atributo img de la clase
     */
    public BufferedImage getImagen(){
        return img;
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        if(img!=null) g.drawImage(img,0,0,this);
    }
    
    /**
     * "Getter" de la imagen del fondo de lienzo más todas las figuras de lienzo.
     * Básicamente convierte el lienzo en un BufferedImage si se lo especifica el 
     * párametro.
     * @param drawVector Si "true", se dibujan las figuras en la imagen que se devuelve.
     * @return BufferedImage con la imagen de fondo del lienzo más las figuras si procede.
     */

    public BufferedImage getImagen(boolean drawVector) {
        if (drawVector) {
            BufferedImage imgOut = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
            
            this.paint(imgOut.createGraphics());
            
            return imgOut;
        }
        else
            return img;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        posicionPopMenu = new javax.swing.JPopupMenu();
        enviarFondoMenu = new javax.swing.JMenuItem();
        traerFrenteMenu = new javax.swing.JMenuItem();
        enviarAtrasMenu = new javax.swing.JMenuItem();
        traerAdelanteMenu = new javax.swing.JMenuItem();

        enviarFondoMenu.setText("Enviar al Fondo");
        enviarFondoMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarFondoMenuActionPerformed(evt);
            }
        });
        posicionPopMenu.add(enviarFondoMenu);

        traerFrenteMenu.setText("Traer al Frente");
        traerFrenteMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                traerFrenteMenuActionPerformed(evt);
            }
        });
        posicionPopMenu.add(traerFrenteMenu);

        enviarAtrasMenu.setText("Enviar a Atrás");
        enviarAtrasMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarAtrasMenuActionPerformed(evt);
            }
        });
        posicionPopMenu.add(enviarAtrasMenu);

        traerAdelanteMenu.setText("Traer Adelante");
        traerAdelanteMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                traerAdelanteMenuActionPerformed(evt);
            }
        });
        posicionPopMenu.add(traerAdelanteMenu);

        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        switch(paso){
            case 0:
                p_ini = new Point(evt.getPoint());
                                
                break;
            case 1:
                p_control = new Point(evt.getPoint());
                
                break;
        }
                
        if(editar){
             currentShape = getSelectedShape(p_ini);

             if(currentShape != null)
                 super.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.MOVE_CURSOR));
        }
        else if(paso == 0)
             this.createShape();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        switch(paso){
            case 0:
                p_fin = new Point(evt.getPoint());
                p_control = p_ini;
                                
                break;
            case 1:
                p_control = new Point(evt.getPoint());
                break;
        }
        
        this.updateShape();
        
        this.repaint();
    }//GEN-LAST:event_formMouseDragged

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        if(evt.isPopupTrigger() && editar){
            currentShape = getSelectedShape(evt.getPoint());
            
            if(currentShape != null){
                posicionPopMenu.show(this, evt.getX(), evt.getY());
            }
        }
        else{
            switch(paso){
                case 0:
                    p_fin = new Point(evt.getPoint());
                    p_control = p_ini;

                    break;
                case 1:
                    p_control = new Point(evt.getPoint());
                    break;
            }


            if(herramienta.equals("cuadratica") && paso < 1) ++paso;
            else if(paso == 1) paso = 0;

            this.updateShape();

            if(editar)
                super.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.DEFAULT_CURSOR));

            this.repaint();
        }
    }//GEN-LAST:event_formMouseReleased
        
    /********************************************************************************
        Para el control de los "planos" hay que tener en cuenta que 
        El primer indice es el que se dibuja primero, ergo el que está mas al fondo 
    ********************************************************************************/

    private void enviarAtrasMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarAtrasMenuActionPerformed
        if(currentShape != null){
            int index = vGeometrx.indexOf(currentShape);
            
            if(index > 0){
                Collections.swap(vGeometrx, index, index - 1);
            }
        }
        
        this.repaint();
    }//GEN-LAST:event_enviarAtrasMenuActionPerformed

    private void enviarFondoMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarFondoMenuActionPerformed
        if(currentShape != null){
            if(vGeometrx.remove(currentShape))
                vGeometrx.add(0, currentShape);
        }
        
        this.repaint();
    }//GEN-LAST:event_enviarFondoMenuActionPerformed

    private void traerFrenteMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_traerFrenteMenuActionPerformed
        if(currentShape != null){
            if(vGeometrx.remove(currentShape))
                vGeometrx.add(currentShape);
        }
        
        this.repaint();
    }//GEN-LAST:event_traerFrenteMenuActionPerformed

    private void traerAdelanteMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_traerAdelanteMenuActionPerformed
        if(currentShape != null){
            int index = vGeometrx.indexOf(currentShape);
            
            if(index < (vGeometrx.size() - 1)){
                Collections.swap(vGeometrx, index, index + 1);                
            }
        }
        
        this.repaint();
    }//GEN-LAST:event_traerAdelanteMenuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem enviarAtrasMenu;
    private javax.swing.JMenuItem enviarFondoMenu;
    private javax.swing.JPopupMenu posicionPopMenu;
    private javax.swing.JMenuItem traerAdelanteMenu;
    private javax.swing.JMenuItem traerFrenteMenu;
    // End of variables declaration//GEN-END:variables
}
