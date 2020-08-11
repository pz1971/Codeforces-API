/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeforcesAPI;

import CodeforcesAPI.CFSubmission.verdictType;
import CodeforcesAPI.CFSubmission.testsetType;
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
    private CFRatingChange ratingChanges[];
    private int submissionCount, passedCount, failedCount ;
    private int participationCount ;
    private boolean submissionsLoaded, ratingChangesLoaded ;
    
    public CFUser(String handle) throws InitializationFailedException{  // the constructor
        submissionsLoaded = false ; // initially submissions of a user is not loaded.
        ratingChangesLoaded = false; // initially rating changes of a user is not loaded.
        
        String content ;
        try{
            content = new Codeforces().get("user.info?handles=" + handle) ;// receiving content
        }catch(Exception e){
            throw new InitializationFailedException() ;
        }
        
        // converting the content data into JSONObject
        JSONObject ob = new JSONObject(content) ;
        // The status of request... OK if successful.
        String stat = ob.getString("status");
        if(!stat.equals("OK")){  // something went wrong
            throw new InitializationFailedException() ;
        }
        
        // initialization of JSONArray
        JSONArray ar = ob.getJSONArray("result");
        // The 0th index of the array contains the Data of first user.
        // We are only interested in retrieving data of a single user.
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
    
    public CFUser(JSONObject ob){  // another constructor
        submissionsLoaded = false ; // initially submissions of a user is not loaded.
        ratingChangesLoaded = false; // initially rating changes of a user is not loaded.
        
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
    
    //
    // member methods
    //
    
    public boolean areSubmissionsLoaded(){ // returns if the subbmissions are loaded or not
        return submissionsLoaded ;
    }
    
    public boolean areRatingChangesLoaded(){ // returns if the rating changes are loaded or not
        return ratingChangesLoaded ;
    }
    
    public void loadSubmissions() throws InitializationFailedException {    // loads all the submissions of a user
        try{
            String content = new Codeforces().get("user.status?handle=" + handle) ;
            JSONObject ob = new JSONObject(content) ;
            String stat = ob.getString("status");
        
            if(!stat.equals("OK")){  // something went wrong
                throw new InitializationFailedException() ;
            }
            // CFSubmission array in JSON format
            JSONArray ar = ob.getJSONArray("result");
            submissionCount = ar.length() ;
            passedCount = 0;
            failedCount = 0 ;
            submissions = new CFSubmission[ar.length()] ;
            
            // converting JSON objects into CFSubmission objects
            for(int i = 0 ; i < ar.length() ; i++){
                submissions[i] = new CFSubmission( ar.getJSONObject(i) ) ;
                if(submissions[i].getVerdict() == verdictType.OK)
                    passedCount++ ;
                else
                    failedCount++ ;
            }
            
            submissionsLoaded = true ;
        }catch (Exception e){   // if failed
            throw new InitializationFailedException() ;
        }
    }
    
    public void loadRatingChanges() throws InitializationFailedException{
        try{
            String content = new Codeforces().get("user.rating?handle=" + handle) ;
            JSONObject ob = new JSONObject(content) ;
            String stat = ob.getString("status");
        
            if(!stat.equals("OK")){  // something went wrong
                throw new InitializationFailedException() ;
            }
            
            // CFRatingChange array in JSON format
            JSONArray ar = ob.getJSONArray("result");
            participationCount = ar.length();
            ratingChanges = new CFRatingChange[ar.length()] ;
            
            // converting JSON objects into CFRatingChange objects
            for(int i = 0 ; i < ar.length() ; i++){
                ratingChanges[i] = new CFRatingChange( ar.getJSONObject(i) ) ;
            }
            
            ratingChangesLoaded = true ;
        }catch (Exception e){
            throw new InitializationFailedException();
        }
    }
    
    //
    // Getter Methods
    //
    
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

    public CFRatingChange[] getRatingChanges() {
        return ratingChanges;
    }

    public int getParticipationCount() {
        return participationCount;
    }
}
