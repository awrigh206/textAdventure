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

    public Player(ArrayList<IArea> availableAreaTypes, int gameSize) 
    {
        MapGenerator generator = new MapGenerator(availableAreaTypes);
        this.map = generator.generateMap(gameSize,gameSize);
        this.currentArea = map[0][0];
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
        switch(PlayerInputHelper.getOption(currentArea.getOpeningLine(), choices).getSelectionLetter()) 
        {
            case 'a':
              // code block
              break;
            case 'b':
              // code block
              break;
            case 'c':
              // code block
              break;
            case 'd':
              // code block
              break;
            default:
              // code block
          }
    }
    
    
}
