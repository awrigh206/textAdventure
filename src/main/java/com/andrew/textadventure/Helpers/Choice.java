/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andrew.textadventure.Helpers;

import java.lang.reflect.Method;

/**
 *
 * @author Andrew Wright
 */
public class Choice 
{
    private Object description;
    private char selectionLetter;
    private Method action;
    private boolean isMovement = false;
    private Object invokeOn;
    
    private int direction;

    public Choice() {
    }

    public Choice(Object description, Method action, boolean isMovement) {
        this.description = description;
        this.action = action;
        this.isMovement = isMovement;
    }
 
    public Object getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public char getSelectionLetter() {
        return selectionLetter;
    }

    public void setSelectionLetter(char selectionLetter) {
        this.selectionLetter = selectionLetter;
    }

    @Override
    public String toString() {
        return  "description=" + description + ", selectionLetter=" + selectionLetter +", isMovement="+isMovement;
    }

    public Method getAction() {
        return action;
    }

    public void setAction(Method action) {
        this.action = action;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public boolean isMovement() {
        return isMovement;
    }

    public Object getInvokeOn() {
        return invokeOn;
    }

    public void setInvokeOn(Object invokeOn) {
        this.invokeOn = invokeOn;
    }
    
    
    
    
    
}
