/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andrew.textadventure.Creatures;

import com.andrew.textadventure.Areas.GameArea;
import com.andrew.textadventure.Helpers.Choice;
import com.andrew.textadventure.Helpers.MapGenerator;
import java.util.ArrayList;
import com.andrew.textadventure.Areas.IArea;
import com.andrew.textadventure.Helpers.Colours;
import com.andrew.textadventure.Helpers.Gesture;
import com.andrew.textadventure.Helpers.Play;
import com.andrew.textadventure.Helpers.PlayerInputHelper;
import java.lang.reflect.Method;

/**
 *
 * @author Andrew Wright
 */
public class Player extends Creature
{
    Colours colours;
    Play play;

    private Creature enemy;
    private IArea currentArea;
    private final IArea[][] map;
    
    
    private ArrayList<Choice> choices;
    private boolean key;
    private final int gameSize;
    
    private static int xPosition = 0;
    private static int yPosition = 0;
    
    private Choice choice;
    private PlayerMover mover;

    public Player(ArrayList<IArea> availableAreaTypes, int gameSize) 
    {
        this.gameSize = gameSize;
        MapGenerator generator = new MapGenerator(availableAreaTypes);
        this.map = generator.generateMap(gameSize,gameSize);
        this.colours = new Colours();
        
        this.health=20;
        this.mover = new PlayerMover(this);

    }
    
    public boolean hasKey() {
        return key;
    }

    public void setKey(boolean key) {
        this.key = key;
    }
    
    public void run()
    {
        //update global variables to change what the user sees for as the area may have changed
        this.currentArea = map[xPosition][yPosition];
        this.choices = currentArea.getAreaChoices();
        this.enemy = currentArea.getEnemy();
        
        Choice option = PlayerInputHelper.getOption(currentArea.getOpeningLine(), choices);
        choice = option;
        
        try
        {
            Method action = option.getAction();
            if(option.isMovement())
            {
                currentArea = (IArea)action.invoke(mover,option.getDirection());
                run();
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
    
    public void play()
    {
        GameArea area = (GameArea)currentArea;
        
        play = new Play((Gesture)choice.getDescription(),area.getGestures());
        System.out.println(play.result());
        
        if(play.result().equals("Draw!") || play.result().equals("Lose!"))
            run();
        else
        {
            area.setHasWon(true);
            run();
        }
    }

    public static int getxPosition() {
        return xPosition;
    }

    public static void setxPosition(int xPosition) {
        Player.xPosition = xPosition;
    }

    public static int getyPosition() {
        return yPosition;
    }

    public static void setyPosition(int yPosition) {
        Player.yPosition = yPosition;
    }

    public int getGameSize() {
        return gameSize;
    }

    public IArea[][] getMap() {
        return map;
    }
    
    public void notImplementedYet()
    {
        
    }
    
    public void quit()
    {
        System.exit(0);
    }
    
    
    
    
    
}
