package sm.vpc.imagen;

import java.awt.image.BufferedImage;
import static java.lang.Math.max;
import static java.lang.Math.min;
import sm.image.BufferedImageOpAdapter;

/**
 * Clase que hereda de BufferedImageOpAdapter para la aplicación
 * del filtro Pixel a Pixel que realiza la media entre el máximo
 * y el mínimo valor de las bandas y sumarle el el valor de su banda
 * correspondiente. Cada uno de los factores tiene un peso del 0,5 .
 * @author Víctor Padilla
 */
public class MaxMinOp extends BufferedImageOpAdapter {
    /**
     * Constructor por defecto. No hace nada.
     */
    public MaxMinOp () {}
    
    /**
     * Aplicación del filtro max-min. El filtro coge cada pixel de la imagen y calcula la media entre el
     * máximo y el mínimo valor de todas las bandes del pixel. Este valor se le pondera con 0,5 y se suma
     * al propio valor de la banda también ponderado con 0,5.
     * @param src imagen fuente que se usará para aplicarle el filtro
     * @param dest imagen de destino donde se guardará la información resultante del filtro. Si es null 
     * entonces se crea una nueva y se devuelve.
     * @return null si dest != null, si no, una nueva imagen con la información resultante del filtro.
     */
    
    @Override
    public BufferedImage filter(BufferedImage src, BufferedImage dest){
        if (src == null) {
            throw new NullPointerException("src image is null");
        }
        
        if (dest == null) {
            dest = createCompatibleDestImage(src, null);
        }

        int[] pixel = null;
        
        for (int x = 0; x < src.getWidth(); x++) {
            for (int y = 0; y < src.getHeight(); y++) {
                pixel = src.getRaster().getPixel(x, y, pixel);
                
                int[] OpPx = pixel.clone();
                
                int minimo = (int) min(pixel[0], pixel[1]); 
                minimo = (int) min(minimo, pixel[2]);
                
                int maximo = (int) max(pixel[0], pixel[1]); 
                maximo = (int) max(minimo, pixel[2]);
               
                
                OpPx[0] = (((maximo + minimo) / 2) / 2) + (pixel[0] / 2);
                OpPx[1] = (((maximo + minimo) / 2) / 2) + (pixel[1] / 2);
                OpPx[2] = (((maximo + minimo) / 2) / 2) + (pixel[2] / 2);

                
                dest.getRaster().setPixel(x, y, OpPx);
            }
        }
        
        return dest;
    }
}
