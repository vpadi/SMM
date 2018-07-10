package sm.vpc.graficos;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import javafx.scene.shape.Ellipse;

/**
 * Clase que hereda de Geometrix para la representación de
 * una figura personalizada (Area) con sus propios atributos.
 * @author Víctor Padilla
 */
public class CustomForm extends Geometrix {
    /**
     * Constructor por defecto. Inicializa el objeto Shape figura
     * a una nueva Area.
     */
    public CustomForm() {
        figura = new Area();
    }
    
    /**
     * Crea una Area nueva a partir de dos puntos que delimitan el marco y se la asigna a figura. 
     * Esta Area estará formada por un Rectangle y dos Ellipse2D que vienen
     * dados por esos puntos. La figura resultante es la de una especie de dos
     * columnas/con una forma de lente convexa en el medio.
     * @param p1 Punto delimitante de esquina opuesta.
     * @param p2 Segundo punto delimitante de esquina opuesta.
     */
    
    public void setForm(Point p1, Point p2){
        Rectangle rect = new Rectangle();
        rect.setFrameFromDiagonal(p1, p2);
        
        Area rectArea = new Area(rect);
        
        Ellipse2D elip = new Ellipse2D.Float();
        
        elip.setFrameFromCenter(new Point((int) rect.getCenterX(), (int) rect.getMinY()), new Point((int) rect.getMinX(), (int) rect.getMaxY()));
        
        Area eliArea1 = new Area(elip);

        elip.setFrameFromCenter(new Point((int) rect.getCenterX(), (int) rect.getMaxY()), new Point((int) rect.getMinX(), (int) rect.getMinY()));

        Area eliArea2 = new Area(elip);
        
        eliArea1.exclusiveOr(eliArea2);
        
        rectArea.intersect(eliArea1);
        
        figura = rectArea;
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
        
        ((Area) figura).transform(at);
    }
    
}
