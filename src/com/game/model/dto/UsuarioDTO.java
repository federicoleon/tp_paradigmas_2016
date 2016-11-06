/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.model.dto;

/**
 *
 * @author fleon
 */
public class UsuarioDTO {
    
    public static final int ESTADO_LIBRE = 1;
    public static final int ESTADO_COMBATIENDO = 2;
    
    
    private long id;
    private final String nickname;
    private int puntos;
    private int estado = ESTADO_LIBRE;
    
    public UsuarioDTO(String nickname) {
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
}
