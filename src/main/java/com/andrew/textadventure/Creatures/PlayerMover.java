/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andrew.textadventure.Creatures;

/**
 *
 * @author Andrew Wright
 */
public class PlayerMover 
{

    public PlayerMover() {
    }
    
    
    public void moveX( int direction)
    {
        Player.setxPosition(move(direction,Player.getxPosition()));
        currentArea = map[xPosition][yPosition];
        run();
    }
    
    public void moveY(int direction)
    {
        yPosition =move(direction,yPosition);
        currentArea = map[xPosition][yPosition];
        run();
    }
    
    public int move(int direction, int axis)
    {
        int limit = yPosition + direction;
        System.out.println("direction: " +direction+"axis: " +axis);
        if((axis+direction)>=0 && !((gameSize-1) <= limit))
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
        run();
    }
}
