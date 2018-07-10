package sm.vpc.graficos;

import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;

/**
  * Clase que hereda de Geometrix para la representación de
 *  un trazo libre con sus propios atributos.
 * @author Víctor Padilla
 */
public class Trazo extends Geometrix {    
    /**
     * Constructor que inicializa el objeto Shape figura a un
     * GeneralPath y le asigna el punto dado como el punto de inicio.
     * @param p El punto de inicio del GeneralPath.
     */
    public Trazo(Point p){        
        this.figura = new GeneralPath();
    
        addPoint(p);
    }
    
    /**
     * Para documentación detallada ver: GeneralPath.lineTo()
     * @param p Punto final de la nueva línea.
     */
    
    public void addLine(Point p){
        ((GeneralPath) figura).lineTo(p.getX(), p.getY());
    }
    
    /**
     * Para documentación detallada ver: GeneralPath.lineTo()
     *
     * @param x Coordenada X en punto flotante del punto final de la nueva linea.
     * @param y Coordenada Y en punto flotante del punto final de la nueva linea.
     */
    
    public void addLine(float x, float y){
        ((GeneralPath) figura).lineTo(x, y);
    }
    
    /**
     * Para documentación detallada ver: GeneralPath.moveTo()
     * 
     * @param x Coordenada X del nuevo punto en el recorrido.
     * @param y Coordenada Y del nuevo punto en el recorrido.
     */
    
    public void addPoint(float x, float y){
        ((GeneralPath) figura).moveTo(x, y);
    }
    
    /**
     * Para documentación detallada ver: GeneralPath.moveTo()
     * @param p Nuevo punto en el recorrido.
     */
    
    public void addPoint(Point p){
        ((GeneralPath) figura).moveTo(p.getX(), p.getY());
    }
    
    /**
     * Actualiza la posición de una figura tomando como referencia la boundingBox de la
     * figura y un punto que será el nuevo origen de la figura. Calcula la diferencia 
     * de distancia que hay entre las coordenadas y le aplica una AffineTransform del tipo
     * Translation a la figura.
     * @param p El nuevo punto de origen de la figura. A donde se va a mover.
     */

    @Override
    public void updateLocation(Point p) {        
        double tx = p.getX()-figura.getBounds().getCenterX();
        double ty = p.getY()-figura.getBounds().getCenterY();

        AffineTransform at = AffineTransform.getTranslateInstance(tx ,ty);
        
        ((GeneralPath) figura).transform(at);
    }
    
}
