/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.vpc.graficos;

import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 *
 * @author gh-ro
 */
public class Linea2D extends Line2D.Float {

    public Linea2D(Point p1, Point p2) {
        this.setLine(p1, p2);
    }

    public Linea2D() {}

    public boolean isNear(Point2D p){
        if (getP1().equals(getP2()))
            return getP1().distance(p) <= 3.0D;
        else 
            return ptLineDist(p) <= 3.0D;
    }
    
    @Override
    public boolean contains(Point2D p) {
        return isNear(p);
    }
       
    public void setLocation(Point2D pos){
        double dx=pos.getX()-this.getX1();
        double dy=pos.getY()-this.getY1();

        Point2D newp2 = new Point2D.Double(this.getX2()+dx,this.getY2()+dy);
    
        this.setLine(pos,newp2);
    }
}
