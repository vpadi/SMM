/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediatic;

import java.io.File;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerEventAdapter;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

/**
 * Clase que hereda de VentanaInterna para la reproducción 
 * y el control de un vídeo que se muestra sobre un JInternalFrame.
 * @author Víctor Padilla
 */
public class VentanaInternaVLCPlayer extends VentanaInterna {
    private EmbeddedMediaPlayer vlcplayer = null;
    private File fMedia;
    private boolean mute = false;
    
    /**
     * Creates new form VentanaInternaVLCPlayer
     */
    public VentanaInternaVLCPlayer(VentanaPrincipal p, File f) {
        super(p);
        
        initComponents();
        
        fMedia = f;
        
        EmbeddedMediaPlayerComponent aVisual = new EmbeddedMediaPlayerComponent();

        getContentPane().add(aVisual,java.awt.BorderLayout.CENTER);

        vlcplayer = aVisual.getMediaPlayer();
        
        vlcplayer.setVolume(100);
        
        this.setSize(542,389);
        
        vlcplayer.addMediaPlayerEventListener(new VideoListener());
    }
    
    public static VentanaInternaVLCPlayer getInstance(VentanaPrincipal p, File f){
        VentanaInternaVLCPlayer v = new VentanaInternaVLCPlayer(p, f);
        
        return (v.vlcplayer!=null?v:null);
    }
    
    public void play() {
        if (vlcplayer != null) {
            if(vlcplayer.isPlayable()){
            //Si se estaba reproduciendo
            vlcplayer.play();
            } else 
                vlcplayer.playMedia(fMedia.getAbsolutePath());        
        }
    }
    public void stop() {
        if (vlcplayer != null) {
            if (vlcplayer.isPlaying()) {
                vlcplayer.pause();
            } else {
                vlcplayer.stop();
            }
        }
    }
    
    public java.awt.image.BufferedImage getFrame(){
        if(vlcplayer != null){
            return vlcplayer.getSnapshot();
        }
        
        return null;
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelControl = new javax.swing.JPanel();
        playBoton = new javax.swing.JButton();
        stopBoton = new javax.swing.JButton();
        barraTiempo = new javax.swing.JProgressBar();
        muteBoton = new javax.swing.JButton();
        sliderVolumen = new javax.swing.JSlider();
        AudioAltoLabel = new javax.swing.JLabel();
        capturaBoton = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setMinimumSize(new java.awt.Dimension(542, 389));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        playBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/round_play_circle_filled_black_18dp.png"))); // NOI18N
        playBoton.setToolTipText("Play/Pause");
        playBoton.setPreferredSize(new java.awt.Dimension(40, 40));
        playBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playBotonActionPerformed(evt);
            }
        });
        panelControl.add(playBoton);

        stopBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/round_stop_black_24dp.png"))); // NOI18N
        stopBoton.setToolTipText("Stop");
        stopBoton.setPreferredSize(new java.awt.Dimension(40, 40));
        stopBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopBotonActionPerformed(evt);
            }
        });
        panelControl.add(stopBoton);
        panelControl.add(barraTiempo);

        muteBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/baseline_volume_down_black_18dp.png"))); // NOI18N
        muteBoton.setToolTipText("Mute");
        muteBoton.setPreferredSize(new java.awt.Dimension(30, 34));
        muteBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                muteBotonActionPerformed(evt);
            }
        });
        panelControl.add(muteBoton);

        sliderVolumen.setToolTipText("Volumen");
        sliderVolumen.setValue(100);
        sliderVolumen.setPreferredSize(new java.awt.Dimension(150, 16));
        sliderVolumen.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderVolumenStateChanged(evt);
            }
        });
        panelControl.add(sliderVolumen);

        AudioAltoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/baseline_volume_up_black_18dp.png"))); // NOI18N
        panelControl.add(AudioAltoLabel);

        capturaBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/baseline_add_a_photo_black_18dp.png"))); // NOI18N
        capturaBoton.setToolTipText("Realizar una captura");
        capturaBoton.setPreferredSize(new java.awt.Dimension(50, 40));
        capturaBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                capturaBotonActionPerformed(evt);
            }
        });
        panelControl.add(capturaBoton);

        getContentPane().add(panelControl, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        this.stop();
        
        vlcplayer = null;
    }//GEN-LAST:event_formInternalFrameClosing

    private void playBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playBotonActionPerformed
        if(vlcplayer != null && !vlcplayer.isPlaying())
            this.play();
        else
            this.stop();
    }//GEN-LAST:event_playBotonActionPerformed

    private void stopBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopBotonActionPerformed
        if(vlcplayer != null){
            vlcplayer.stop();
        }
    }//GEN-LAST:event_stopBotonActionPerformed

    private void sliderVolumenStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderVolumenStateChanged
        if(vlcplayer != null) {
            vlcplayer.setVolume(sliderVolumen.getValue());
            
            if(mute){
                mute = false;
                
                muteBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/baseline_volume_down_black_18dp.png")));
            }
        }
    }//GEN-LAST:event_sliderVolumenStateChanged

    private void muteBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_muteBotonActionPerformed
        if(vlcplayer != null) {
            if(!mute){
                vlcplayer.setVolume(0);
            
                muteBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/baseline_volume_off_black_18dp.png")));
                                
                sliderVolumen.setValue(0);
                
                mute = true;
            }
            else{
                vlcplayer.setVolume(sliderVolumen.getMaximum());
                
                muteBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/baseline_volume_down_black_18dp.png")));

                sliderVolumen.setValue(sliderVolumen.getMaximum());
                
                mute = false;
            }
        }
    }//GEN-LAST:event_muteBotonActionPerformed

    private void capturaBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_capturaBotonActionPerformed
        if(vlcplayer != null){
            parent.crearVentanaCaptura(vlcplayer.getSnapshot());
        }
    }//GEN-LAST:event_capturaBotonActionPerformed

    private class VideoListener extends MediaPlayerEventAdapter {
        @Override
        public void finished(MediaPlayer mediaPlayer) {
            playBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/round_play_circle_filled_black_18dp.png")));
        }
        
        public void videoOutput(MediaPlayer mediaPlayer, int newCount){
            setPreferredSize(vlcplayer.getVideoDimension());
           
            barraTiempo.setMaximum((int) vlcplayer.getLength());
        }
        
        public void playing(MediaPlayer mediaPlayer){
            playBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/round_pause_circle_filled_black_18dp.png")));
        }
        
        public void paused(MediaPlayer mediaPlayer){
            playBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/round_play_circle_filled_black_18dp.png")));
        }
        
        public void stopped(MediaPlayer mediaPlayer){
            playBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/round_play_circle_filled_black_18dp.png")));
            barraTiempo.setValue(0);
        }
        
        public void timeChanged(MediaPlayer mediaPlayer, long newTime){
            barraTiempo.setValue((int) vlcplayer.getTime());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AudioAltoLabel;
    private javax.swing.JProgressBar barraTiempo;
    private javax.swing.JButton capturaBoton;
    private javax.swing.JButton muteBoton;
    private javax.swing.JPanel panelControl;
    private javax.swing.JButton playBoton;
    private javax.swing.JSlider sliderVolumen;
    private javax.swing.JButton stopBoton;
    // End of variables declaration//GEN-END:variables
}
