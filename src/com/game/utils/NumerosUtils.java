/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.utils;

import java.util.Random;

/**
 *
 * @author fleon
 */
public class NumerosUtils {
    
    public static int getNumeroEntre(int min, int max) {
        Random r = new Random();
        return r.nextInt(max - min) + min;
    }
}
