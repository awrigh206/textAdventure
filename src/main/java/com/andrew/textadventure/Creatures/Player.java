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
import com.andrew.textadventure.Helpers.PlayerInputHelper;
import java.lang.reflect.Method;

/**
 *
 * @author Andrew Wright
 */
public class Player extends Creature
{
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
            if(option.isMovement())
            {
                Method action = option.getAction();
                action.invoke(this,xPosition,option.getDirection());
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

    
    public void moveX(int coord, int direction)
    {
        if(coord+direction>=0 && !((gameSize-1) <= yPosition + coord))
        {
            //&& coord+direction<gameSize
            coord += (direction * 1);
            xPosition+= coord;
            currentArea = map[xPosition][yPosition];
            run();
        }
        else 
            cannot();
    }
    
    public void moveY(int coord, int direction)
    {
        System.out.println("game Size:" + gameSize+"calc comes to:"+ (yPosition + coord));
        if((yPosition+direction)>=0 && !((gameSize-1) <= yPosition + coord))
        {
            //gameSize<=(yPosition+direction) && 
            coord += (direction * 1);
            yPosition += coord;
            currentArea = map[xPosition][yPosition];
            run();
        }
        
        else
            cannot();
        System.out.println("coord:" +coord +"direction:"+direction +"game size:"+gameSize +"xPosition:" +xPosition+"yPosition:" + yPosition);
    }
    
    private void cannot()
    {
        System.err.println("You may not move in that direction");
        run();
    }
    
    public void notImplementedYet()
    {
        
    }

    
}
