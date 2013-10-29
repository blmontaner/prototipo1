/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.mixit.objetos;

import java.util.ArrayList;
import java.util.List;
import uy.com.mixit.media.procesadores.FFmpegProcesador;
import uy.com.mixit.utils.Util;

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
    
    public void agregarNuevoVideo(String videoPath){
        Video vid = new Video();
        vid.setId(BD.getNextId());
        vid.setPathVideo(videoPath);
        System.out.println(videoPath);
        String audioPath = Util.getFileNameNoExtension(videoPath)+".wav";
        FFmpegProcesador.extraerAudio(videoPath,audioPath);
        System.out.println(audioPath);
        vid.setPathAudio(audioPath);
        videos.add(vid);
    }
    
}
