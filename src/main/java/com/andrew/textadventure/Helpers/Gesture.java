/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andrew.textadventure.Helpers;

import java.util.ArrayList;

/**
 *
 * @author Andrew Wright
 */
public class Gesture 
{
    private String name;
    private ArrayList<String> beatenBy;

    public Gesture(String name, ArrayList<String> beatenBy) {
        this.name = name;
        this.beatenBy = beatenBy;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getBeatenBy() {
        return beatenBy;
    }

    public void setBeatenBy(ArrayList<String> beatenBy) {
        this.beatenBy = beatenBy;
    }

    @Override
    public String toString() {
        return "Name:" + name;
    }   
    
    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Gesture)) {
            return false;
        }

        Gesture gesture = (Gesture) o;

        return gesture.name.equals(name);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        return result;
    }
    
    
    
    
}
