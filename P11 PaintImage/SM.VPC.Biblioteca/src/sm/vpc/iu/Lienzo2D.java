/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.vpc.iu;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import sm.vpc.graficos.Elipse2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import sm.vpc.graficos.Linea2D;
import java.awt.Rectangle;

/**
 *
 * @author gh-ro
 */
public class Lienzo2D extends javax.swing.JPanel {
    // Vector de formas 
    protected ArrayList<Shape> vShape = new ArrayList();
    //Declaracion de los atributos para pintar
    private Color color = new Color(0,0,0);
    private BasicStroke stroke = new BasicStroke();
    private String herramienta = new String();
    private boolean relleno = false,
                    alisado = false,
                    editar = false,
                    tranparencia = false;
    private Shape currentShape;
    private Point p_ini = new Point(), 
                  p_fin = new Point();
    private RenderingHints render;
    
    public void paint(Graphics g){
        super.paint(g);
        
        Graphics2D g2d = (Graphics2D)g;
        
        g2d.setPaint(color);
        g2d.setStroke(stroke);
        
        if(alisado)
            g2d.setRenderingHints(render);
        
        for(Shape s : vShape) {
            if(relleno) g2d.fill(s);
            
            g2d.draw(s);
        }
    }
    
    /**
     * Creates new form Lienzo2D
     */
    public Lienzo2D() {
        initComponents();
        
        this.setBackground(Color.WHITE);
    }
    
    public void setHerramienta(String h) {
        herramienta = new String(h);
        
        editar = false;
    }
    
    public void setColor(Color c){
        if(tranparencia)
            color = new Color(c.getRed(),c.getGreen(),c.getBlue(), 128);
        else
            color = new Color(c.getRed(),c.getGreen(),c.getBlue());
        
        this.repaint();
    }
    
    public void setColor(int r, int g, int b){
        if(tranparencia)
            color = new Color(r,g,b,127);
        else
            color = new Color(r,g,b,255);

        this.repaint();
    }
    
    public void setTransparencia(boolean trans){
        tranparencia = trans;
        
        this.setColor(color.getRed(), color.getGreen(), color.getBlue());
        
        this.repaint();
    }
    
    public void setGrosor(int grs){
        stroke = new BasicStroke((float) grs);
        
        this.repaint();
    }
    
    public void setAlisado(boolean al){
        render = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        alisado = al;
        
        this.repaint();
    }
    
    public void setRelleno(boolean r){
        relleno = r;
        
        this.repaint();
    }
    
    public void setEditar(boolean ed){
        editar = ed;
    }
    
    public String getHerramienta(){
        return herramienta;
    }
    
    public boolean getTransparencia(){
        return tranparencia;
    }
    
    public boolean getRelleno(){
        return relleno;
    }
    
    public boolean getEditar(){
        return editar;
    }
    
    public boolean getAlisar(){
        return alisado;
    }
    
    public Color getColor(){
        return color;
    }
    
    public int getGrosor(){
        return (int) stroke.getLineWidth();
    }
    
    private Shape getSelectedShape(Point2D p){
        for(Shape s:vShape)
            if(s.contains(p)) return s;
        
        return null;
    }
    
    private void createShape(){
        switch(herramienta){
            case "punto":
                Linea2D punto = new Linea2D(p_ini, p_ini);
                
                currentShape = (Shape) punto;
                
                vShape.add(punto);
                
                break;
            
            case "linea":
                Linea2D linea = new Linea2D();
                                
                currentShape = linea;
                vShape.add(linea);
                
                break;
            
            case "rectangulo":
                Rectangle rect =  new Rectangle();
                
                currentShape = rect;
                
                vShape.add(rect);
                
                break;
            
            case "elipse":
                Elipse2D elipse = new Elipse2D();
                
                currentShape = elipse;
                vShape.add(elipse);
                
                break;
        }
    }
    
    private void updateShape(){
        if(editar)
            setNuevaLocation();
        else{
            switch(herramienta){
                case "linea":                
                    Linea2D linea = (Linea2D) currentShape;

                    linea.setLine(p_ini, p_fin);

                    break;

                case "rectangulo":
                    Rectangle rectan = (Rectangle) currentShape;

                    rectan.setFrameFromDiagonal(p_ini, p_fin); 

                    break;

                case "elipse":
                    Elipse2D elipse = (Elipse2D) currentShape;

                    elipse.setFrameFromDiagonal(p_ini, p_fin);

                    break;
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        p_ini = new Point(evt.getPoint());
        
        if(editar){
            currentShape = getSelectedShape(p_ini);
        
            if(currentShape != null)
                super.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.MOVE_CURSOR));
        }
        else
            this.createShape();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        p_fin = new Point(evt.getPoint());
        
        this.updateShape();
        
        this.repaint();
    }//GEN-LAST:event_formMouseDragged

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        p_fin = new Point(evt.getPoint());
        
        this.updateShape();
        
        if(editar)
            super.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.DEFAULT_CURSOR));
        
        this.repaint();
    }//GEN-LAST:event_formMouseReleased

    private void setNuevaLocation() {
        Point aux = new Point();
               
        if(currentShape != null){
            if(currentShape instanceof Linea2D){
                Linea2D lin = (Linea2D) currentShape;

                Point2D p1 = lin.getP1();
                Point2D p2 = lin.getP2();
                double dx, dy;

                if(p1.getX() < p2.getX())
                    dx = (p1.getX() - p2.getX()) / 2;          
                else
                    dx = -(p2.getX() - p1.getX()) / 2;

                if(p1.getY() < p2.getY())
                    dy = (p1.getY() - p2.getY()) / 2;          
                else
                    dy = -(p2.getY() - p1.getY()) / 2;


                aux.setLocation(p_fin.getX() + dx, p_fin.getY() + dy);

                lin.setLocation(aux);

            }
            else if(currentShape instanceof Rectangle){
                Rectangle rect = (Rectangle) currentShape;

                aux.setLocation(p_fin.getX() - (rect.getWidth()/2), p_fin.getY() - (rect.getHeight()/2));

                rect.setLocation((Point) aux);

            }
            else if(currentShape instanceof Elipse2D){
                Elipse2D elip = (Elipse2D) currentShape;

                aux.setLocation(p_fin.getX() - (elip.getWidth()/2), p_fin.getY() - (elip.getHeight()/2));

                elip.setLocation(aux);
            }
        }
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
