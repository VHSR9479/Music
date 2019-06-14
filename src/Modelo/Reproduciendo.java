/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

/**
 *
 * @author victorhugo
 */
public class Reproduciendo {
    
    public Reproduciendo(File archivo) throws JavaLayerException, FileNotFoundException{
        AdvancedPlayer reproductor;
    reproductor = new AdvancedPlayer(new FileInputStream(archivo));
    reproductor.play();
    
    }
}
