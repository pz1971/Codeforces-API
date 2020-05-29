/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codeforces.api.java;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Parvez
 */
public class CFUser {
    private String handle, firstName, lastName, rank, maxRank ;
    private int rating, maxRating ;
    private int contribution, friendOfCount ;
    private String country, city, organization ;
    private String titlePhoto, avatar ;
    private CFSubmission submissions[] ;
    private int submissionCount, passedCount, failedCount ;
    
    public CFUser(String handle) throws InitializationFailedException{
        String content ;
        try{
            content = new Codeforces().get("user.info?handles=" + handle) ;
        }catch(Exception e){
            throw new InitializationFailedException() ;
        }
        
        
        JSONObject ob = new JSONObject(content) ;
        String stat = ob.getString("status");
        
        if(!stat.equals("OK")){  // something went wrong
            throw new InitializationFailedException() ;
        }
        
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
        
        try{
            content = new Codeforces().get("user.status?handle=" + handle) ;
            ob = new JSONObject(content) ;
            stat = ob.getString("status");
        
            if(!stat.equals("OK")){  // something went wrong
                throw new InitializationFailedException() ;
            }
            
            ar = ob.getJSONArray("result");
            submissionCount = ar.length() ;
            passedCount = 0;
            failedCount = 0 ;
            submissions = new CFSubmission[ar.length()] ;
            
            for(int i = 0 ; i < ar.length() ; i++){
                submissions[i] = new CFSubmission( ar.getJSONObject(i) ) ;
                if(submissions[i].getVerdict() == verdictType.OK)
                    passedCount++ ;
                else
                    failedCount++ ;
            }
            
        }catch (Exception e){
            throw new InitializationFailedException() ;
        }
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

    public CFSubmission[] getSubmissions() {
        return submissions;
    }

    public int getSubmissionCount() {
        return submissionCount;
    }

    public int getPassedCount() {
        return passedCount;
    }

    public int getFailedCount() {
        return failedCount;
    }
}
