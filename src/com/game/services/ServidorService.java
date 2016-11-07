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
import com.game.utils.NumerosUtils;

public class ServidorService implements Subject {

    private static ServidorService servidor;
    private final ArrayList<UsuarioDTO> usuarios;
    private final ArrayList<ICombateDTO> combates;
    private final ArrayList<Observer> observers;

    private static final UsuarioDAO USUARIO_DAO = new UsuarioDAO();

    private ServidorService() {
        usuarios = new ArrayList<>();
        combates = new ArrayList<>();
        observers = new ArrayList<>();
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

    @Override
    public void addObserver(java.util.Observer o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeObserver(java.util.Observer o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void notifyObservers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ICombateDTO simularCombate() {
        UsuarioDTO usuario1 = getAleatorio();
        UsuarioDTO usuario2 = getAleatorio();
        while(usuario2.equals(usuario1)) {
            usuario2 = getAleatorio();
        }
        ICombateDTO combate = new ICombateDTO(usuario1, usuario2);
        combate.combate();
        USUARIO_DAO.Actualizar(usuario1);
        USUARIO_DAO.Actualizar(usuario2);
        return combate;
    }

    private UsuarioDTO getAleatorio() {
        int i = NumerosUtils.getNumeroEntre(0, usuarios.size() - 1);
        return usuarios.get(i);
    }
}
