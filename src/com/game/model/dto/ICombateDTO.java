/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.model.dto;

import org.ues21.ppoo.modelo.SimulaCombate;

/**
 *
 * @author fleon
 */
public class  ICombateDTO {
    
    public static final int PUNTOS_GANADOS = 2;
    
    private final UsuarioDTO usuario1;
    private int ptosUsuario1;

    private final UsuarioDTO usuario2;
    private int ptosUsuario2;
    
    public ICombateDTO(UsuarioDTO usuario1, UsuarioDTO usuario2) {
        this.usuario1 = usuario1;
        this.usuario2 = usuario2;
    }
    
    public UsuarioDTO combate() {
        int resultado = SimulaCombate.combate(usuario1.getNickname(), usuario2.getNickname());
        if(resultado < 0) {
            this.ptosUsuario1 = PUNTOS_GANADOS;
            usuario1.agregarPuntos(PUNTOS_GANADOS);
            return usuario1;
        }else{
            this.ptosUsuario2 = PUNTOS_GANADOS;
            usuario2.agregarPuntos(PUNTOS_GANADOS);
            return usuario2;
        }
    }

    /**
     * @return the ptosUsuario1
     */
    public int getPtosUsuario1() {
        return ptosUsuario1;
    }

    /**
     * @param ptosUsuario1 the ptosUsuario1 to set
     */
    public void setPtosUsuario1(int ptosUsuario1) {
        this.ptosUsuario1 = ptosUsuario1;
    }

    /**
     * @return the ptosUsuario2
     */
    public int getPtosUsuario2() {
        return ptosUsuario2;
    }

    /**
     * @param ptosUsuario2 the ptosUsuario2 to set
     */
    public void setPtosUsuario2(int ptosUsuario2) {
        this.ptosUsuario2 = ptosUsuario2;
    }
}
