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

/**
 *
 * @author Andrew Wright
 */
public class Player extends Creature
{
    private Creature enemy;
    private IArea currentArea;
    private IArea[][] map;
    
    
    private ArrayList<Choice> choices;
    private boolean key;
    private int gameSize;
    
    private int xPosition = 0;
    private int yPosition = 0;

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
        PlayerInputHelper.getOption(currentArea.getOpeningLine(), choices).getSelectionLetter();
        move(xPosition,Direction.DOWN);
            
    } 

    
    private void move(int coord, enum direction)
    {
        switch(direction) 
        {
            case Direction.RIGHT:
                if(coord>0 && coord<gameSize)
                {
                    xPosition -=1;
                    currentArea = map[xPosition][yPosition];
                    PlayerInputHelper.getOption(currentArea.getOpeningLine(), choices).getSelectionLetter();
                }
                else
                    cannot();
                break;
            case Direction.LEFT:
                if(coord>0 && coord<gameSize)
                {
                    xPosition +=1;
                    currentArea = map[xPosition][yPosition];
                    PlayerInputHelper.getOption(currentArea.getOpeningLine(), choices).getSelectionLetter();
                }
                else
                    cannot();
                break;
            case Direction.UP:
                // code block
                break;
            case Direction.DOWN:
                // code block
                break;
            default:
                cannot();
                break;
          }
        

    }
    
    private void cannot()
    {
        System.out.println("You may not move in that direction");
            PlayerInputHelper.getOption(currentArea.getOpeningLine(), choices).getSelectionLetter();
    }

    
}
