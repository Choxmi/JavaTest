/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_structure;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Choxmi
 */
public class PalindromeStack {
    static String output = "";
    static LinkedList li = new LinkedList();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
    	//Get Input text
    	System.out.print("Enter Text Here : ");
    	String text = input.nextLine();
        String orig  = text;
        
        text = text.toLowerCase();
        
        //Remove Spaces and punctuations
        text = text.replaceAll(" ", "");
        text = text.replaceAll(",", "");
        
        char[] characters = text.toCharArray();
        
        for(int i = 0;i< characters.length;i++){
            li.push(characters[i]);
        }
        
        while(!li.isEmpty()){
            pop();
        }
        
        if(output.equals(text)){
            System.out.println(orig + " is a Palindrome");
        }else{
            System.out.println(orig + " is not a Palindrome");
        }
        
    }
    
    private static void pop(){
        output += (char)li.getFirst();
        li.removeFirst();
    }
    
}
