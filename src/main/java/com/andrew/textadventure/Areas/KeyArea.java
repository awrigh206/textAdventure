/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andrew.textadventure.Areas;

import com.andrew.textadventure.Creatures.Creature;
import com.andrew.textadventure.Creatures.Player;
import com.andrew.textadventure.Helpers.Choice;
import com.andrew.textadventure.Helpers.PlayerInputHelper;
import java.util.ArrayList;

/**
 *
 * @author Andrew Wright
 */
public class KeyArea extends Area implements IArea 
{ 
    private String openingLine;

    public KeyArea() 
    {
        super();
        this.openingLine = "Hello and welcome to this previously locked area, take a look around Mr Player";
    }
    
    @Override
    public boolean canEnter(Player player)
    {
        if(player.hasKey())
            return true;
        else 
            return false;
    }

    @Override
    public String toString() {
        return "KeyArea{" + "openingLine=" + openingLine + '}';
    }

    @Override
    public Creature getEnemy() 
    {
        return enemy;
    }

    @Override
    public ArrayList<Choice> getAreaChoices() 
    {
        ArrayList<Choice> choices = super.getGenericChoices();
        try
        {
            choices.add(new Choice ("Fight the dangerous beast" ,Player.class.getMethod("notImplementedYet"),false));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return PlayerInputHelper.assignLetter(choices);
        
    }

    public String getOpeningLine() {
        return openingLine;
    }
    
    
    
    
}
