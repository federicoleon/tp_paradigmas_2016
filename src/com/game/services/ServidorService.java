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
import com.game.model.dao.ICombateDAO;
import com.game.utils.NumerosUtils;
import java.util.Iterator;
import java.util.List;

public class ServidorService implements Subject {

    private static ServidorService servidor;
    private final ArrayList<UsuarioDTO> usuarios;
    private final ArrayList<ICombateDTO> combates;

    private static final UsuarioDAO USUARIO_DAO = new UsuarioDAO();
    private static final ICombateDAO COMBATE_DAO = new ICombateDAO();

    private ServidorService() {
        usuarios = new ArrayList<>();
        combates = new ArrayList<>();
    }

    public static ServidorService getInstancia() {
        if (servidor == null) {
            servidor = new ServidorService();
        }
        return servidor;
    }

    public ArrayList<UsuarioDTO> getTop10() {
        return USUARIO_DAO.getTop10();
    }

    public List<Observer> getObservers() {
        return Subject.OBSERVERS;
    }

    public UsuarioDTO loguearUsuario(String nickname) {
        UsuarioDTO usuario = USUARIO_DAO.Leer(nickname);
        if (usuario != null) {
            // El usuario ya existe. Lo agrego a los usuarios logueados:
            usuarios.add(usuario);
            return usuario;
        }
        // El usuario no existe. Lo registro y agregamos a los usuarios logueados:
        usuario = new UsuarioDTO(nickname);
        usuario = USUARIO_DAO.Guardar(usuario);
        if (usuario == null) {
            System.err.println("Error al tratar de loguear al usuario.");
            return null;
        }
        usuarios.add(usuario);
        return usuario;
    }

    public int getCantidadUsuariosLogueados() {
        return usuarios.size();
    }

    public ArrayList<UsuarioDTO> getUsuariosLogueados() {
        return usuarios;
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

        while (it.hasNext()) {
            Observer obs = (Observer) it.next();
            if (obs.equals(o)) {
                it.remove();
            }
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer o : getObservers()) {
            o.update(this);
        }
    }

    public ICombateDTO simularCombate() {
        UsuarioDTO usuario1 = getAleatorio();
        UsuarioDTO usuario2 = getAleatorio();
        while (usuario2.equals(usuario1)) {
            usuario2 = getAleatorio();
        }
        ICombateDTO combate = new ICombateDTO(usuario1, usuario2);
        combate.combate();
        
        USUARIO_DAO.Actualizar(usuario1);
        USUARIO_DAO.Actualizar(usuario2);

        combates.add(combate);
        
        COMBATE_DAO.Guardar(combate);
        
        return combate;
    }

    private UsuarioDTO getAleatorio() {
        UsuarioDTO usuario = null;
        do {
            int i = NumerosUtils.getNumeroEntre(0, usuarios.size() - 1);
            try {
                usuario = usuarios.get(i);
            } catch(Exception e) {}
        } while(usuario == null);
        return usuario;
    }

    public int getCantidadCombates() {
        return combates.size();
    }
    
    public UsuarioDTO buscarUsuario(String nickname){
        return USUARIO_DAO.Leer(nickname);
    }
}
