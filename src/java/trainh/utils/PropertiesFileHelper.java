/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainh.utils;

import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;

/**
 *
 * @author trainh
 */
public class PropertiesFileHelper {
    
    public static Properties getProperties(ServletContext context, String fileRelativaPath) {
        InputStream input = context.getResourceAsStream(fileRelativaPath);
        Properties prop = null;
        try {
            prop = new Properties();
            prop.load(input);
        } catch (Exception ex) {
            Logger.getLogger(PropertiesFileHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prop;
    }
}
