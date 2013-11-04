/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.mixit.controllers;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import uy.com.mixit.media.procesadores.FFmpegProcesador;
import uy.com.mixit.objetos.BD;
import uy.com.mixit.objetos.Video;

/**
 *
 * @author Bruno
 */
@ManagedBean(name = "mix")
@RequestScoped
public class MixBean {

    private String jSONCorrimientos;

    /**
     * Creates a new instance of MixBean
     */
    public MixBean() {
    }

    public List<Video> getCurrentVideos() {
        return BD.getLastProyecto().getVideos();
    }

    public void getCorrimientos() {
        for (Video v : BD.getLastProyecto().getVideos()) {
            System.out.println(v.getId() + " c: " + v.getCorrimiento());
        }
    }

    public void setJSONCorrimientos(String val) {
        jSONCorrimientos = val;
    }

    public String getJSONCorrimientos() {
        return jSONCorrimientos;
    }

    public void crearVideo() {
        if (!jSONCorrimientos.isEmpty()) {
            Gson gson = new Gson();
            List<Map<String, Object>> corrimientos = gson.fromJson(jSONCorrimientos, List.class);
            Map<Integer, Integer> idCorrimiento = new HashMap<>();
            for (Map<String, Object> jsonMap : corrimientos) {
                idCorrimiento.put(((Double)jsonMap.get("id")).intValue(),((Double)jsonMap.get("corrimiento")).intValue());
                System.out.print(((Double)jsonMap.get("id")).intValue() + " corri= " + ((Double)jsonMap.get("corrimiento")).intValue());
            }
            for (Video v : BD.getLastProyecto().getVideos()) {
                if (idCorrimiento.containsKey(v.getId())) {
                    v.setCorrimiento(idCorrimiento.get(v.getId()));
                }
            }
            BD.getLastProyecto().crearVideo();
        }
    }
}
