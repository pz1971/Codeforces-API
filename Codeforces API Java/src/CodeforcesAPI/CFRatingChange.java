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
public class CFRatingChange {
    private int contestId;
    private String contestName, handle;
    private int rank;
    private long ratingUpdateTimeSeconds; // in Unix format
    private int oldRating, newRating;
    
    public CFRatingChange(JSONObject ob) throws InitializationFailedException{
        try{
            if(ob.has("contestId"))
                this.contestId = ob.getInt("contestId");
            if(ob.has("contestName"))
                this.contestName = ob.getString("contestName") ;
            if(ob.has("handle"))
                this.handle = ob.getString("handle") ;
            if(ob.has("rank"))
                this.rank = ob.getInt("rank") ;
            if(ob.has("ratingUpdateTimeSeconds"))
                this.ratingUpdateTimeSeconds = ob.getLong("ratingUpdateTimeSeconds");
            if(ob.has("oldRating"))
                this.oldRating = ob.getInt("oldRating");
            if(ob.has("newRating"))
                this.newRating = ob.getInt("newRating");    
        }catch(Exception e){
            throw new InitializationFailedException() ;
        }
        
    }
    
    // member methods
    @Override
    public String toString(){
        String ret = "contestId = " + contestId ;
        ret += "\ncontestName = " + contestName ;
        ret += "\nhandle = " + handle ;
        ret += "\nrank = " + rank ;
        ret += "\nratingUpdateTimeSeconds = " + ratingUpdateTimeSeconds ;
        ret += "\noldRating = " + oldRating ;
        ret += "\nnewRating = " + newRating ;
        return ret ;
    }
    
    // getter methods
    public int getContestId() {
        return contestId;
    }

    public String getContestName() {
        return contestName;
    }

    public String getHandle() {
        return handle;
    }

    public int getRank() {
        return rank;
    }

    public long getRatingUpdateTimeSeconds() { // UNIX format
        return ratingUpdateTimeSeconds;
    }

    public int getOldRating() {
        return oldRating;
    }

    public int getNewRating() {
        return newRating;
    }
    
    
}
