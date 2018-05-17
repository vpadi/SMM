/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.vpc.imagen;

import java.awt.image.ByteLookupTable;
import java.awt.image.LookupTable;

/**
 *
 * @author gh-ro
 */
public class imagenUtils {
    public static LookupTable seno(double w){
        byte lt[] = new byte[256];
        double K = 255.0; // Cte de normalización
        
        for (int x=1; x<256; x++){
            lt[x] = (byte)Math.abs(K*Math.sin(Math.toRadians(w * x)));
        }
        
        ByteLookupTable slt = new ByteLookupTable(0,lt);
        
        return slt;
    }
}
