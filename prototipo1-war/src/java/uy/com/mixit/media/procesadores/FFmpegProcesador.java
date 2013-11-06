/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.mixit.media.procesadores;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import uy.com.mixit.objetos.Video;

/**
 *
 * @author Bruno
 */
public class FFmpegProcesador {
    /*
     *  -i indicates the input
     *  -ab indicates the bit rate (in this example 160kb/sec)
     *  -vn means no video ouput
     *  -ac 2 means 2 channels
     *  -ar 44100 indicates the sampling frequency. 
     * 
     */
    public static String EXTRACT_AUDIO = "ffmpeg -i {0} -ab 64k -ac 2 -ar 44100 -vn {1}";
    public static String CREATE_MOZAIC = "ffmpeg -i {0} -i {1} -i {2} -i {3} -filter_complex \"nullsrc=size=640x480 [base]; [0:v] setpts=PTS-STARTPTS, scale=320x240 [upperleft]; [1:v] setpts=PTS-STARTPTS, scale=320x240 [upperright]; [2:v] setpts=PTS-STARTPTS, scale=320x240 [lowerleft]; [3:v] setpts=PTS-STARTPTS, scale=320x240 [lowerright]; [base][upperleft] overlay=shortest=1 [tmp1]; [tmp1][upperright] overlay=shortest=1:x=320 [tmp2]; [tmp2][lowerleft] overlay=shortest=1:y=240 [tmp3]; [tmp3][lowerright] overlay=shortest=1:x=320:y=240\" -c:v libx264 {4}";
    public static String CREATE_MOZAIC_4_ITEMS = "ffmpeg {0} -filter_complex \"nullsrc=size=640x480 [base]; [0:v] setpts=PTS-1, scale=320x240 [upperleft]; [1:v] setpts=PTS-STARTPTS, scale=320x240 [upperright]; [2:v] setpts=PTS-STARTPTS, scale=320x240 [lowerleft]; [3:v] setpts=PTS-STARTPTS, scale=320x240 [lowerright]; [base][upperleft] overlay=shortest=1 [tmp1]; [tmp1][upperright] overlay=shortest=1:x=320 [tmp2]; [tmp2][lowerleft] overlay=shortest=1:y=240 [tmp3]; [tmp3][lowerright] overlay=shortest=1:x=320:y=240\" -c:v libx264 {1}";
    //amix=inputs=4:duration=longest
    public static void extraerAudio(String video,String audio){
        Runtime rt = Runtime.getRuntime();
        try {
            Process pr = rt.exec((EXTRACT_AUDIO.replace("{0}",video)).replace("{1}", audio));
        } catch (IOException ex) {
            Logger.getLogger(FFmpegProcesador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void crearMosaico(List<Video> videos,String videoOut){
        String videosParams = "";
        for(Video v : videos){
            videosParams += v.getCorrimiento() != null && v.getCorrimiento() > 0 ? " -itsoffset "+v.getCorrimientoEnHHMMSS(): "";
            videosParams += " -i "+v.getPathVideo()+" ";
        }
        Runtime rt = Runtime.getRuntime();
        try {
            String s = CREATE_MOZAIC_4_ITEMS.replace("{0}",videosParams).replace("{1}",videoOut);
            System.out.println("==>>"+s);
            Process pr = rt.exec(s);
        } catch (IOException ex) {
            Logger.getLogger(FFmpegProcesador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void crearMosaico(String video1,String video2,String video3,String video4,String videoOut){
        Runtime rt = Runtime.getRuntime();
        try {
            String s = (CREATE_MOZAIC.replace("{0}",video1)).replace("{1}",video2).replace("{2}",video3).replace("{3}",video4).replace("{4}",videoOut);
            System.out.println("==>>"+s);
            Process pr = rt.exec(s);
        } catch (IOException ex) {
            Logger.getLogger(FFmpegProcesador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
