/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.controllers;

import com.game.model.dto.ICombateDTO;
import com.game.model.dto.UsuarioDTO;
import com.game.services.ServidorService;
import com.game.views.Menu;
import javax.swing.JFrame;
import com.game.interfaces.Observer;
import java.util.List;

/**
 *
 * @author fleon
 */
public class MainController {

    private static MainController instancia;

    private MainController() {
    }

    public static MainController getInstancia() {
        if (instancia == null) {
            instancia = new MainController();
        }
        return instancia;
    }

    public static final String DEFAULT_LOOK_AND_FEEL = "Nimbus";

    public void startApplication() {
        Menu view = new Menu();
        view.setExtendedState(JFrame.MAXIMIZED_BOTH);
        view.setVisible(true);
    }

    public UsuarioDTO guardarUsuario(String nickname) {
        if (nickname == null) {
            return null;
        }
        nickname = nickname.toUpperCase().trim();
        if ("".equals(nickname)) {
            return null;
        }
        return ServidorService.getInstancia().loguearUsuario(nickname);
    }
    
    public UsuarioDTO cerrarSesion(String nickname) {
       return ServidorService.getInstancia().cerrarSesion(nickname);
    }
    
//    public ArrayList<UsuarioDTO> getUsuariosLogueados() {
//        //return ServidorService.getInstancia().getUsuariosLogueados();
//    }
    
    //prueba metodo de arriba
        public List<Observer> getUsuariosLogueados() {
        return ServidorService.getInstancia().getObservadoresLogueados();
    }
    
    public ICombateDTO simularCombate() {
        ICombateDTO combate = ServidorService.getInstancia().simularCombate();
        return combate;
    }
    
    public UsuarioDTO buscarXnickName(String nombre){
       return ServidorService.getInstancia().buscarUsuario(nombre);
        
    }
}
