/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codeforces.api.java;

/**
 *
 * @author Parvez
 */
public class InitializationFailedException extends Exception {
    public InitializationFailedException(){
        
    }
    @Override
    public void printStackTrace(){
        System.out.println("Couldn't initialize object.");
    }
    @Override
    public String toString(){
        return "Couldn't initialize object." ;
    }
}
