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
public class CFProblemStatistics {
    private int contestId;
    private String index;
    private int solveCount;
    
    // constructor collects data from JSON object
    public CFProblemStatistics(JSONObject ob) throws InitializationFailedException{
        try{
            if(ob.has("contestId"))
                this.contestId = ob.getInt("contestId");
            if(ob.has("index"))
                this.index = ob.getString("index");
            if(ob.has("solveCount"))
                this.solveCount = ob.getInt("solveCount");   
        }catch(Exception e){
            throw new InitializationFailedException() ;
        }
    }
    
    @Override
    public String toString(){
        String ret = "contestId = " + contestId ;
        ret += "\nindex = " + index ;
        ret += "\nsolveCount = " + solveCount ;
        return ret ;
    }

    public int getContestId() {
        return contestId;
    }

    public String getIndex() {
        return index;
    }

    public int getSolveCount() {
        return solveCount;
    }

}
