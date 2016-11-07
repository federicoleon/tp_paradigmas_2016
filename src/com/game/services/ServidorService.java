/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.services;

import com.game.model.dao.UsuarioDAO;
import com.game.interfaces.Observer;
import java.util.ArrayList;
import com.game.model.dto.*;
import com.game.interfaces.Subject;
import java.util.Iterator;
import java.util.List;

public class ServidorService implements Subject {
    
    private static ServidorService servidor;
    private final ArrayList <UsuarioDTO> usuarios;
    private final ArrayList <ICombateDTO> combates;
    //private final ArrayList <Observer> observers;
    
    private static final UsuarioDAO USUARIO_DAO = new UsuarioDAO();
    
    private ServidorService(){
        usuarios = new ArrayList<>();
        combates = new ArrayList<>();        
        //observers = new ArrayList<>();
    }
     
    public static ServidorService getInstancia() {
        if(servidor == null) {
            servidor = new ServidorService(); 
        }
        return servidor;
    }
    
    public ArrayList<UsuarioDTO> getTop10() {
        UsuarioDAO dao = new UsuarioDAO();
        return dao.getTop10();
    }
    
public List<Observer> getObservers(){
        return Subject.OBSERVERS;
        }
    public UsuarioDTO guardarUsuario(String nickname) {
        UsuarioDTO usuario = USUARIO_DAO.Leer(nickname);
        if(usuario != null) {
            System.out.println("El usuario ya existe!");
            return null;
        }
        usuario = new UsuarioDTO(nickname);
        usuario = USUARIO_DAO.Guardar(usuario);
        return usuario;
    }


    public void addObserver(java.util.Observer o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addObserver(Observer o) {
        getObservers().add(o);   
    }

    @Override
    public void removeObserver(Observer o) {
        Iterator it = getObservers().iterator();
        
        while(it.hasNext()){
            Observer obs = (Observer)it.next();
            if(obs.equals(o))
                it.remove();
        }
    }

    @Override
    public void notifyObservers() {
        for(Observer o: getObservers()){
            o.update(this);
        }
    }
}
