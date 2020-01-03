/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andrew.textadventure.Areas;

import com.andrew.textadventure.Helpers.Choice;
import com.andrew.textadventure.Helpers.PlayerInputHelper;
import com.andrew.textadventure.Player.Player;
import java.util.ArrayList;

/**
 *
 * @author Andrew Wright
 */
public class RiddleArea extends Area implements IArea, Cloneable
{
    private Choice correctChoice;
    private boolean complete;

    public RiddleArea() 
    {
        super();
        try
        {
            this.correctChoice = new Choice("The letter G",Player.class.getMethod("handleRiddle"),false);
            this.complete = false;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            correctChoice = new Choice();
        }
        
        this.openingLine = colours.getPurple()+"Welcome to the Riddle area, hope you manage to solve it! \n" + colours.getReset() + "What always ends everything?";
    }
    @Override
    public boolean canEnter(Player player) {
        return true;
    }

    @Override
    public ArrayList<Choice> getAreaChoices() 
    {
        ArrayList<Choice> choices = new ArrayList<>();
        
        if(!complete)
        {
            try
            {
                choices.add(correctChoice);
                choices.add(new Choice("Nuclear War",Player.class.getMethod("handleRiddle"),false));
                choices.add(new Choice("Me",Player.class.getMethod("handleRiddle"),false));
                choices.add(new Choice("Calm conversation",Player.class.getMethod("handleRiddle"),false));
                choices = PlayerInputHelper.assignLetter(choices);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        
        else
        {
            return super.getGenericChoices();
        }
        
        
        return choices;
    }

    @Override
    public String getOpeningLine() {
        return this.openingLine;
    }

    public Choice getCorrectChoice() {
        return correctChoice;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
    
}
