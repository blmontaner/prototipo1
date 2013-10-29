/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.mixit.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.Part;
import uy.com.mixit.media.procesadores.FileCopier;
import uy.com.mixit.objetos.BD;
import uy.com.mixit.objetos.Proyecto;

/**
 *
 * @author Bruno
 */
@ManagedBean(name = "bean")
@RequestScoped
public class FileBean {

    /**
     * Creates a new instance of FileBean
     */
    public FileBean() {
    }
    private Part file1;
    private Part file2;
    private Part file3;
    private Part file4;
    private Part file5;
    private String fileContent;

    public Part getFile1() {
        return file1;
    }

    public void setFile1(Part file1) {
        this.file1 = file1;
    }

    public Part getFile2() {
        return file2;
    }

    public void setFile2(Part file2) {
        this.file2 = file2;
    }

    public Part getFile3() {
        return file3;
    }

    public void setFile3(Part file3) {
        this.file3 = file3;
    }

    public Part getFile4() {
        return file4;
    }

    public void setFile4(Part file4) {
        this.file4 = file4;
    }

    public Part getFile5() {
        return file5;
    }

    public void setFile5(Part file5) {
        this.file5 = file5;
    }

    public String getFileContent() {
        return fileContent;
    }

    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }

    public void upload() {
        Proyecto p = new Proyecto();
        p.agregarNuevoVideo(FileCopier.copyFileToServer(file1));
        p.agregarNuevoVideo(FileCopier.copyFileToServer(file2));
        p.agregarNuevoVideo(FileCopier.copyFileToServer(file3));
        p.agregarNuevoVideo(FileCopier.copyFileToServer(file4));
        p.agregarNuevoVideo(FileCopier.copyFileToServer(file5));
        BD.getInstance().getProyectos().add(p);
     }
}
