/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codeforces.api.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

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
    
    String get(String request) throws Exception{
        content = new StringBuffer() ;
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
                throw new Exception() ;
            }
            else {
                // successful connection
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream())) ;
                while((line = reader.readLine()) != null){
                    content.append(line) ;
                }
                reader.close() ;
            }
            
        } catch (Exception e) {
            throw e ;
        }
        
        return content.toString() ;
    }
}
