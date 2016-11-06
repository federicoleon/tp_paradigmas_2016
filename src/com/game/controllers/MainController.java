/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.controllers;

import com.game.model.Conexion;
import com.game.model.dto.UsuarioDTO;
import com.game.views.Menu;

/**
 *
 * @author fleon
 */
public class MainController {
    
    public void startApplication() {
        
        Menu view = new Menu();
        view.setVisible(true);
    }
}
