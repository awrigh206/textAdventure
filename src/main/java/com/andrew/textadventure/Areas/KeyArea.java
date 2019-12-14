/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andrew.textadventure.Areas;

import com.andrew.textadventure.Creatures.Creature;
import com.andrew.textadventure.Creatures.MagicFrog;
import com.andrew.textadventure.Creatures.Player;
import com.andrew.textadventure.Helpers.Choice;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Andrew Wright
 */
public class KeyArea extends Area implements IArea 
{ 
    private String openingLine;

    public KeyArea() 
    {
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
    public ArrayList<Choice> getAreaChoices() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
