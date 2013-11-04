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
    private Video videoPublicado;
    
    public Proyecto(){
        videos = new ArrayList<>();
        videoPublicado = new Video();
        videoPublicado.setPathVideo(Util.URL_FILES+"outputPrubea.flv");
    }

    public Video getVideoPublicado() {
        return videoPublicado;
    }

    public void setVideoPublicado(Video videoPublicado) {
        this.videoPublicado = videoPublicado;
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
        String audioPath = Util.getFileNameNoExtension(videoPath)+".mp3";
        FFmpegProcesador.extraerAudio(videoPath,audioPath);
        System.out.println(audioPath);
        vid.setPathAudio(audioPath);
        videos.add(vid);
    }
    
    public void crearVideo(){
        //FFmpegProcesador.crearMosaico(getVideos().get(0).getPathVideo(), getVideos().get(1).getPathVideo(), getVideos().get(2).getPathVideo(), getVideos().get(3).getPathVideo(), "outPutMixeo.flv");
        FFmpegProcesador.crearMosaico(this.getVideos(),videoPublicado.getPathVideo());
    }
    
}
