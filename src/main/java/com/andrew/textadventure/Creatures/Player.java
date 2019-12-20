/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andrew.textadventure.Creatures;

import com.andrew.textadventure.Helpers.Choice;
import com.andrew.textadventure.Helpers.MapGenerator;
import java.util.ArrayList;
import com.andrew.textadventure.Areas.IArea;
import com.andrew.textadventure.Helpers.Colours;
import com.andrew.textadventure.Helpers.PlayerInputHelper;
import java.lang.reflect.Method;

/**
 *
 * @author Andrew Wright
 */
public class Player extends Creature
{
    Colours colours;

    private Creature enemy;
    private IArea currentArea;
    private final IArea[][] map;
    
    
    private ArrayList<Choice> choices;
    private boolean key;
    private final int gameSize;
    
    private static int xPosition = 0;
    private static int yPosition = 0;

    public Player(ArrayList<IArea> availableAreaTypes, int gameSize) 
    {
        this.gameSize = gameSize;
        MapGenerator generator = new MapGenerator(availableAreaTypes);
        this.map = generator.generateMap(gameSize,gameSize);
        this.currentArea = map[xPosition][yPosition];
        choices = currentArea.getAreaChoices();
        this.enemy = currentArea.getEnemy();
        this.colours = new Colours();
        
        this.health=20;

    }
    
    public boolean hasKey() {
        return key;
    }

    public void setKey(boolean key) {
        this.key = key;
    }
    
    public void run()
    {
        Choice option = PlayerInputHelper.getOption(currentArea.getOpeningLine(), choices);
        
        try
        {
            Method action = option.getAction();
            if(option.isMovement())
            {
                action.invoke(this,option.getDirection());
            }
            
            else if (!option.isMovement())
            {
                action.invoke(this);
            }
            
            else
            {
                System.out.println(option.toString());
            }
        }
        
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
            
    } 

    
    public void moveX( int direction)
    {
        xPosition =move(direction,xPosition);
        currentArea = map[xPosition][yPosition];
        run();
    }
    
    public void moveY(int direction)
    {
        yPosition =move(direction,yPosition);
        currentArea = map[xPosition][yPosition];
        run();
    }
    
    public int move(int direction, int axis)
    {
        int limit = yPosition + direction;
        System.out.println("direction: " +direction+"axis: " +axis);
        if((axis+direction)>=0 && !((gameSize-1) <= limit))
        {
            axis += direction;
            return axis;
        }
        
        else
        {
            cannot();
            return 0;
        }
            
    }
    
    private void cannot()
    {
        System.err.println(colours.getRed()+"You may not move in that direction"+colours.getReset());
        run();
    }
    
    public void notImplementedYet()
    {
        
    }
    
    public void fight ()
    {
        try
        {
            System.out.println("You have chosen to fight the: " + enemy.getName());
            System.out.println("The:" +enemy.getName()+" has "+ enemy.getHealth() +" health points");

            ArrayList<Choice> choices = new ArrayList<>();
            choices.add(new Choice("Attack!!",Player.class.getMethod("attack"),false));
            choices.add(new Choice("Defend",Player.class.getMethod("defend"),false));
            choices.add(new Choice("Run away",Player.class.getMethod("runAway"),false));

            choices = PlayerInputHelper.assignLetter(choices);
            Choice option = PlayerInputHelper.getOption("What would you like to do next?", choices);
            
            option.getAction().invoke(this);
        }
        
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
    }
    
    private void aiMove()
    {
        // This will be expanded at a later date to make the AI do more than just attack once each turn
        System.out.println("The " +enemy.getName() +" moves fowards to attack you!!!");
        takeDamage();
        System.out.println("You now have: " + health +" health points");
    }
    
    public void attack()
    {
        aiMove();
        if(enemy.getHealth()>1)
        {
            enemy.takeDamage();
            fight();
        }
            
        else
        {
            System.out.println("The " + enemy.getName() +" Lies dead");
            run();
        }
            

    }

    public void defend()
    {
         System.out.println("You block the " + enemy.getName()+"'s vicous assualt, but what now?");
         fight();
    }
    
    public void runAway()
    {
        run();
    }
    
}
