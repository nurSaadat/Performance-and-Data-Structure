/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstlabproj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author Sunny
 */
public class FirstLabProj {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, IOException {
        
        String urlString = "http://127.0.0.1:8000/api/Blog/?format=json";
        URL url = new URL(urlString);
        URLConnection con = url.openConnection();
        InputStream is =con.getInputStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        
    }
    
}
