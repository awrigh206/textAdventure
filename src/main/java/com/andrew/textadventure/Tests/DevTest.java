/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andrew.textadventure.Tests;

import com.andrew.textadventure.Areas.KeyArea;
import com.andrew.textadventure.Helpers.Choice;
import com.andrew.textadventure.Helpers.MapGenerator;
import com.andrew.textadventure.Helpers.PlayerInputHelper;
import java.util.ArrayList;
import com.andrew.textadventure.Areas.IArea;

/**
 *
 * @author Andrew Wright
 */
public class DevTest implements Test
{
    private ArrayList<Choice> choices = new ArrayList<>();
    private ArrayList<IArea> areas = new ArrayList<>();

    @Override
    public void test() 
    {
        //test the player input system
//        choices.add(new Choice("Go forwards"));
//        choices.add(new Choice("Go backwards"));
//        choices.add(new Choice("Go left"));
//        choices.add(new Choice("Go right"));
        choices = PlayerInputHelper.assignLetter(choices);
        
        System.out.println("The choice that you chose was: " + PlayerInputHelper.getOption("Please enter what you would like to do: ", choices));
    }
    
    public void testMapGeneration()
    {
        areas.add(new KeyArea());
        MapGenerator generator = new MapGenerator(areas);
        IArea[][] map = generator.generateMap(2, 2);
        System.out.println(generator.toString());
    }
}
