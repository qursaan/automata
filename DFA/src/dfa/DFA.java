/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfa;

import java.util.Scanner;

/**
 *
 * @author Pirate
 */
public class DFA {

    public static boolean BuildRecognizer(String someinput){
        
        String _table = "s:a:b\n"
                     +  "1:1:2\n"
                     +  "2:2:3\n"
                     +  "3:3:3\n";
        
        String _spliter = ":"; 
        
        String _accepted [] = {"3","1"};
        
        String _flatter  [] = _table.split("\n");
        
        String _inputs   [] = _flatter[0].split(_spliter);
        
        int n = _flatter.length -1; //No of States
        int m = _inputs.length;     //No of Inputes
        
        String _states [][] = new String[n][m];  //create state array
        
        for(int i=0;i<n;i++){
            System.arraycopy(_flatter[i+1].split(_spliter), 0, _states[i], 0, m);
        }

        String current_state = _states [0][0];
        
        System.out.println("Start State: " + current_state);
        
        for(int i=0;i<someinput.length();i++){
            for(int k=0; k<n; k++){ // look for current state
                
                if(current_state.equals(_states [k][0])){
                    for(int j=0;j<m;j++) { //look for next input
                        if(_inputs[j].equals(String.valueOf(someinput.charAt(i)))){
                            System.out.println("Input: " + someinput.charAt(i));
                            current_state = _states [k][j];
                            System.out.println("Next State: " + current_state);
                            
                            break; // match current input
                        }
                    }
                    break; // match current states
                }
            }
        }
        for (String _a : _accepted) {
            if (current_state.equals(_a)) {
                return true;
            }
        }
        return false;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner s = new Scanner(System.in);
        
        System.out.print("Your Input Test: ");
        
        String myinput = s.next();
        
        System.out.println(BuildRecognizer(myinput)?"Accepted":"Rejected");
    }
    
    
    
}
