/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andrew.textadventure.Creatures;

import com.andrew.textadventure.Areas.Area;
import com.andrew.textadventure.Helpers.Choice;
import com.andrew.textadventure.Helpers.MapGenerator;
import java.util.ArrayList;

/**
 *
 * @author Andrew Wright
 */
public class Player extends Creature
{
    private Creature enemy;
    private Area currentArea;
    private Area[][] map;
    
    
    private ArrayList<Choice> choices;
    private boolean key;

    public Player(ArrayList<Area> availableAreaTypes, int gameSize) 
    {
        MapGenerator generator = new MapGenerator(availableAreaTypes);
        this.map = generator.generateMap(gameSize,gameSize);
        this.currentArea = map[0][0];
    }
    
    public boolean hasKey() {
        return key;
    }

    public void setKey(boolean key) {
        this.key = key;
    }
    
    
}
