/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codeforces.api.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;

/**
 *
 * @author Parvez
 */
public class Codeforces {
    private static HttpURLConnection connection ;
    private static final String cf_api = "https://codeforces.com/api/";
    private static StringBuffer content  ;
    private static BufferedReader reader ;
    private static String line ;
    
    public Codeforces() {
        
    }
    
    Pair<Boolean, String> get(String request){
        content = new StringBuffer() ;
        Boolean ret = false ;
        try {
            URL url = new URL(cf_api + request) ;
            connection = (HttpURLConnection)url.openConnection();
            
            // request setup
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            
            int status = connection.getResponseCode();
            
            if(status >= 300){
                // something went wrong
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream())) ;
                while((line = reader.readLine()) != null){
                    content.append(line) ;
                }
                reader.close() ;
            }
            else {
                // successful connection
                ret = true ;
                
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream())) ;
                while((line = reader.readLine()) != null){
                    content.append(line) ;
                }
                reader.close() ;
            }
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(Codeforces.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Codeforces.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new Pair<Boolean, String>(ret, content.toString()) ;
    }
}
