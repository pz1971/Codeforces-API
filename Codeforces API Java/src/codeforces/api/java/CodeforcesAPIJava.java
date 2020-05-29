/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codeforces.api.java;

import org.json.JSONObject;

/**
 *
 * @author Parvez
 */
public class CodeforcesAPIJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CFUser pz ; 
        try{
            pz = new CFUser("pz1971") ;   
            System.out.println(pz.toString());
            System.out.println(pz.getSubmissionCount());
        }catch(InitializationFailedException e){
            e.printStackTrace();
        }
    }
    
}
