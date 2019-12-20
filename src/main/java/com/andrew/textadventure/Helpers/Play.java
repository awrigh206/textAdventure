/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andrew.textadventure.Helpers;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import javafx.scene.control.Label;

/**
 *
 * @author Andrew Wright
 */
public class Play 
{
    private final Gesture userGesture;
    private Gesture computerGesture;
    private ArrayList<Gesture> possibleGestures;
    
    public Play(Gesture userChoice, ArrayList<Gesture> gestures)
    {
        this.userGesture = userChoice;
        this.possibleGestures = gestures;
        selectGesture();
    }
    
    public void selectGesture()
    {
        int number = ThreadLocalRandom.current().nextInt(0, possibleGestures.size());
        computerGesture = possibleGestures.get(number);
    }
    
    public String result()
    {
        String text="";

        
        for (String current: userGesture.getBeatenBy())
        {
            if(current.equalsIgnoreCase(computerGesture.getName()))
            {
                //lose condition
                text= "Lose!";
            }
        }
        
        for (String current: computerGesture.getBeatenBy())
        {
            if (current.equalsIgnoreCase(userGesture.getName()))
            {
                //Win condition 
                text="Win!";
            }
        }
        
        if (text.isEmpty())
        {
            //draw condition
            text="Draw!";
        }
        

        return text;
    }

    public Gesture getComputerGesture() {
        return computerGesture;
    }
    
    
}
