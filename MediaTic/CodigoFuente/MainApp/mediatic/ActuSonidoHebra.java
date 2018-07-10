package mediatic;

import javax.sound.sampled.Clip;
import javax.swing.JProgressBar;

/**
 * Clase que hereda de Thread para la actualización 
 * de componentes concurrentemente que muestran el avance
 * de la reproducción de un audio.
 * @author Víctor Padilla
 */
public class ActuSonidoHebra extends Thread{
    private Clip clip = null;
    private JProgressBar barraTiempoSonido = null;
    
    public void setClip(Clip c){
        clip = c;
    }
    
    public void setProgressBar(JProgressBar b){
        barraTiempoSonido = b;
    }

    public void run() {
        if(clip != null && barraTiempoSonido != null){
            while(clip.isOpen())
                barraTiempoSonido.setValue((int) (clip.getMicrosecondPosition()));
        }
    }  
}
