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
public class ServidorServices {
    
    private static ServidorServices servidor;
    private ArrayList <UsuarioDTO>usuarios;
    private ArrayList <ICombateDTO>combates;
    
    
    private ServidorServices(){
        
        usuarios = new ArrayList<UsuarioDTO>();
        combates = new ArrayList<ICombateDTO>();
        
    }
     
    
    public static ServidorServices getInstancia() {
        if(servidor == null) {
            servidor = new ServidorServices(); 
        }
        return servidor;
    }
    
    
    
}
