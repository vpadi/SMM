package sm.vpc.graficos;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Point2D;

/**
 * Clase que hereda de Geometrix para la representación de
 * un rectángulo.
 * @author Víctor Padilla
 */
public class Rectangulo extends Geometrix {
    
    /**
     * Constructor por defecto. Inicializa el objeto Shape figura
     * a un Rectangle.
     */

    public Rectangulo() {
        this.figura  = new Rectangle();
    }
    
    /**
     * Crea un rectangulo donde con esquinas opuestas p1 y p2.
     * Para documentación detallada ver: Rectangle.setFrameFromDiagonal()
     * @param p1 Una esquina del rectangulo.
     * @param p2 La esquina opuesta del rectangulo.
     */
    
    public void setFrameFromDiagonal(Point p1, Point p2){
       ((Rectangle) figura).setFrameFromDiagonal(p1, p2);
    }
    
    /**
     * Para documentación detallada ver: Rectangle.getHeight()
     * @return La altura del rectángulo en precisión doble.
     */
    
    public double getHeight(){
        return ((Rectangle) figura).getHeight();
    }
    
    /**
     * Para documentación detallada ver: Rectangle.getWidth()
     * @return La anchura del rectángulo en precisión doble.
     */
    
    public double getWidth(){
        return ((Rectangle) figura).getWidth();
    }
    
    /**
     * Para documentación detallada ver: Rectangle.setLocation()
     * Actualiza la posición del rectángulo para que la esquina
     * superior izquierda empiece en p. Misma altura y anchura.
     * @param p Nueva esquina superior izquierda del rectángulo.
     */
    
    public void setLocation(Point p){
        ((Rectangle) figura).setLocation(p);
    }
    
    /**
     * Actualiza la posición del rectángulo tomando el punto dado como el
     * nuevo punto central. Llama internamente a setLocation().
     * @param p_nuevo el punto central del la nueva posición de la figura.
     */
    
    public void updateLocation(Point p_nuevo){
        Point aux = new Point((int) (p_nuevo.getX() - (this.getWidth()/2)), (int)(p_nuevo.getY() - (this.getHeight()/2)));

        this.setLocation(aux);
    }
    
    /**
     * Para documentación detallada ver: Rectangle.getX1()
     * @return La coordenada X del la esquina superior izquierda.
     */
    
    public float getX1(){
        return (float) ((Rectangle) figura).getMinX();
    }
    
    /**
     * Para documentación detallada ver: Rectangle.getY1()
     * @return La coordenada Y del la esquina superior izquierda.
     */
    
    public float getY1(){
        return (float) ((Rectangle) figura).getMinY();
    }
    
    /**
     * Para documentación detallada ver: Rectangle.getX2()
     * @return La coordenada X de la esquina inferior derecha.
     */
    
    public float getX2(){
        return (float) ((Rectangle) figura).getMaxX();
    }
    
    /**
     * Para documentación detallada ver: Rectangle.getY2()
     * @return La coordenada Y de la esquina inferior derecha.
     */
    
    public float getY2(){
       return (float) ((Rectangle) figura).getMaxY();
    }
    
    /**
     * Para documentación detallada ver: Rectangle.getCenterX()
     * @return La coordenada X del punto central del rectángulo.
     */
        
    public float getMidX(){
        return (float) ((Rectangle) figura).getCenterX();
    }
    
    /**
     * Para documentación detallada ver: Rectangle.getCenterY()
     * @return La coordenada Y del punto central del rectángulo.
     */
    
    public float getMidY(){
        return (float) ((Rectangle) figura).getCenterY();
    }
}
