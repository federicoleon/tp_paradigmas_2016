/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.main;

import com.game.controllers.MainController;
import com.game.model.dao.ICombateDAO;
import com.game.model.dao.UsuarioDAO;
import com.game.model.dto.ICombateDTO;
import com.game.model.dto.UsuarioDTO;

/**
 *
 * @author fleon
 */
public class Main {
    
    public static void main(String[] args) {
        MainController mainController = new MainController();
        //mainController.startApplication();
        
        UsuarioDTO diego = new UsuarioDTO("Diego");
        UsuarioDTO marcos = new UsuarioDTO("Marcos");
        
        UsuarioDAO dao = new UsuarioDAO();
        
        UsuarioDTO diegoGuardado = dao.Guardar(diego);
        UsuarioDTO marcosGuardado = dao.Guardar(marcos);
        
        for(int i=0; i<10; i++)
        {
            ICombateDTO combate = new ICombateDTO(diego, marcos);
        
        System.out.println("Puntos de Diego: " + diego.getPuntos());
        System.out.println("Puntos de Marcos: " + marcos.getPuntos());
        
        System.out.println("Ganador: " + combate.combate());
        
        System.out.println("Puntos de Diego: " + diego.getPuntos());
        System.out.println("Puntos de Marcos: " + marcos.getPuntos());
        
        dao.Actualizar(diego);
        dao.Actualizar(marcos);

        }
        
        
    }
}
