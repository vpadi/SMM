package sm.vpc.imagen;

import java.awt.image.BufferedImage;
import static java.lang.Math.min;
import sm.image.BufferedImageOpAdapter;

/**
 *
 * @author Victor Padi
 */

public class SepiaOp extends BufferedImageOpAdapter {
    public SepiaOp () {}
    
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