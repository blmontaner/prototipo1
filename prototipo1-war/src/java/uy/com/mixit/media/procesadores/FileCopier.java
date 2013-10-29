/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.mixit.media.procesadores;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Part;
import uy.com.mixit.controllers.FileBean;
import uy.com.mixit.utils.Util;

/**
 *
 * @author Bruno
 */
public class FileCopier {

    public static String copyFileToServer(Part part) {
        try(FileOutputStream output = new FileOutputStream(Util.URL_FILES + part.getSubmittedFileName())) {
            try (InputStream input = part.getInputStream()) {
                byte[] buf = new byte[1024];
                int len;
                while ((len = input.read(buf)) > 0) {
                    output.write(buf, 0, len);
                }
            } catch (IOException ex) {
                Logger.getLogger(FileCopier.class.getName()).log(Level.SEVERE, null, ex);
            }
            output.close();
        } catch (IOException ex) {
            Logger.getLogger(FileCopier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Util.URL_FILES + part.getSubmittedFileName();
    }
}
