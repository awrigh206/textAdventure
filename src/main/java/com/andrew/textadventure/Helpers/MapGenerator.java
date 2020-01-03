/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andrew.textadventure.Helpers;

import java.util.ArrayList;
import java.util.Random;
import com.andrew.textadventure.Areas.IArea;

/**
 *
 * @author Andrew Wright
 */
public class MapGenerator 
{
    public ArrayList<IArea> typeOfArea;
    private int width;
    private int height;
    private IArea[][] map;

    public MapGenerator(ArrayList<IArea> typeOfArea) {
        this.typeOfArea = typeOfArea;
    }
    
    public IArea[][] generateMap(int width, int height)
    {
        this.width = width;
        this.height = height;
        
        IArea[][] map = new IArea[width][height];
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
    
    private IArea selectType()
    {
        Random random = new Random();
        int number = random.nextInt(typeOfArea.size());
        return (IArea)typeOfArea.get(number).clone();
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
