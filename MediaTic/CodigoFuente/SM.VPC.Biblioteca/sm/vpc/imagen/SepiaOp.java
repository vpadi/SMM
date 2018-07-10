package sm.vpc.imagen;

import java.awt.image.BufferedImage;
import static java.lang.Math.min;
import sm.image.BufferedImageOpAdapter;

/**
 * Clase que hereda de BufferedImageOpAdapter para aplicarle
 * un filtro Sepia a una imagen. Todo su comportamiento está
 * definido en la clase de prácticas sobre tratamiento de imágenes.
 * @author Victor Padi
 */

public class SepiaOp extends BufferedImageOpAdapter {
    public SepiaOp () {}
    
    /**
     * Método que aplica un filtro sepia a una imagen segun lo estipulado
     * en la práctica de imagén de la asignatura.
     * @param src Imagen a aplicar el filtro
     * @param dest Si no es null, imagen donde se escribirá el contenido (debe ser compatible en 
     * características).
     * @return Si la imagen dest es null, devuelve una imagen copia de src con el filtro aplicado. 
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
                
                int[] SepiaPx = pixel.clone();
                
                SepiaPx[0] = (int) min(255, 0.393 * pixel[0] + 0.769 * pixel[1] + 0.189 * pixel[2]);
                SepiaPx[1] = (int) min(255, 0.349 * pixel[0] + 0.686 * pixel[1] + 0.168 * pixel[2]);
                SepiaPx[2] = (int) min(255, 0.272 * pixel[0] + 0.534 * pixel[1] + 0.131 * pixel[2]);
                        
                dest.getRaster().setPixel(x, y, SepiaPx);
            }
        }
        
        return dest;
    }
}