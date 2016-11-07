/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.interfaces;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author agustin
 */
public interface Subject {
    
    List<Observer> OBSERVERS = new ArrayList<>();

    void addObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();
}
