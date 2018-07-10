package mediatic;

import java.awt.Dimension;
import sm.vpc.iu.Canvas;

/**
 * Clase que hereda de VentanaInterna para obtener un lienzo 
 * donde dibujar figuras y mostrar una imagen a la que se pueda 
 * aplicar filtros, en un JInternalFrame.
 * @author Víctor Padilla
 */
public class VentanaInternaImagen extends VentanaInterna {    
    public VentanaInternaImagen(VentanaPrincipal p){
        super(p);
        
        initComponents();
    }
    
    public VentanaInternaImagen(VentanaPrincipal p, int w, int h) {
        super(p);
        
        initComponents();
                
        this.setSize(new Dimension(w + 40, h + 50));


        lienzo.setPreferredSize(new Dimension(w, h));
    }
    
    public Canvas getLienzo(){
        return lienzo;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelScroll = new javax.swing.JScrollPane();
        panelFijo = new javax.swing.JPanel();
        lienzo = new sm.vpc.iu.Canvas();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        panelFijo.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        lienzo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lienzoMouseMoved(evt);
            }
        });

        javax.swing.GroupLayout lienzoLayout = new javax.swing.GroupLayout(lienzo);
        lienzo.setLayout(lienzoLayout);
        lienzoLayout.setHorizontalGroup(
            lienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        lienzoLayout.setVerticalGroup(
            lienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        panelFijo.add(lienzo);

        panelScroll.setViewportView(panelFijo);

        getContentPane().add(panelScroll, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lienzoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lienzoMouseMoved
        int[] px = null;
                
        if((evt.getX() < this.lienzo.getImagen().getWidth()) && (evt.getY() < this.lienzo.getImagen().getHeight()) ) {
            px = this.lienzo.getImagen().getRaster().getPixel(evt.getX(), evt.getY(), px);
                        
            switch (px.length) {
                case 4:
                    this.parent.setPosicionText("( X: " + evt.getX() + ", Y: " + evt.getY() + ") = [ " + px[0] + ", " + px[1] + ", " + px[2] + ", " + px[3] + " ]");
                    break;
                case 3:
                    this.parent.setPosicionText("( X: " + evt.getX() + ", Y: " + evt.getY() + ") = [ " + px[0] + ", " + px[1] + ", " + px[2] + " ]");
                    break;
                case 1:
                    this.parent.setPosicionText("( X: " + evt.getX() + ", Y: " + evt.getY() + ") = [ " + px[0] + " ]");
                    break;
            }            
        }
    }//GEN-LAST:event_lienzoMouseMoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private sm.vpc.iu.Canvas lienzo;
    private javax.swing.JPanel panelFijo;
    private javax.swing.JScrollPane panelScroll;
    // End of variables declaration//GEN-END:variables
}
