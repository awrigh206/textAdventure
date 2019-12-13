/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andrew.textadventure.Areas;

import com.andrew.textadventure.Creatures.Creature;
import com.andrew.textadventure.Creatures.MagicFrog;
import com.andrew.textadventure.Creatures.Player;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Andrew Wright
 */
public class KeyArea implements Area
{ 
    private String openingLine;
    private Creature enemy;
    private ArrayList<Creature> possibleCreatures;

    public KeyArea() 
    {
        this.openingLine = "Hello and welcome to this previously locked area, take a look around Mr Player";
        possibleCreatures.add(new MagicFrog());
    }
    
    
    @Override
    public boolean canEnter(Player player)
    {
        if(player.hasKey())
            return true;
        else 
            return false;
    }

    @Override
    public String toString() {
        return "KeyArea{" + "openingLine=" + openingLine + '}';
    }

    @Override
    public Creature getEnemy() 
    {
        return enemy;
    }

    @Override
    public void generateEnemy() 
    {
        Random rand = new Random();
        int number = rand.nextInt(1);
        if(number == 1)
        {
            enemy = chooseEnemy();
        }
    }
    
    private Creature chooseEnemy()
    {
        Random rand = new Random();
        int num = rand.nextInt(possibleCreatures.size());
        return possibleCreatures.get(num);
    }
    
    
}
