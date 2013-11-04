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
public class BD {
    
    private static BD instance;
    List<Proyecto> proyectos;
    private static Integer generalId = 0;
    
    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }
    
    private BD(){
        proyectos = new ArrayList<>();
    }
    
    public static BD getInstance(){
        if(instance == null){
            instance = new BD();
        }
        return instance;
    }
    
    public static Integer getNextId(){
        return generalId++;
    }
    
    public static Proyecto getLastProyecto(){
        return BD.getInstance().getProyectos().get(BD.getInstance().getProyectos().size() - 1);
    }
}

