/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.mixit.utils;

/**
 *
 * @author Bruno
 */
public class Util {
    
    //public static final String URL_FILES = "C:/serverFolder/";
    public static final String URL_FILES = "/home/bruno/serverFolder/";
    
    public static String getFileNameNoExtension(String fileName){
        String name;
        name = fileName.substring(0, fileName.lastIndexOf('.'));
        return name;
    }
    
}
