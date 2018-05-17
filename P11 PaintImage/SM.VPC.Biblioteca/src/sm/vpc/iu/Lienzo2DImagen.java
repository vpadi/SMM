/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.vpc.iu;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author gh-ro
 */
public class Lienzo2DImagen extends Lienzo2D{
    BufferedImage img = null;
    
    public void setImagen(BufferedImage i){
        this.img = i;
        
        if(img!=null) {
            this.setPreferredSize(new Dimension(img.getWidth(),img.getHeight()));
        }
    }
    
    public BufferedImage getImagen(){
        return img;
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        if(img!=null) g.drawImage(img,0,0,this);
    }

    public BufferedImage getImagen(boolean drawVector) {
        if (drawVector) {
            BufferedImage imgOut = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
            
            this.paint(imgOut.createGraphics());
            
            return imgOut;
        }
        else
            return img;
    }
}
