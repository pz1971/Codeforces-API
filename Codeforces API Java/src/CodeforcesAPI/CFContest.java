/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeforcesAPI;

import org.json.JSONObject;

/**
 *
 * @author Parvez
 */


public class CFContest {
    
    private int id ;
    private String name ;
    private long durationdurationSeconds, startTimeSeconds, relativeTimeSeconds ;
    private String preparedBy, websiteUrl;
    private String type ;
    private String phase ;
    
    // constructor
    public CFContest(JSONObject ob) throws InitializationFailedException{
        try{
            id = ob.getInt("id");
            name = ob.getString("name");
            if(ob.has("durationdurationSeconds"))
                durationdurationSeconds = ob.getLong("durationdurationSeconds");
            if(ob.has("startTimeSeconds"))
                startTimeSeconds = ob.getLong("startTimeSeconds");
            if(ob.has("relativeTimeSeconds"))
                relativeTimeSeconds = ob.getLong("relativeTimeSeconds");
            if(ob.has("preparedBy"))
                preparedBy = ob.getString("preparedBy") ;
            if(ob.has("websiteUrl"))
                preparedBy = ob.getString("websiteUrl") ;

            type = ob.getString( "type") ;
            phase = ob.getString("phase") ;          
            
        }catch(Exception e){
            throw new InitializationFailedException();
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getDurationdurationSeconds() {
        return durationdurationSeconds;
    }

    public long getStartTimeSeconds() {
        return startTimeSeconds;
    }

    public long getRelativeTimeSeconds() {
        return relativeTimeSeconds;
    }

    public String getPreparedBy() {
        return preparedBy;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public String getType() {
        return type;//CF, IOI, ICPC
    }

    public String getPhase() {
        return phase;//BEFORE, CODING, PENDING_SYSTEM_TEST, SYSTEM_TEST, FINISHED
    }
    
    @Override
    public String toString(){
        return name ;
    }
}
