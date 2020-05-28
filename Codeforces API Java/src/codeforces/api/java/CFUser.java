/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codeforces.api.java;

import javafx.util.Pair;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Parvez
 */
public class CFUser {
    private boolean done ;
    private String handle, firstName, lastName, rank, maxRank ;
    private int rating, maxRating ;
    private int contribution, friendOfCount ;
    private String country, city, organization ;
    private String titlePhoto, avatar ;
    
    public CFUser(String handle){
        done = false ;
        Codeforces cf = new Codeforces() ;
        
        Pair<Boolean, String> content = cf.get("user.info?handles=" + handle) ;
        if(content.getKey() == false)   // something went wrong
            return ;
        
        JSONObject ob = new JSONObject(content.getValue()) ;
        String stat = ob.getString("status");
        if(!stat.equals("OK"))  // something went wrong
            return ;
        
        done = true ;
        JSONArray ar = ob.getJSONArray("result");
        ob = ar.getJSONObject(0) ;
        
        if(ob.has("handle"))
            this.handle = ob.getString("handle") ;
        if(ob.has("firstName"))
            firstName = ob.getString("firstName") ;
        if(ob.has("lastName"))
            lastName = ob.getString("lastName") ;
        if(ob.has("rank"))
            rank = ob.getString("rank") ;
        if(ob.has("maxRank"))
            maxRank = ob.getString("maxRank") ;
        
        if(ob.has("rating"))
            rating = ob.getInt("rating") ;
        if(ob.has("maxRating"))
            maxRating = ob.getInt("maxRating") ;
        
        if(ob.has("contribution"))
            contribution = ob.getInt("contribution") ;
        if(ob.has("friendOfCount"))
            friendOfCount = ob.getInt("friendOfCount") ;
        
        if(ob.has("country"))
            country = ob.getString("country") ;
        if(ob.has("city"))
            city = ob.getString("city") ;
        if(ob.has("organization"))
            organization = ob.getString("organization") ;
        
        if(ob.has("titlePhoto"))
            titlePhoto = ob.getString("titlePhoto") ;
        if(ob.has("avatar"))
            avatar = ob.getString("avatar") ;
    }
    
    @Override
    public String toString(){
        String ret ;
        ret = "Handle : " + handle ;
        ret += "\nFirst name : " + firstName ;
        ret += "\nLast name : " + lastName ;
        ret += "\nRank : " + rank ;
        ret += "\nMax Rank : " + maxRank ;
        ret += "\nRating : " + rating ;
        ret += "\nMax Rating : " + maxRating ;
        ret += "\nCountry : " + country ;
        ret += "\nCity : " + city ;
        ret += "\nOrganization : " + organization ;
        ret += "\nContribution : " + contribution ;
        ret += "\nFriend of : " + friendOfCount + " People" ;
        ret += "\nTitle Photo : " + titlePhoto ;
        ret += "\nAvatar : " + avatar ;
        
        return ret;
    }
    public boolean isOk(){
        return done ;
    }
    
    public String getHandle() {
        return handle;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getRank() {
        return rank;
    }

    public String getMaxRank() {
        return maxRank;
    }

    public int getRating() {
        return rating;
    }

    public int getMaxRating() {
        return maxRating;
    }

    public int getContribution() {
        return contribution;
    }

    public int getFriendOfCount() {
        return friendOfCount;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getOrganization() {
        return organization;
    }

    public String getTitlePhoto() {
        return titlePhoto;
    }

    public String getAvatar() {
        return avatar;
    }
}
