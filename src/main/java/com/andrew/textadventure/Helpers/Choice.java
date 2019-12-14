/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andrew.textadventure.Helpers;

/**
 *
 * @author Andrew Wright
 */
public class Choice 
{
    private String description;
    private char selectionLetter;

    public Choice() {
    }

    public Choice(String description) {
        this.description = description;
    }
 
    public String getDescription() {
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
        return  "description=" + description + ", selectionLetter=" + selectionLetter;
    }
    
}
