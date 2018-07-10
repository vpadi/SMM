package sm.vpc.imagen;

import java.awt.image.ByteLookupTable;
import java.awt.image.LookupTable;

/**
 *  Clase productora de LookUpTable(s). Sus distintos métodos
 *  devuelven objetos que se pueden usar para aplicar posteriormente
 *  LookUpOp a imagenes.
 * @author Víctor Padilla
 * @version 1.0
 */
public class LookupTableCreator {
    private LookupTableCreator(){}
    
    /**
     * Método estático para la creación de una LookupTable
     * que estará compuesta por valores absolutos de una función senoidal.
     * @param w el desplazamiento de la función en el eje X (expresado como un factor que multiplica los grados).
     * @return Una LookupTable con los valores correspondientes a la función.
     */
    public static LookupTable seno(double w){
        byte lt[] = new byte[256];
        double K = 255.0; // Cte de normalización
        
        for (int x=1; x<256; x++){
            lt[x] = (byte)Math.abs(K*Math.sin(Math.toRadians(w * x)));
        }
        
        ByteLookupTable slt = new ByteLookupTable(0,lt);
        
        return slt;
    }
    
    /**
     * Método estático para la creación de una LookupTable
     * que estará compuesta por el doble de valor del índice si
     * este es par o la mitad si es impar.
     * @return Una LookupTable con los valores correspondientes a la función.
     */
    
    public static LookupTable parImpar(){
        byte lt[] = new byte[256];
        
        for(int x = 1; x < 256; ++x){
            if((x & 1) == 0){ // Si es Par
                lt[x] = (byte) Math.min(255, x*2);
            }
            else{ //Si es impar
                lt[x] = (byte) (x / 2);
            }
        }

        ByteLookupTable blt = new ByteLookupTable(0,lt);

        return blt;
    }
    
    /**
     * Método estático para la creación de una LookupTable
     * que estará compuesta por los valores de una función absoluta con origen
     * (y = 0) en x = 128. No requiere de factor de correción. El resultado
     * de está función es sorprende: al aplicarse una vez hace más brillante
     * los valores más bajos y más oscuros los más altos. Estos se hacen más oscuros
     * conformen se vayan acercando a 128. Si se aplica otra vez, realiza un filtro
     * similar al negativo.
     * @return Una LookupTable con los valores correspondientes a la función.
     */
    
    public static LookupTable absoluto(){
        byte lt[] = new byte[256];
        
        for(int x = 1; x < 256; ++x){
            lt[x] = (byte) Math.abs(x - 128);
        }

        ByteLookupTable blt = new ByteLookupTable(0,lt);

        return blt;
    }
}
