package sm.vpc.imagen;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import static java.lang.Math.min;
import sm.image.BufferedImageOpAdapter;

/**
 * Clase que hereda de BufferedImageOpAdapter para la aplicación
 * del filtro de producto por pi modular (a 256). Es un filtro
 * del tipo Componente a Componente (Bandas independientes).
 * @author Víctor Padilla
 */
public class ImagePiOp extends BufferedImageOpAdapter {
   /**
    * Constructor por defecto. No hace nada.
    */
    public ImagePiOp () {}
    
    /**
     * Aplicación del filtro de producto por pi modular. Cogerá una imagen
     * fuente y múltiplicará el valor de cada banda de cada pixel por pi y 
     * le realizará el módulo de 256 (para que no se salga del rango).
     * Es un simple pero crea un efecto de incremento líneal con bajada de 
     * saturación de las bandas más brillantes interantes.
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
        
        WritableRaster srcRaster = src.getRaster();
        WritableRaster destRaster = dest.getRaster();
        
        for (int x = 0; x < src.getWidth(); x++) {
            for (int y = 0; y < src.getHeight(); y++) {
                for (int band = 0; band < srcRaster.getNumBands(); band++) {
                    int sample = srcRaster.getSample(x, y, band);            
                
                    sample = (int) ((sample * Math.PI) % 256);

                    destRaster.setSample(x, y, band, sample);
                }
            }
        }
        
        return dest;
    }
}