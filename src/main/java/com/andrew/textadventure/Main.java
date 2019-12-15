/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andrew.textadventure;

import com.andrew.textadventure.Areas.IArea;
import com.andrew.textadventure.Areas.KeyArea;
import com.andrew.textadventure.Creatures.Player;
import java.util.ArrayList;

/**
 *
 * @author Andrew Wright 
 */
public class Main 
{
    private static ArrayList<IArea> availableAreas;
    
    public static void main(String[] args)
    {
        addAreas();
        Player player = new Player(availableAreas,5);
        player.run();
    }
    
    private static void addAreas()
    {
        availableAreas = new ArrayList<>();
        availableAreas.add(new KeyArea());
    }
    
}
