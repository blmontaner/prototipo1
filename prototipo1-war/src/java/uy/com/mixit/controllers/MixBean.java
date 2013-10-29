/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.mixit.controllers;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import uy.com.mixit.objetos.BD;
import uy.com.mixit.objetos.Video;

/**
 *
 * @author Bruno
 */
@ManagedBean(name = "mix")
@RequestScoped
public class MixBean {

    /**
     * Creates a new instance of MixBean
     */
    public MixBean() {
    }
    
    public List<Video> getCurrentVideos(){
        return BD.getInstance().getProyectos().get(0).getVideos();
    }
}
