package sm.vpc.graficos;

import java.awt.Point;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

/**
 *  Clase que hereda de Geometrix para la representación de una 
 *  elipse con atributos.
 * @author Víctor Padilla
 */
public class Elipse extends Geometrix{
    /**
     * Constructor por defecto. Inicializa el objeto Shape figura
     * a un Ellipse2D.Float
     */
    public Elipse() {
        this.figura = new Ellipse2D.Float();
    }
    
    /**
     * Para documentación detallada ver: Ellipse2D.getHeight() 
     * @return La altura de la elipse en precisión doble.
     */
    
    public double getHeight(){
        return ((Ellipse2D) figura).getHeight();
    }
    
    /**
     * Para documentación detallada ver: Ellipse2D.getWidth()
     * @return La anchura de la elipse en precisión doble.
     */
   
    public double getWidth(){
        return ((Ellipse2D) figura).getWidth();
    }
    
    /**
     * Actualiza la posición de la figura a una nueva especificado por el punto dado. Calcula
     * la diferencia de distancia que hay y el nuevo punto de fin.
     * @param pos el nuevo punto de inicio de la figura.
     */
    
    public void setLocation(Point pos){ 
        double dx = pos.getX() - ((Ellipse2D) figura).getMinX();
        double dy = pos.getY() - ((Ellipse2D) figura).getMinY();

        Point2D newp2 = new Point2D.Double(((Ellipse2D) figura).getMaxX()+dx, ((Ellipse2D) figura).getMaxY()+dy);
    
        ((Ellipse2D) figura).setFrameFromDiagonal(pos, newp2);
    }    
    
    /**
     * Actualiza la posición de la figura tomando el punto dado como el punto medio nuevo de la 
     * figura resultante. Llama internamente a setLocation().
     * @param p_nuevo El nuevo punto medio de la figura
     */
    
    public void updateLocation(Point p_nuevo){
        Point aux = new Point((int) (p_nuevo.getX() - (this.getWidth()/2)), (int)(p_nuevo.getY() - (this.getHeight()/2)));

        this.setLocation((Point) aux);
    }
    
    
    /**
     * Crea una elipse circunscrita en el rectangulo formado
     * por esquinas opuestas p1 y p2.
     * Para documentación detallada ver: Ellipse2D.setFrameDiagonal() 
     * @param p1 Una esquina del rectángulo.
     * @param p2 Una esquina opuesta del rectángulo.
     */

    public void setFrameFromDiagonal(Point p1, Point p2) {
       ((Ellipse2D) figura).setFrameFromDiagonal(p1, p2);
    }
    
    /**
     * Para documentación detallada ver: Ellipse2D.getX1() 
     * @return La coordenada X de la esquina superior ixquierda 
     * del rectangulo que circunscribe a la elipse.
     */
    
     public float getX1(){
        return (float) ((Ellipse2D) figura).getMinX();
    }
    
    /**
     * Para documentación detallada ver: Ellipse2D.getY1() 
     * @return La coordenada Y de la esquina superior izquierda
     * del rectangulo que circunscribe a la elipse.
     */
    
     public float getY1(){
        return (float) ((Ellipse2D) figura).getMinY();
    }
     
    /**
     * Para documentación detallada ver: Ellipse2D.getX2() 
     * @return La coordenada X de la esquina inferior derecha
     * del rectangulo que circunscribe a la elipse.
     */
    
    public float getX2(){
        return (float) ((Ellipse2D) figura).getMaxX();
    }
    
    /**
     * Para documentación detallada ver: Ellipse2D.getX2() 
     * @return La coordenada Y de la esquina inferior derecha
     * del rectangulo que circunscribe a la elipse.
     */
    
    public float getY2(){
       return (float) ((Ellipse2D) figura).getMaxY();
    }
    
    /**
     * Para documentación detallada ver: Ellipse2D.getCenterX() 
     * @return La coordenada X del punto central de la elipse.
     */
        
    public float getMidX(){
        return (float) ((Ellipse2D) figura).getCenterX();
    }
    
    /**
     * Para documentación detallada ver: Ellipse2D.getCenterY() 
     * @return La coordenada Y del punto central de la elipse.
     */
    
    public float getMidY(){
        return (float) ((Ellipse2D) figura).getCenterY();
    }
    
}
