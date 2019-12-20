/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andrew.textadventure.Player;

import com.andrew.textadventure.Areas.IArea;
import com.andrew.textadventure.Helpers.Colours;

/**
 *
 * @author Andrew Wright
 */
public class PlayerMover 
{
    private final IArea[][] map;
    private final Player player;
    private final Colours colours;

    public PlayerMover(Player player) 
    {
        this.map = player.getMap();
        this.player = player;
        this.colours = new Colours();
    }
    
    
    public IArea moveX( int direction)
    {
        Player.setxPosition(move(direction,Player.getxPosition()));
        return map[Player.getxPosition()][Player.getyPosition()];
    }
    
    public IArea moveY(int direction)
    {
        Player.setyPosition(move(direction,Player.getyPosition()));
        return map[Player.getxPosition()][Player.getyPosition()];
    }
    
    public int move(int direction, int axis)
    {
        int limit = axis + direction;
        System.out.println("direction: " +direction+"axis: " +axis);
        if((axis+direction)>=0 && !((player.getGameSize()-1) <= limit))
        {
            axis += direction;
            return axis;
        }
        
        else
        {
            cannot();
            return 0;
        }
            
    }
    
    private void cannot()
    {
        System.err.println(colours.getRed()+"You may not move in that direction"+colours.getReset());
    }
}
