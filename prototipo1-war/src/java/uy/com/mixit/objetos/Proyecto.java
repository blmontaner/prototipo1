/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.mixit.objetos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bruno
 */
public class Proyecto {
    private List<Video> videos;
    
    public Proyecto(){
        videos = new ArrayList<>();
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }
    
}
