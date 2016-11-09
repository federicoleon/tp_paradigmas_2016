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

    private final ArrayList<ICombateDTO> combates;

    public static final int SERVIDOR_LIBRE = 1;
    public static final int SERVIDOR_OCUPADO = 2;

    private static final String LIBRE = "LIBRE";
    private static final String OCUPADO = "OCUPADO";
    private static final String DESCONOCIDO = "DESCONOCIDO";

    private int estado = SERVIDOR_LIBRE;

    private static final UsuarioDAO USUARIO_DAO = new UsuarioDAO();
    private static final ICombateDAO COMBATE_DAO = new ICombateDAO();

    private ServidorService() {
        combates = new ArrayList<>();
    }

    public static ServidorService getInstancia() {
        if (servidor == null) {
            servidor = new ServidorService();
        }
        return servidor;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
        notifyObservers();
    }

    public static String getEstadoServer(int estado) {
        switch (estado) {
            case SERVIDOR_LIBRE:
                return LIBRE;
            case SERVIDOR_OCUPADO:
                return OCUPADO;
            default:
                return DESCONOCIDO;
        }
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
            addObserver(usuario);
            return usuario;
        }
        // El usuario no existe. Lo registro y agregamos a los usuarios logueados:
        usuario = new UsuarioDTO(nickname);
        usuario = USUARIO_DAO.Guardar(usuario);
        if (usuario == null) {
            System.err.println("Error al tratar de loguear al usuario.");
            return null;
        }
        addObserver(usuario);
        return usuario;
    }

    public UsuarioDTO cerrarSesion(String nickname) {
        UsuarioDTO usuario = USUARIO_DAO.Leer(nickname);
        removeObserver(usuario);
        return usuario;
    }

    public int getCantidadUsuariosLogueados() {
        return OBSERVERS.size();
    }

    public List<Observer> getObservadoresLogueados() {
        return OBSERVERS;
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
        System.out.println(getEstadoServer(this.getEstado()));
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
        setEstado(2);
        combate.combate();

        USUARIO_DAO.Actualizar(usuario1);
        USUARIO_DAO.Actualizar(usuario2);

        combates.add(combate);

        COMBATE_DAO.Guardar(combate);

        setEstado(1);
        return combate;
    }

    private UsuarioDTO getAleatorio() {
        UsuarioDTO usuario = null;
        do {
            int i = NumerosUtils.getNumeroEntre(0, OBSERVERS.size() - 1);
            try {
                usuario = (UsuarioDTO) OBSERVERS.get(i);
            } catch (Exception e) {
            }
        } while (usuario == null);
        return usuario;
    }

    public int getCantidadCombates() {
        return combates.size();
    }

    public UsuarioDTO buscarUsuario(String nickname) {
        return USUARIO_DAO.Leer(nickname);
    }
}
