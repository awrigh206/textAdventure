/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andrew.textadventure.Helpers;

import com.andrew.textadventure.Areas.Area;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Andrew Wright
 */
public class MapGenerator 
{
    public ArrayList<Area> typeOfArea;
    private int width;
    private int height;
    private Area[][] map;

    public MapGenerator(ArrayList<Area> typeOfArea) {
        this.typeOfArea = typeOfArea;
    }
    
    public Area[][] generateMap(int width, int height)
    {
        this.width = width;
        this.height = height;
        
        Area[][] map = new Area[width][height];
        for(int i =0; i<width; i++)
        {
            for(int j =0; j<height; j++)
            {
                map[i][j] = selectType();
            }
        }
        this.map = map;
        return map;
    }
    
    private Area selectType()
    {
        Random random = new Random();
        int number = random.nextInt(typeOfArea.size());
        return typeOfArea.get(number);
    }

    @Override
    public String toString() 
    {
        String output = "";
        for(int i =0; i<width; i++)
        {
            for(int j =0; j<height; j++)
            {
                output += map[i][j].toString();
            }
        }
        return output;
    }
    
    
}
