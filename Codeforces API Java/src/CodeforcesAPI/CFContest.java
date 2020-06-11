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
    public enum contestType{ // scoring system
        CF, IOI, ICPC
    }

    public enum contestPhase{
        BEFORE, CODING, PENDING_SYSTEM_TEST, SYSTEM_TEST, FINISHED
    }
    
    private int id ;
    private String name ;
    private long durationdurationSeconds, startTimeSeconds, relativeTimeSeconds ;
    private String preparedBy, websiteUrl;
    private contestType type ;
    private contestPhase phase ;
    
    // constructor
    public CFContest(JSONObject ob){
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
        
        type = ob.getEnum(contestType.class, "type") ;
        phase = ob.getEnum(contestPhase.class, "phase") ;
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

    public contestType getType() {
        return type;
    }

    public contestPhase getPhase() {
        return phase;
    }
    
    @Override
    public String toString(){
        return name ;
    }
}
