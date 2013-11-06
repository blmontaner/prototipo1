/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.mixit.objetos;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Bruno
 */
public class Video {
    private Integer id;
    private String pathAudio;
    private String pathVideo;
    private Integer corrimiento;

    public String getPathAudio() {
        return pathAudio;
    }
    
    public String getRelativePathAudio() {
        File f = new File(pathAudio);
        return f.getName();
    }

    public void setPathAudio(String pathAudio) {
        this.pathAudio = pathAudio;
    }

    public String getPathVideo() {
        return pathVideo;
    }

    public void setPathVideo(String pathVideo) {
        this.pathVideo = pathVideo;
    }

    public Integer getCorrimiento() {
        return corrimiento;
    }
    
    public String getCorrimientoEnHHMMSS(){
       return String.format("%02d:%02d:%02d", 
        TimeUnit.MILLISECONDS.toHours(corrimiento),
        TimeUnit.MILLISECONDS.toMinutes(corrimiento) -  
        TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(corrimiento)), // The change is in this line
        TimeUnit.MILLISECONDS.toSeconds(corrimiento) - 
        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(corrimiento)));   
    }

    public void setCorrimiento(Integer corrimiento) {
        this.corrimiento = corrimiento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    
}
