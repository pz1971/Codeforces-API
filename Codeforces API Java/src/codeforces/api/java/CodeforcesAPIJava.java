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
public class CodeforcesAPIJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CFUser pz = new CFUser("pz1971") ;
        if(pz.isOk())
            System.out.println(pz.toString());
        else 
            System.out.println("Something went wrong");
    }
    
}
