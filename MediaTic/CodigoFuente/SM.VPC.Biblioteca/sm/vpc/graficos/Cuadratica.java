package sm.vpc.graficos;

import java.awt.Point;
import java.awt.geom.QuadCurve2D;
import java.awt.geom.Point2D;
import java.awt.geom.QuadCurve2D;
import javafx.scene.shape.QuadCurve;

/**
 * Clase que hereda de Geometrix para representar
 * una curva con un punto de control y sus atributos.
 * @author Víctor Padilla
 */
public class Cuadratica extends Geometrix {
    /**
     * Constructor por defecto. Inicializa el objeto Shape figura
     * a un QuadCurve2D.Float
     */
    public Cuadratica(){
        this.figura = new QuadCurve2D.Float();
    }    
    
    /**
     * Para documentación detallada ver: QuadCurve2D.getP1() 
     * @return El punto de inicio de la curva. 
     */
    
    public Point2D getP1(){
        return ((QuadCurve2D) figura).getP1();
    }
    
    /**
     * Para documentación detallada ver: QuadCurve2D.getP2()
     * @return El punto final de la curva.
     */
    
    public Point2D getP2(){
        return ((QuadCurve2D) figura).getP2();
    }
    
    /**
     * Para documentación detallada ver: QuadCurve2D.getCtrlPt() 
     * @return El punto de control de la curva.
     */
    
    public Point2D getControlP(){
        return ((QuadCurve2D) figura).getCtrlPt();
    }
    
    /**
     * Para documentación detallada ver: QuadCurve2D.getcontains() 
     * @return "true" si la curva contiene al punto, "false" en caso contrario.
     */
    
    public boolean contains(Point2D p) {
        return ((QuadCurve2D) figura).contains(p);
    }
    
    /**
     * Defini una nueva curva formada por el punto de inicio p1,
     * el punto final p2 y un punto de control pCont.
     * Para documentación detallada ver: QuadCurve2D.setCurve()
     * @param p1 El punto de inicio.
     * @param pCont El punto de control de la curva.
     * @param p2 El punto final de la curva.
     */
       
    public void setCurve(Point2D p1, Point2D pCont, Point2D p2){
        ((QuadCurve2D) figura).setCurve(p1, pCont, p2);
    }
    
    /**
     * Actualiza la posición de la figura a una nueva especificado por el punto dado. Calcula
     * la diferencia de distancia que hay y el nuevo punto de fin y de control.
     * @param pos el nuevo punto de inicio de la figura.
     */
    
    public void setLocation(Point2D pos){
        double dx=pos.getX() - ((QuadCurve2D) figura).getX1();
        double dy=pos.getY() - ((QuadCurve2D) figura).getY1();

        Point2D newPctrl = new Point2D.Double(((QuadCurve2D) figura).getCtrlX()+dx,((QuadCurve2D) figura).getCtrlY()+dy);
        Point2D newp2 = new Point2D.Double(((QuadCurve2D) figura).getX2()+dx,((QuadCurve2D) figura).getY2()+dy);
    
        ((QuadCurve2D) figura).setCurve(pos, newPctrl, newp2);
    }
    
    /**
     * Actualiza la posición de la figura tomando el punto dado como el punto medio nuevo de la 
     * figura resultante. Llama internamente a setLocation().
     * @param p_nuevo El nuevo punto medio de la figura
     */
    
    public void updateLocation(Point p_nuevo){
        Point2D p1 = this.getP1();
        Point2D p2 = this.getP2();
        double dx, dy;

        if(p1.getX() < p2.getX())
            dx = (p1.getX() - p2.getX()) / 2;          
        else
            dx = -(p2.getX() - p1.getX()) / 2;

        if(p1.getY() < p2.getY())
            dy = (p1.getY() - p2.getY()) / 2;          
        else
            dy = -(p2.getY() - p1.getY()) / 2;

        Point aux = new Point((int)(p_nuevo.getX() + dx), (int)(p_nuevo.getY() + dy));

        this.setLocation(aux);
    }
}
