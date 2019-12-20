/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andrew.textadventure.Areas;

import com.andrew.textadventure.Creatures.Creature;
import com.andrew.textadventure.Player.Player;
import com.andrew.textadventure.Helpers.Choice;
import com.andrew.textadventure.Helpers.Gesture;
import com.andrew.textadventure.Helpers.PlayerInputHelper;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Andrew Wright
 */
public class GameArea extends Area implements IArea
{
    ArrayList<Gesture> gestures;
    private boolean hasWon =false;

    public GameArea() 
    {
        super();
        this.openingLine = "Welcome to the game area Player, you must play and win rock, paper sissors in order to proceed \n Please make your choice now:";
        
        gestures = new ArrayList<>();
        gestures.add( new Gesture("Rock",new ArrayList<>(Arrays.asList("Paper"))));
        gestures.add( new Gesture("Paper",new ArrayList<>(Arrays.asList("sissors"))));
        gestures.add( new Gesture("sissors",new ArrayList<>(Arrays.asList("Rock"))));
    }
    
    
    @Override
    public ArrayList<Choice> getAreaChoices() 
    {
        ArrayList<Choice> choices = new ArrayList<>();
        if(hasWon)
        {
            choices = super.getGenericChoices();
        }
        
        else
        {
            try
            {
                
                for(Gesture gesture: gestures)
                {
                    choices.add(new Choice (gesture ,Player.class.getMethod("play"),false));
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        
        
        return PlayerInputHelper.assignLetter(choices);
        
    }

    @Override
    public boolean canEnter(Player player) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getOpeningLine() {
        return this.openingLine;
    }

    @Override
    public String toString() {
        return "GameArea{" + '}';
    }

    public ArrayList<Gesture> getGestures() {
        return gestures;
    }

    public boolean hasWon() {
        return hasWon;
    }

    public void setHasWon(boolean hasWon) {
        this.hasWon = hasWon;
    }
    
    
    
    
    
}
