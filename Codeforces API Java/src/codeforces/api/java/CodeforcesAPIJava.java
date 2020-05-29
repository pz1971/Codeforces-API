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

        String str = "{\"id\":81331857,\"contestId\":1360,\"creationTimeSeconds\":1590352835,\"relativeTimeSeconds\":2147483647,\"problem\":{\"contestId\":1360,\"index\":\"H\",\"name\":\"Binary Median\",\"type\":\"PROGRAMMING\",\"rating\":2100,\"tags\":[\"bitmasks\",\"brute force\",\"constructive algorithms\"]},\"author\":{\"contestId\":1360,\"members\":[{\"handle\":\"pz1971\"}],\"participantType\":\"PRACTICE\",\"ghost\":false,\"startTimeSeconds\":1590327300},\"programmingLanguage\":\"GNU C++17\",\"verdict\":\"OK\",\"testset\":\"TESTS\",\"passedTestCount\":5,\"timeConsumedMillis\":15,\"memoryConsumedBytes\":102400}" ;
        JSONObject ob = new JSONObject(str) ;
        CFSubmission sub = new CFSubmission(ob) ;
        System.out.println(sub.toString());
    }
    
}
