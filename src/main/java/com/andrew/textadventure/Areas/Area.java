/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andrew.textadventure.Areas;

import com.andrew.textadventure.Creatures.Creature;
import com.andrew.textadventure.Creatures.MagicFrog;
import com.andrew.textadventure.Helpers.Choice;
import com.andrew.textadventure.Helpers.PlayerInputHelper;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Andrew Wright
 */
public abstract class Area implements IArea
{
    protected Creature enemy;
    protected ArrayList<Creature> possibleCreatures;
    protected ArrayList<Choice> areaChoices;

    public Area() 
    {
        possibleCreatures = new ArrayList<>();
        possibleCreatures.add(new MagicFrog());
    }
    
    @Override
    public void generateEnemy() 
    {
        Random rand = new Random();
        int number = rand.nextInt(1);
        if(number == 1)
        {
            enemy = chooseEnemy();
        }
    }
    
    private Creature chooseEnemy()
    {
        Random rand = new Random();
        int num = rand.nextInt(possibleCreatures.size());
        return possibleCreatures.get(num);
    }
    
    protected ArrayList<Choice> getGenericChoices()
    {
        ArrayList<Choice> choices = new ArrayList<>();
        choices.add(new Choice("Go forwards"));
        choices.add(new Choice("Go backwards"));
        choices.add(new Choice("Go left"));
        choices.add(new Choice("Go right"));
        return PlayerInputHelper.assignLetter(choices);
    }
}
