/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.model.dto;

import com.game.interfaces.Observer;
import com.game.services.ServidorService;

/**
 *
 * @author fleon
 */
public class UsuarioDTO implements Observer {

    public static final int ESTADO_LIBRE = 1;
    public static final int ESTADO_COMBATIENDO = 2;
    
    private static final String LIBRE = "LIBRE";
    private static final String COMBATIENDO = "COMBATIENDO";
    private static final String DESCONOCIDO = "DESCONOCIDO";

    private long id;
    private final String nickname;
    private int puntos = 0;
    private int estado = ESTADO_LIBRE;

    public UsuarioDTO(String nickname) {
        if(nickname != null) {
            nickname = nickname.trim().toUpperCase();
        }
        this.nickname = nickname;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @return the puntos
     */
    public int getPuntos() {
        return puntos;
    }

    /**
     * @param puntos the puntos to set
     */
    public void agregarPuntos(int puntos) {
        this.puntos += puntos;
    }

    /**
     * @return the estado
     */
    public int getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return nickname;
    }

    @Override
    public boolean equals(Object otro) {
        if (otro == null) {
            return false;
        }
        if (!(otro instanceof UsuarioDTO)) {
            return false;
        }
        UsuarioDTO aux = (UsuarioDTO) otro;
        return (nickname != null && nickname.equalsIgnoreCase(aux.getNickname()));
    }

    @Override
    public void update(ServidorService servidorService) {
        System.out.println(servidorService.getEstado());
    }

    public static String getEstadoDesdeId(int id) {
        switch (id) {
            case ESTADO_LIBRE:
                return LIBRE;
            case ESTADO_COMBATIENDO:
                return COMBATIENDO;
            default:
                return DESCONOCIDO;
        }
    }
}
