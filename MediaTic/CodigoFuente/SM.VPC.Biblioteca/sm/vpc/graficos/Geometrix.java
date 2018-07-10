package sm.vpc.graficos;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Point2D;

/**
 * Clase abstracta que representa una figura geométrica con sus respectivos atributos.
 * Contiene un atributo de la clase Shape que representa la figura y varios campos que 
 * representa los distintos atributos de esta (Color, transparencia, alisado de bordes, etc...)
 * @author Víctor Padilla
 * @version 1.0
 */
public abstract class Geometrix{
    /**
     * Objeto representación de la figura geométrica.
     * Contiene la información espacial y geométrica.
     */
    protected Shape figura;
    /**
     * Colores de trazo y relleno.
     */
    protected Color colorTrazo, colorRelleno;
    /**
     * Colores del gradiente.
     */
    protected Color colorFrente, colorFondo;
    /**
     * Los rasgos del trazo.
     */
    protected BasicStroke stroke;
    /**
     * El grado de transparencia.
     */
    protected int alpha;
    /**
     * Activaciones de diferentes características como el relleno y 
     * el tipo de gradiente.
     */
    protected boolean relleno = false, vertical = true;
    /**
     * El tipo de discontinuidad si se activa.
     */
    protected float patronDiscontinuidad[] = {15.0f, 15.0f};
    /**
     * Las ayudas para la renderización de la figura.
     */
    protected RenderingHints render;
    
   
    /**
     * Constructor por defecto. Inicializa la figura a null y los
     * atributos al estado básico.
     */
    
    public Geometrix() {
        figura = null;
        
        colorTrazo = new Color(0,0,0);
        colorRelleno = new Color(0,0,0);
        stroke = new BasicStroke();
        render = null;
        
        colorFrente = colorFondo = null;
        
        alpha = 255;
    }
    
    /**
     * Asignación de suavizado de bordes.
     * @param ali "true" para el suavizado, "falso" en caso contrario.
     */
    
    public void setAliasing(boolean ali){
        if(ali)
            render = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        else
            render = null;
    }
    
    /**
     * Asignación del grosor del contorno.
     * @param grs Valor entero del grosor del contorno.
     */
    
    public void setThickness(int grs){
        stroke = new BasicStroke((float) grs);
    }
    
    /**
     * Asignación del relleno de la figura.
     * @param fll "true" para activar el relleno, "false" de lo contrario.
     */
    
    public void setFill(boolean fll){
        relleno = fll;
    }
    
    
    /**
     * Asignación del color del trazo.
     * @param c Nuevo Color del trazo.
     */
    
    public void setStrokeColor(Color c){
        colorTrazo = new Color(c.getRed(),c.getGreen(),c.getBlue(), alpha);
    }
    
    /**
     * Asignación del color del trazo. Formato por componentes.
     * @param r Nuevo valor de rojo.
     * @param g Nuevo valor de verde.
     * @param b Nuevo valor de azul.
     */
    
    public void setStrokeColor(int r, int g, int b){
        colorTrazo = new Color(r,g,b, alpha);
    }
    
    /**
     * Asignación del color del relleno.
     * @param c Nuevo Color del relleno.
     */
    public void setFillerColor(Color c){
        colorRelleno = new Color(c.getRed(),c.getGreen(),c.getBlue(), alpha);
    }
    
    /**
     * Asignación del color del relleno. Formato por componentes.
     * @param r Nuevo valor de rojo.
     * @param g Nuevo valor de verde.
     * @param b Nuevo valor de azul.
     */
    public void setFillerColor(int r, int g, int b){
        colorRelleno = new Color(r,g,b, alpha);
    }
    
    /**
     * Activa o desactiva el trazo discontinuo.
     * @param disc "true" si se activa (se crea un nuevo BasicStroke
     * con trazo discontinuo), "false" si se desactiva.
     */
    
    public void setDiscontStroke(boolean disc){
        if(disc)
            stroke = new BasicStroke(stroke.getLineWidth(), stroke.getEndCap(), stroke.getLineJoin(), stroke.getMiterLimit(), patronDiscontinuidad, 0.0f);
        else 
            stroke = new BasicStroke(stroke.getLineWidth());

    }

    /**
     * Asignación de la transparencia.
     * @param a Nuevo valor de la transparencia: de 0 a 255(máxima opacidad).
     */
    
    
    public void setTransparency(int a){
        alpha = a;
        
        this.setFillerColor(colorRelleno);
        this.setStrokeColor(colorTrazo);
    } 
    
    /**
     * Método para definir el gradiente de relleno.
     * @param start Color de Frente del Gradiente.
     * @param end Color de Fondo del Gradiente.
     * @param vert "true" si el gradiente es en el eje vertical, "false" si es en el horizontal.
     */
    
    public void setGradient(Color start, Color end, boolean vert){
        colorFrente = start;
        colorFondo = end;
        
        vertical = vert;
    }
    
    /**
     * Método para dibujar la figura. Toma un objeto Graphics, lo castea
     * a un Graphics2D, aplica los atributos que tiene asignados en ese 
     * momento y dibuja la figura. Primero el relleno y luego el contorno
     * (fill y draw de g respectivamente).
     * @param g Objeto Graphics que dibujará la figura.
     */
    
    public void draw(Graphics g){
        Graphics2D g2d = (Graphics2D)g;

        /* Apply the attributes to the Graphics object */
        
        if(relleno)
            g2d.setPaint(colorRelleno);
        else if(colorFrente != null && colorFondo != null){
            GradientPaint gradiente;
            
            if(vertical){
                gradiente = new GradientPaint((float) figura.getBounds().getCenterX(), (float) figura.getBounds().getMinY(), colorFrente, (float) figura.getBounds().getCenterX(),
                                               (float) figura.getBounds().getMaxY() + 10, colorFondo, true);
            }
            else{                
                gradiente = new GradientPaint((float) figura.getBounds().getMinX(), (float) figura.getBounds().getCenterY(), colorFrente, (float) figura.getBounds().getMaxX() + 10,
                                               (float) figura.getBounds().getCenterY(), colorFondo, true);
            }
            
            g2d.setPaint(gradiente);
        }
        
        if(stroke != null)
            g2d.setStroke(stroke);
       
        if(render != null)
            g2d.setRenderingHints(render);
        
        if(relleno || (colorFrente != null && colorFondo != null)) g2d.fill(figura);

        /* Apply the color of the outline */
        if(colorTrazo != null)
            g2d.setColor(colorTrazo);
        
        g2d.draw(figura);
    }
    
    /**
     * Método para dibujar el contorno discontinuo de la boundingBox que 
     * encierra a la figura. Se usa para delimitar la figura seleccionada.
     * Depende del comportamiento del getBounds() de cada tipo de figura.
     * @param g Objeto Graphics que dibujara el rectangulo discontinuo.
     */
    
    public void drawEditBox(Graphics g){
        float discontinuidad[] = {5.0f, 5.0f};
        
        Graphics2D g2d = (Graphics2D)g;
        
        Rectangle box = figura.getBounds();
        
        g2d.setColor(new Color(0,0,0));
        g2d.setStroke(new BasicStroke(1.8f, stroke.getEndCap(), stroke.getLineJoin(), stroke.getMiterLimit(), discontinuidad, 0.0f));
        
        g2d.draw(box);
    }
    
    /**
     * Método que comprueba si un punto p esta contenido por la figura.
     * Internamente llama al contains() de cada figura.
     * @param p Point2D que contiene la coordenadas a comprobar. 
     * @return "true" si la figura contiene al punto, "false" de lo contrario.
     */
    
    public boolean contains(Point2D p){
        return figura.contains(p);
    }
    
    /**
     * Método abstracto para actualizar la posición de la figura
     * a una nueva dada por un punto p.
     * @param p Coordenadas nuevas de la figura (depende de cada figura).
     */
    
    public abstract void updateLocation(Point p);    
    
}
