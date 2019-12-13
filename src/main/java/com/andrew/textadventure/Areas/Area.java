/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andrew.textadventure.Areas;

import com.andrew.textadventure.Creatures.Creature;
import com.andrew.textadventure.Creatures.Player;

/**
 *
 * @author Andrew Wright
 */
public interface Area 
{
    public boolean canEnter(Player player);
    public void generateEnemy();
    public Creature getEnemy();
    public String toString();
}
