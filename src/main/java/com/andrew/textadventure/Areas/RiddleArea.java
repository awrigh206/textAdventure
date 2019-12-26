/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andrew.textadventure.Areas;

import com.andrew.textadventure.Helpers.Choice;
import com.andrew.textadventure.Player.Player;
import java.util.ArrayList;

/**
 *
 * @author Andrew Wright
 */
public class RiddleArea extends Area implements IArea 
{

    public RiddleArea() 
    {
        super();
        this.openingLine = colours.getPurple()+"Welcome to the Riddle area, hope you manage to solve it!" + colours.getReset();
    }
    @Override
    public boolean canEnter(Player player) {
        return true;
    }

    @Override
    public ArrayList<Choice> getAreaChoices() {
        return super.getGenericChoices();
    }

    @Override
    public String getOpeningLine() {
        return this.openingLine;
    }
    
}
