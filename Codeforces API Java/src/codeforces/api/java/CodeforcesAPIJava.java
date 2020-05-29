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
//        CFUser pz ; 
//        try{
//            pz = new CFUser("pz1971") ;   
//            System.out.println(pz.toString());
//        }catch(InitializationFailedException e){
//            e.printStackTrace();
//        }

        String str = "{\"contestId\":1360,\"index\":\"H\",\"name\":\"Binary Median\",\"type\":\"PROGRAMMING\",\"rating\":2100,\"tags\":[\"bitmasks\",\"brute force\",\"constructive algorithms\"]}" ;
        JSONObject ob = new JSONObject(str) ;
        CFProblem prb = new CFProblem(ob) ;
        System.out.println(prb.toString());
    }
    
}
