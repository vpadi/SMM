/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

/**
 *
 * @author gh-ro
 */
public class MainWindow extends javax.swing.JFrame {

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
        
        showColor.setBackground(new Color(Red.getValue(),Green.getValue(),Blue.getValue()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        herramientas = new javax.swing.ButtonGroup();
        lienzo = new paint.Lienzo();
        jPanel1 = new javax.swing.JPanel();
        barraHerramientas = new javax.swing.JToolBar();
        punto = new javax.swing.JToggleButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        recta = new javax.swing.JToggleButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        ovalo = new javax.swing.JToggleButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        rectangulo = new javax.swing.JToggleButton();
        jPanel2 = new javax.swing.JPanel();
        nuevoBoceto = new javax.swing.JButton();
        guardarBoceto = new javax.swing.JButton();
        barraEstadoBoton = new javax.swing.JButton();
        colorPanel = new javax.swing.JPanel();
        relleno = new javax.swing.JCheckBox();
        Red = new javax.swing.JSlider();
        Green = new javax.swing.JSlider();
        Blue = new javax.swing.JSlider();
        redLabel = new javax.swing.JLabel();
        greenLabel = new javax.swing.JLabel();
        blueLabel = new javax.swing.JLabel();
        herramientaLabel = new javax.swing.JLabel();
        showColor = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Paint");

        lienzo.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout lienzoLayout = new javax.swing.GroupLayout(lienzo);
        lienzo.setLayout(lienzoLayout);
        lienzoLayout.setHorizontalGroup(
            lienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        lienzoLayout.setVerticalGroup(
            lienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        barraHerramientas.setRollover(true);

        herramientas.add(punto);
        punto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Lapiz.gif"))); // NOI18N
        punto.setFocusable(false);
        punto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        punto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        punto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                puntoActionPerformed(evt);
            }
        });
        barraHerramientas.add(punto);
        barraHerramientas.add(jSeparator1);

        herramientas.add(recta);
        recta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Linea.gif"))); // NOI18N
        recta.setFocusable(false);
        recta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        recta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        recta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rectaActionPerformed(evt);
            }
        });
        barraHerramientas.add(recta);
        barraHerramientas.add(jSeparator2);

        herramientas.add(ovalo);
        ovalo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Ovalo.gif"))); // NOI18N
        ovalo.setFocusable(false);
        ovalo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ovalo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ovalo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ovaloActionPerformed(evt);
            }
        });
        barraHerramientas.add(ovalo);
        barraHerramientas.add(jSeparator3);

        herramientas.add(rectangulo);
        rectangulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Rectangulo.gif"))); // NOI18N
        rectangulo.setFocusable(false);
        rectangulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        rectangulo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        rectangulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rectanguloActionPerformed(evt);
            }
        });
        barraHerramientas.add(rectangulo);

        nuevoBoceto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/NuevoBoceto.GIF"))); // NOI18N
        nuevoBoceto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoBocetoActionPerformed(evt);
            }
        });

        guardarBoceto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Guardar.gif"))); // NOI18N
        guardarBoceto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarBocetoActionPerformed(evt);
            }
        });

        barraEstadoBoton.setText("Ocultar Barra de Estado");
        barraEstadoBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barraEstadoBotonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nuevoBoceto, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(guardarBoceto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(barraEstadoBoton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nuevoBoceto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(barraEstadoBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(guardarBoceto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(barraHerramientas, javax.swing.GroupLayout.DEFAULT_SIZE, 1299, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(barraHerramientas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        colorPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        relleno.setText("Relleno");
        relleno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rellenoActionPerformed(evt);
            }
        });

        Red.setBackground(new java.awt.Color(153, 0, 0));
        Red.setMaximum(255);
        Red.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                RedStateChanged(evt);
            }
        });

        Green.setBackground(new java.awt.Color(0, 102, 0));
        Green.setMaximum(255);
        Green.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                GreenStateChanged(evt);
            }
        });

        Blue.setBackground(new java.awt.Color(0, 51, 102));
        Blue.setForeground(new java.awt.Color(0, 102, 153));
        Blue.setMaximum(255);
        Blue.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                BlueStateChanged(evt);
            }
        });

        redLabel.setText("R");

        greenLabel.setText("G");

        blueLabel.setText("B");

        herramientaLabel.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        herramientaLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        showColor.setEditable(false);
        showColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showColorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout colorPanelLayout = new javax.swing.GroupLayout(colorPanel);
        colorPanel.setLayout(colorPanelLayout);
        colorPanelLayout.setHorizontalGroup(
            colorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(colorPanelLayout.createSequentialGroup()
                .addGroup(colorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(colorPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(colorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(colorPanelLayout.createSequentialGroup()
                                .addGroup(colorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(redLabel)
                                    .addComponent(greenLabel)
                                    .addComponent(blueLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(colorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Red, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Green, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Blue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(colorPanelLayout.createSequentialGroup()
                                .addComponent(herramientaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(relleno))))
                    .addGroup(colorPanelLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(showColor, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        colorPanelLayout.setVerticalGroup(
            colorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(colorPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(colorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(redLabel)
                    .addComponent(Red, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(colorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Green, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(greenLabel))
                .addGap(18, 18, 18)
                .addGroup(colorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Blue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(blueLabel))
                .addGap(18, 18, 18)
                .addComponent(showColor, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 416, Short.MAX_VALUE)
                .addGroup(colorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(herramientaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(relleno))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(colorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lienzo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(colorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lienzo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void puntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_puntoActionPerformed
        lienzo.setHerramienta("punto");
        
        herramientaLabel.setText("Punto");
    }//GEN-LAST:event_puntoActionPerformed

    private void rectaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rectaActionPerformed
        lienzo.setHerramienta("recta");
        
        herramientaLabel.setText("Recta");
    }//GEN-LAST:event_rectaActionPerformed

    private void ovaloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ovaloActionPerformed
        lienzo.setHerramienta("ovalo");
        
        herramientaLabel.setText("Elipse");
    }//GEN-LAST:event_ovaloActionPerformed

    private void rectanguloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rectanguloActionPerformed
        lienzo.setHerramienta("rectangulo");
        
        herramientaLabel.setText("Rectángulo");
    }//GEN-LAST:event_rectanguloActionPerformed

    private void rellenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rellenoActionPerformed
        lienzo.setRelleno(relleno.isSelected());
    }//GEN-LAST:event_rellenoActionPerformed

    private void RedStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_RedStateChanged
        lienzo.setColor(new Color(Red.getValue(),Green.getValue(),Blue.getValue()));
        
        showColor.setBackground(new Color(Red.getValue(),Green.getValue(),Blue.getValue()));
    }//GEN-LAST:event_RedStateChanged

    private void GreenStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_GreenStateChanged
        lienzo.setColor(new Color(Red.getValue(),Green.getValue(),Blue.getValue()));

        showColor.setBackground(new Color(Red.getValue(),Green.getValue(),Blue.getValue()));
    }//GEN-LAST:event_GreenStateChanged

    private void BlueStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_BlueStateChanged
        lienzo.setColor(new Color(Red.getValue(),Green.getValue(),Blue.getValue()));
        
        showColor.setBackground(new Color(Red.getValue(),Green.getValue(),Blue.getValue()));
    }//GEN-LAST:event_BlueStateChanged

    private void nuevoBocetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoBocetoActionPerformed
        lienzo.limpiar();
    }//GEN-LAST:event_nuevoBocetoActionPerformed

    private void guardarBocetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarBocetoActionPerformed
        BufferedImage image = new BufferedImage(lienzo.getWidth(), lienzo.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = image.createGraphics(); 

        lienzo.paint(graphics2D);
        
        JFileChooser dlg = new JFileChooser();
            
        int resp = dlg.showSaveDialog(this);
        
        if( resp == JFileChooser.APPROVE_OPTION) {
            File f = dlg.getSelectedFile();
         
            try{
                ImageIO.write(image,"png", f);
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_guardarBocetoActionPerformed

    private void showColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showColorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_showColorActionPerformed

    private void barraEstadoBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barraEstadoBotonActionPerformed
        if(barraEstadoBoton.getText().equals("Ocultar Barra de Estado")){
            barraEstadoBoton.setText("Mostrar Barra de Estado");
            herramientaLabel.setVisible(false);
        }
        else{
            barraEstadoBoton.setText("Ocultar Barra de Estado");
            herramientaLabel.setVisible(true);
        }
    }//GEN-LAST:event_barraEstadoBotonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSlider Blue;
    private javax.swing.JSlider Green;
    private javax.swing.JSlider Red;
    private javax.swing.JButton barraEstadoBoton;
    private javax.swing.JToolBar barraHerramientas;
    private javax.swing.JLabel blueLabel;
    private javax.swing.JPanel colorPanel;
    private javax.swing.JLabel greenLabel;
    private javax.swing.JButton guardarBoceto;
    private javax.swing.JLabel herramientaLabel;
    private javax.swing.ButtonGroup herramientas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private paint.Lienzo lienzo;
    private javax.swing.JButton nuevoBoceto;
    private javax.swing.JToggleButton ovalo;
    private javax.swing.JToggleButton punto;
    private javax.swing.JToggleButton recta;
    private javax.swing.JToggleButton rectangulo;
    private javax.swing.JLabel redLabel;
    private javax.swing.JCheckBox relleno;
    private javax.swing.JTextField showColor;
    // End of variables declaration//GEN-END:variables
}
