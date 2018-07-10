package mediatic;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Vector;
import javax.swing.JComboBox;
import sm.vpc.iu.ListCeldaColor;

/**
 * Clase que representa un dialogo para seleccionar un gradiente 
 * que luego será usado para pintar figuras.
 * @author Víctor Padilla
 */
public class DegradadoDialog extends javax.swing.JDialog {
    private final Vector<Color> listaColores = new Vector();    
    private Color frente = new Color(0,0,0),
                  fondo = new Color(255,255,255);
    /**
     * Creates new form DegradadoDialog
     */
    public DegradadoDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        /* Añadimos los colores disponibles para la selección */
        this.listaColores.add(Color.BLACK); this.listaColores.add(Color.BLUE); this.listaColores.add(Color.RED);
        this.listaColores.add(Color.YELLOW); this.listaColores.add(Color.WHITE); this.listaColores.add(Color.ORANGE);
        this.listaColores.add(Color.GREEN); this.listaColores.add(Color.PINK);
        
        initComponents();
        
        this.setTitle("Selector de Degradado");
        
        colorCBFondo.setSelectedIndex(4);
    }
    
    public void paint(Graphics g){
        super.paint(g);
        
        Graphics2D g2d = (Graphics2D) g;
        
        GradientPaint paint;
        
        if(verticalTick.isSelected())
            paint = new GradientPaint(85, 100, frente, 85, 230, fondo, false);
        else
            paint = new GradientPaint(50, 130, frente, 150, 130, fondo, false);

        g2d.setPaint(paint);
        
        g2d.fillRect(50, 100, 120, 160);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        orientacionGrupo = new javax.swing.ButtonGroup();
        frenteLabel = new javax.swing.JLabel();
        fondoLabel = new javax.swing.JLabel();
        aceptarBoton = new javax.swing.JButton();
        cancelarBoton = new javax.swing.JButton();
        verticalTick = new javax.swing.JRadioButton();
        horizontalTick = new javax.swing.JRadioButton();
        colorCBFrente = new JComboBox(listaColores);
        colorCBFrente.setRenderer(new ListCeldaColor());
        colorCBFondo = new JComboBox(listaColores);
        colorCBFondo.setRenderer(new ListCeldaColor());

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        frenteLabel.setText("Color de Frente");

        fondoLabel.setText("Color de Fondo");

        aceptarBoton.setText("Aceptar");
        aceptarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarBotonActionPerformed(evt);
            }
        });

        cancelarBoton.setText("Cancelar");
        cancelarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBotonActionPerformed(evt);
            }
        });

        orientacionGrupo.add(verticalTick);
        verticalTick.setSelected(true);
        verticalTick.setText("Vertical");
        verticalTick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verticalTickActionPerformed(evt);
            }
        });

        orientacionGrupo.add(horizontalTick);
        horizontalTick.setText("Horizontal");
        horizontalTick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horizontalTickActionPerformed(evt);
            }
        });

        colorCBFrente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorCBFrenteActionPerformed(evt);
            }
        });

        colorCBFondo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorCBFondoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fondoLabel)
                            .addComponent(frenteLabel))
                        .addGap(59, 59, 59))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(colorCBFrente, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(colorCBFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76))))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(verticalTick)
                .addGap(18, 18, 18)
                .addComponent(horizontalTick)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(aceptarBoton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelarBoton))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(frenteLabel)
                .addGap(18, 18, 18)
                .addComponent(colorCBFrente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(fondoLabel)
                .addGap(18, 18, 18)
                .addComponent(colorCBFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptarBoton)
                    .addComponent(cancelarBoton)
                    .addComponent(verticalTick)
                    .addComponent(horizontalTick))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarBotonActionPerformed
        ((VentanaPrincipal)this.getParent()).activarDegradado(frente, fondo, verticalTick.isSelected());
        
        this.dispose();
    }//GEN-LAST:event_aceptarBotonActionPerformed

    private void cancelarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBotonActionPerformed
        ((VentanaPrincipal)this.getParent()).desactivarDegradado();

        this.dispose();
    }//GEN-LAST:event_cancelarBotonActionPerformed

    private void verticalTickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verticalTickActionPerformed
        this.repaint();
    }//GEN-LAST:event_verticalTickActionPerformed

    private void horizontalTickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horizontalTickActionPerformed
        this.repaint();
    }//GEN-LAST:event_horizontalTickActionPerformed

    private void colorCBFondoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorCBFondoActionPerformed
        fondo = (Color) colorCBFondo.getSelectedItem();
        
        this.repaint();
    }//GEN-LAST:event_colorCBFondoActionPerformed

    private void colorCBFrenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorCBFrenteActionPerformed
        frente = (Color) colorCBFrente.getSelectedItem();
        
        this.repaint();
    }//GEN-LAST:event_colorCBFrenteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarBoton;
    private javax.swing.JButton cancelarBoton;
    private javax.swing.JComboBox<String> colorCBFondo;
    private javax.swing.JComboBox<String> colorCBFrente;
    private javax.swing.JLabel fondoLabel;
    private javax.swing.JLabel frenteLabel;
    private javax.swing.JRadioButton horizontalTick;
    private javax.swing.ButtonGroup orientacionGrupo;
    private javax.swing.JRadioButton verticalTick;
    // End of variables declaration//GEN-END:variables
}