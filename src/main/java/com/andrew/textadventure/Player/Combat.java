/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andrew.textadventure.Player;

import com.andrew.textadventure.Creatures.Creature;
import com.andrew.textadventure.Helpers.Choice;
import com.andrew.textadventure.Helpers.PlayerInputHelper;
import java.util.ArrayList;

/**
 *
 * @author Andrew Wright
 */
public class Combat 
{
    private final Player player;
    private final Creature enemy;

    public Combat(Player player) {
        this.player = player;
        this.enemy = player.getEnemy();
    }
    
    public void fight ()
    {
        try
        {
            System.out.println("You have chosen to fight the: " + enemy.getName());
            System.out.println("The:" +enemy.getName()+" has "+ enemy.getHealth() +" health points");

            ArrayList<Choice> choices = new ArrayList<>();
            choices.add(new Choice("Attack!!",Combat.class.getMethod("attack"),false));
            choices.add(new Choice("Defend",Combat.class.getMethod("defend"),false));
            choices.add(new Choice("Run away",Combat.class.getMethod("runAway"),false));

            choices = PlayerInputHelper.assignLetter(choices);
            Choice option = PlayerInputHelper.getOption("What would you like to do next?", choices);
            
            option.getAction().invoke(this);
        }
        
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
    }
    
    public void defend()
    {
         System.out.println("You block the " +enemy.getName()+"'s vicous assualt, but what now?");
         fight();
    }
    
    private void aiMove()
    {
        // This will be expanded at a later date to make the AI do more than just attack once each turn
        System.out.println("The " +enemy.getName() +" moves fowards to attack you!!!");
        player.takeDamage();
        System.out.println("You now have: " + player.getHealth() +" health points");
    }
    
    public void attack()
    {
        aiMove();
        if(enemy.getHealth()>1)
        {
            enemy.takeDamage();
            fight();
        }
            
        else
        {
            System.out.println("The " + enemy.getName() +" Lies dead");
            player.run();
        }
    }
    
    public void runAway()
    {
        player.run();
    }
}
