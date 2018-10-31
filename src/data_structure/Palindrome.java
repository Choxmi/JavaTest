/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_structure;

import java.util.Scanner;

/**
 *
 * @author Choxmi
 */
public class Palindrome {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
    	//Get Input text
    	System.out.print("Enter Text: ");
    	String text = input.nextLine();
        String orig  = text;
        
        text = text.toLowerCase();
        
        //Remove Spaces and punctuations
        text = text.replaceAll(" ", "");
        text = text.replaceAll(",", "");
        
        char[] characters = text.toCharArray();
        int len = characters.length;
        
        boolean palindrome = true;
        
        for(int i = 0;i < (len/2);i++){
            System.out.println("Char id :"+characters[i]+" to "+characters[len - 1 - i]);
            if(characters[i] != characters[len - 1 - i]){
                palindrome = false;
                break;
            }
        }
        
        if(!palindrome){
            System.out.println(orig + " is not a Palindrome");
        }else{
            System.out.println(orig + " is a Palindrome");
        }
        
    }
    
}
