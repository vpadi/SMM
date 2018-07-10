/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediatic;

/**
 * Dialogo para la selección del tamaño de un nuevo lienzo (Canvas).
 * @author Víctor Padilla
 */
public class VentanaDimensionImagen extends javax.swing.JDialog {

    /**
     * Creates new form ventanaDimensionImagen
     */
    public VentanaDimensionImagen(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public int getAlto(){
        return Integer.parseInt(alturaTam.getText());
    }
    
    public int getAncho(){
        return Integer.parseInt(anchuraTam.getText());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aceptBoton = new javax.swing.JButton();
        alturaLabel = new javax.swing.JLabel();
        anchoLabel = new javax.swing.JLabel();
        alturaTam = new javax.swing.JTextField();
        anchuraTam = new javax.swing.JTextField();
        pixelLabel = new javax.swing.JLabel();
        pixelLabel2 = new javax.swing.JLabel();
        imagenLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cambiar tamaño de la imágen");

        aceptBoton.setText("Ok");
        aceptBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptBotonActionPerformed(evt);
            }
        });

        alturaLabel.setText("Altura :");

        anchoLabel.setText("Anchura :");

        alturaTam.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        alturaTam.setText("300");

        anchuraTam.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        anchuraTam.setText("300");

        pixelLabel.setText("px");

        pixelLabel2.setText("px");

        imagenLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/ventana-dimension.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(aceptBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(imagenLabel)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(alturaLabel)
                            .addComponent(anchoLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(anchuraTam, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pixelLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(alturaTam, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pixelLabel)))
                        .addGap(17, 17, 17))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(alturaLabel)
                            .addComponent(alturaTam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pixelLabel))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(anchuraTam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(anchoLabel)
                            .addComponent(pixelLabel2)))
                    .addComponent(imagenLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(aceptBoton)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aceptBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptBotonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_aceptBotonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptBoton;
    private javax.swing.JLabel alturaLabel;
    private javax.swing.JTextField alturaTam;
    private javax.swing.JLabel anchoLabel;
    private javax.swing.JTextField anchuraTam;
    private javax.swing.JLabel imagenLabel;
    private javax.swing.JLabel pixelLabel;
    private javax.swing.JLabel pixelLabel2;
    // End of variables declaration//GEN-END:variables
}
