/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.services;

import java.util.ArrayList;
import com.game.model.dto.*;

/**
 *
 * @author Joaquin
 */
public class ServidorService {
    
    private static ServidorService servidor;
    private final ArrayList <UsuarioDTO> usuarios;
    private final ArrayList <ICombateDTO> combates;
    
    private ServidorService(){
        usuarios = new ArrayList<>();
        combates = new ArrayList<>();
    }
     
    public static ServidorService getInstancia() {
        if(servidor == null) {
            servidor = new ServidorService(); 
        }
        return servidor;
    }
}
