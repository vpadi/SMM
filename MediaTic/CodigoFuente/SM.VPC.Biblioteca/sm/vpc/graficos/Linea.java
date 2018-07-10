package sm.vpc.graficos;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * Clase que hereda de Geometrix para la representación
 * de una línea con atributos.
 * @author Víctor Padilla
 */
public class Linea extends Geometrix{
    /**
     * Constructor por defecto. Inicializa el objeto Shape figura
     * a una Line2D.Float.
     */
    
    public Linea(){
        this.figura = new Line2D.Float();
    }
    
    /**
     * Constructor que inicializa el objeto Shape figura a una Line2D.Float
     * dada por 2 puntos (inicio y fin).
     * @param p1 el punto de inicio de la recta.
     * @param p2 el punto de terminación de la recta.
     */
    
    public Linea(Point p1, Point p2){
        this.figura = new Line2D.Float(p1, p2);
    }
    
    /**
     * Para documentación detallada ver: Line2D.setP1()
     * @param p El nuevo punto de inicio.
     */
    
    public void setP1(Point p){
        ((Line2D) figura).setLine(p, getP2());
    }
    
    /**
     * Para documentación detallada ver: Line2D.setP2()
     * @param p El nuevo punto final.
     */
    
    public void setP2(Point p){
        ((Line2D) figura).setLine(getP1(), p);
    }
    
    /**
     * Para documentación detallada ver: Line2D.setLine()
     * @param p1 El punto de inicio de la nueva recta.
     * @param p2 El punto final de la nueva recta.
     */
    
    public void setLine(Point p1, Point p2){
        ((Line2D) figura).setLine(p1, p2);
    }
    
    /**
     * Para documentación detallada ver: Line2D.getP1()
     * @return El punto de inicio de la recta.
     */
    
    public Point2D getP1(){
        return ((Line2D) figura).getP1();
    }
    
    /**
     * Para documentación detallada ver: Line2D.getP2()
     * @return El punto de fin de la recta.
     */
    
    public Point2D getP2(){
        return ((Line2D) figura).getP2();
    }
    
    /**
     * Método para comprobar si un punto p está relativamente cerca de una 
     * recta. Internamente usa el distance() de Point si el punto de inicio
     * y fin es el mismo o ptLineDist si es distinto. Si es menor o igual 
     * que 3.0 se considera que está cercano.
     * @param p Punto con las coordenadas a comprobar si esta cercano.
     * @return "true" si la distancia es menor o igual que 3.0D, "false" en caso contrario.
     */
    
    public boolean isNear(Point2D p){
        if (((Line2D) figura).getP1().equals(((Line2D) figura).getP2()))
            return ((Line2D) figura).getP1().distance(p) <= 3.0D;
        else 
            return ((Line2D) figura).ptLineDist(p) <= 3.0D;
    }
    
    /**
     * Método para saber si la figura "contiene" a un punto p.
     * Internamente llama al método isNear().
     * @param p Punto con las coordenadas a comprobar.
     * @return "true" si lo "contiene", "false" de lo contrario.
     */
    
    public boolean contains(Point2D p) {
        return isNear(p);
    }
       
    /**
     * Método para actualizar la posición de la recta a una dada por uno nuevo punto "pos".
     * Se calcula las diferencias de distancia y se actualizan al punto final.
     * @param pos El nuevo punto de inicio.
     */
    public void setLocation(Point2D pos){
        double dx=pos.getX() - ((Line2D) figura).getX1();
        double dy=pos.getY() - ((Line2D) figura).getY1();

        Point2D newp2 = new Point2D.Double(((Line2D) figura).getX2()+dx,((Line2D) figura).getY2()+dy);
    
        ((Line2D) figura).setLine(pos,newp2);
    }
    
    /**
     * Actualiza la posición de la recta a una nueva dada tomando el punto dado como
     * el punto medio de la recta. Llama internamente al método setLocation().
     * @param p_nuevo el nuevo punto medio de la recta.
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
    
    /**
     * Para documentación detallada ver: Line2D.getX1()
     * @return La Coordenada X del punto de inicio.
     */
    
    public float getX1(){
        return (float) ((Line2D) figura).getX1();
    }
    
    /**
     * Para documentación detallada ver: Line2D.getY1()
     * @return La coordenada Y del punto de inicio.
     */
    
    public float getY1(){
        return (float) ((Line2D) figura).getY1();
    }
    
    /**
     * Para documentación detallada ver: Line2D.getX2()
     * @return la coordenada X del punto final.
     */
    
    public float getX2(){
        return (float) ((Line2D) figura).getX2();
    }
    
    /**
     * Para documentación detallada ver: Line2D.getY2()
     * @return La coordenada Y del punto final.
     */
    
    public float getY2(){
       return (float) ((Line2D) figura).getY2();
    }
    
    /**
     * Devuelve la coordenada X del punto medio de la recta.
     * @return La coordenada X en punto flotante de la recta.
     */
    
    public float getMidX(){
        return (this.getX1() + this.getX2()) / 2;
    }
    
    /**
     * Devuelve la coordenada Y del punto medio de la recta.
     * @return La coordenada Y en punto flotante de la recta.
     */
    
    public float getMidY(){
        return (this.getY1() + this.getY2()) / 2;
    }
    
}
