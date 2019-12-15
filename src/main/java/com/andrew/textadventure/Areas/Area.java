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
        Class playerClass = Player.class;
        ArrayList<Choice> choices = new ArrayList<>();
        try
        {
            Choice upwards = new Choice("Go upwards",playerClass.getMethod("moveY",int.class,int.class),true);
            upwards.setDirection(1);
            choices.add(upwards);
            
            Choice downwards = new Choice("Go downwards",playerClass.getMethod("moveY",int.class,int.class),true);
            downwards.setDirection(-1);
            choices.add(downwards);
            
            Choice left = new Choice("Go left",playerClass.getMethod("moveX",int.class,int.class),true);
            left.setDirection(-1);
            choices.add(left);
            
            Choice right = new Choice("Go right",playerClass.getMethod("moveX",int.class,int.class),true);
            right.setDirection(1);
            choices.add(right);
        }
        
        catch (NoSuchMethodException e)
        {
            e.printStackTrace();
        }
        
        return PlayerInputHelper.assignLetter(choices);
    }
}
