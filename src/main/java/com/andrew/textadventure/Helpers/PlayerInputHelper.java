/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andrew.textadventure.Helpers;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Andrew Wright
 */
public class PlayerInputHelper 
{
    //This class will deal with player input via the console
    
    public static Choice getOption(String instruction, ArrayList<Choice> choices)
    {
        //display the avilable options to the user and take in the input from the keyboard
        System.out.println(instruction);
        for (Choice choice: choices)
        {
            System.out.println(choice.getSelectionLetter() +" : " + choice.getDescription() );
        }
        
        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();
        
        if(filterInput(text,choices))
        {
            return matchChoice(choices, text);
        }
        
        else
        {
            return getOption("Please enter only a single character related to you preferred option", choices);
        }
    }
    
    private static Choice matchChoice(ArrayList<Choice> choices, String input)
    {
        Choice matchingChoice = new Choice();
        for (Choice choice: choices)
        {
            if(choice.getSelectionLetter()==  input.charAt(0))
            {
                matchingChoice = choice;
            }
        }
        return matchingChoice;
    }
    
    private static boolean filterInput(String input, ArrayList<Choice> choices)
    {
        if(input.length()>1 || input.length()<1)
        {
            return false;
        }
        
        boolean matchesAChoice = false;
        for(Choice choice : choices)
        {
            if(choice.getSelectionLetter() == input.charAt(0))
            {
                matchesAChoice = true;
            }
        }
        
        if(matchesAChoice)
            return true;
        else 
            return false;
    }
    
    public static ArrayList<Choice> assignLetter(ArrayList<Choice> choices)
    {
        for (int i =0; i<choices.size(); i++) 
        {
            choices.get(i).setSelectionLetter((char)(i+65));
        }
        return choices;
    }
}
