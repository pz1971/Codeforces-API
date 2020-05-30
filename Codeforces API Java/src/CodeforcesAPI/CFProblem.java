/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeforcesAPI;

import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Parvez
 */
public class CFProblem {
    private int contestId, rating ;
    private String index, name, tags[];
    
    public CFProblem(JSONObject ob){
        if(ob.has("contestId"))
            contestId = ob.getInt("contestId") ;
        if(ob.has("rating"))
            rating = ob.getInt("rating") ;
        if(ob.has("index"))
            index = ob.getString("index") ;
        if(ob.has("name"))
            name = ob.getString("name") ;
        if(ob.has("tags")){
            JSONArray ar = ob.getJSONArray("tags");
            tags = new String[ar.length()] ;
            for(int i = 0 ; i < ar.length() ; i++){
                tags[i] = ar.getString(i) ;
            }
        }
    }
    
    @Override
    public String toString(){
        String ret = "Problem name : " + name;
        ret += "\nContestID : " + contestId ;
        ret += "\nIndex : " + index ;
        ret += "\nRating : " + rating ;
        ret += "\ntags :" + Arrays.toString(tags);
        return ret ;
    }

    public int getContestId() {
        return contestId;
    }

    public int getRating() {
        return rating;
    }

    public String getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public String[] getTags() {
        return tags;
    }
}
