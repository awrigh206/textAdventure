/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andrew.textadventure.Areas;

import com.andrew.textadventure.Creatures.Creature;
import com.andrew.textadventure.Creatures.MagicFrog;
import com.andrew.textadventure.Creatures.Player;
import com.andrew.textadventure.Creatures.PlayerMover;
import com.andrew.textadventure.Helpers.Choice;
import com.andrew.textadventure.Helpers.Colours;
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
    protected Colours colours;
    protected String openingLine;

    public Area() 
    {
        colours = new Colours();
        possibleCreatures = new ArrayList<>();
        possibleCreatures.add(new MagicFrog());
        generateEnemy();
    }
    
    @Override
    public void generateEnemy() 
    {
        Random rand = new Random();
        int number = rand.nextInt(1);
        if(1 == 1)  //chnage this at a later date to give the ability to have some areas with no enemys
        {
            this.enemy = chooseEnemy();
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
        Class playerClass = PlayerMover.class;
        ArrayList<Choice> choices = new ArrayList<>();
        try
        {
            Choice upwards = new Choice("Go upwards",playerClass.getMethod("moveY",int.class),true);
            upwards.setDirection(1);
            choices.add(upwards);
            
            Choice downwards = new Choice("Go downwards",playerClass.getMethod("moveY",int.class),true);
            downwards.setDirection(-1);
            choices.add(downwards);
            
            Choice left = new Choice("Go left",playerClass.getMethod("moveX",int.class),true);
            left.setDirection(-1);
            choices.add(left);
            
            Choice right = new Choice("Go right",playerClass.getMethod("moveX",int.class),true);
            right.setDirection(1);
            choices.add(right);
            
            Choice quit = new Choice("Quit the game",Player.class.getMethod("quit"),false);
        }
        
        catch (NoSuchMethodException e)
        {
            e.printStackTrace();
        }
        
        return PlayerInputHelper.assignLetter(choices);
    }

    public Creature getEnemy() {
        return enemy;
    }
}
