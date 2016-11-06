/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.controllers;

import com.game.model.dto.UsuarioDTO;
import com.game.services.ServidorService;
import com.game.views.MainView;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author fleon
 */
public class MainController {
    
    private ServidorService SERVIDOR_SERVICE = ServidorService.getInstancia();
    
    public void startApplication() {
        
        ArrayList<UsuarioDTO> top10 = SERVIDOR_SERVICE.getTop10();
        
        MainView view = new MainView();
        view.setExtendedState(JFrame.MAXIMIZED_BOTH);
        view.setVisible(true);
    }
}
