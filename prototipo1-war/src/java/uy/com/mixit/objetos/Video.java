/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.mixit.objetos;

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
