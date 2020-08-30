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

public class CFSubmission {

    private int id ;
    private long creationTimeSeconds, relativeTimeSeconds ;
    private CFProblem problem ;
    private String programmingLanguage ;
    private String verdict ;
    private String testset ;
    private int passedTestCount, timeConsumedMillis, memoryConsumedBytes ;
    
    public CFSubmission(JSONObject ob) throws InitializationFailedException{ // constructor
        try{
            id = ob.getInt("id");
            creationTimeSeconds = ob.getLong("creationTimeSeconds") ;
            relativeTimeSeconds = ob.getLong("relativeTimeSeconds") ;
            problem = new CFProblem(ob.getJSONObject("problem")) ;
            programmingLanguage = ob.getString("programmingLanguage");
            verdict = ob.getString("verdict");
            testset = ob.getString("testset");
            passedTestCount = ob.getInt("passedTestCount");
            timeConsumedMillis = ob.getInt("timeConsumedMillis");
            memoryConsumedBytes = ob.getInt("memoryConsumedBytes");
        }catch(Exception e){
            throw new InitializationFailedException() ;
        }
        
    }
    
    @Override
    public String toString(){
        String ret = "ID : " + id ;
        ret += "\nSubmission Time : " + creationTimeSeconds ;
        ret += "\nlang : " + programmingLanguage ;
        ret += "\nverdict : " + verdict.toString() ;
        ret += "\nmax time : " + timeConsumedMillis + "ms" ;
        ret += "\nmax memory : " + memoryConsumedBytes + "B" ;
        ret += "\nProblem info :\n" + problem.toString() ;
        return ret ;
    }

    public int getId() {
        return id;
    }

    public long getCreationTimeSeconds() {
        return creationTimeSeconds;//Unix format
    }

    public long getRelativeTimeSeconds() {
        return relativeTimeSeconds;
    }

    public CFProblem getProblem() {
        return problem;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public String getVerdict() {
//        FAILED, OK, PARTIAL, COMPILATION_ERROR,
//        RUNTIME_ERROR, WRONG_ANSWER, PRESENTATION_ERROR,
//        TIME_LIMIT_EXCEEDED, MEMORY_LIMIT_EXCEEDED,
//        IDLENESS_LIMIT_EXCEEDED, SECURITY_VIOLATED, CRASHED,
//        INPUT_PREPARATION_CRASHED, CHALLENGED, SKIPPED, TESTING, REJECTED
        return verdict;
    }

    public String getTestset() {
//        SAMPLES, PRETESTS, TESTS, CHALLENGES,
//        TESTS1, TESTS2, TESTS3, TESTS4, TESTS5, TESTS6,
//        TESTS7, TESTS8, TESTS9, TESTS10
        return testset;
    }

    public int getPassedTestCount() {
        return passedTestCount;
    }

    public int getTimeConsumedMillis() {
        return timeConsumedMillis;
    }

    public int getMemoryConsumedBytes() {
        return memoryConsumedBytes;
    }
}
