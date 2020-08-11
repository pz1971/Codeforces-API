/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeforcesAPI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Parvez
 */
public class Codeforces {
    private static HttpURLConnection connection ;
    private static final String cf_api = "https://codeforces.com/api/"; // common part of the URL
    private static StringBuffer content  ;
    private static BufferedReader reader ;
    private static String line ;
    
    public Codeforces() { // constructor
        
    }
    
    public String get(String request) throws Exception{    // method to send HTTP Request
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
                // receiving the JSON data
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream())) ;
                while((line = reader.readLine()) != null){
                    content.append(line) ;
                }
                reader.close() ;
            }
            
        } catch (Exception e) {
            // if anything goes wrong
            throw e ;
        }
        
        return content.toString() ;
    }
    
    // returns the list of contests held so far || gym = false
    public CFContest[] getContestList() throws Exception{
        String str = this.get("contest.list?gym=false") ;
        JSONObject ob = new JSONObject(str) ;
        
        if(!(ob.getString("status")).equals("OK"))
            throw new Exception() ;
        
        JSONArray ar = ob.getJSONArray("result") ;
        
        CFContest ret[] = new CFContest[ar.length()] ;
        
        for(int i = 0 ; i < ar.length() ; i++){
            ret[i] = new CFContest(ar.getJSONObject(i)) ;
        }
        
        return ret ;
    }
    // returns the reference to a CFContest object 
    public CFContest findContestById(CFContest[] contestList, int id) throws Exception{
        // cant' use binary search. contestList may not be sorted according to contestId
        for (int i = 0 ; i < contestList.length ; i++){
            if(contestList[i].getId()==id)
                return contestList[i];
        }
        throw new Exception();
    }
}
