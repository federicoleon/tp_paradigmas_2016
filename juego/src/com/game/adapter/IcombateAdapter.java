/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.adapter;

import com.game.model.dto.UsuarioDTO;
import org.ues21.ppoo.modelo.SimulaCombate;

/**
 *
 * @author Alexia
 */
public class IcombateAdapter {

    public static final int PUNTOS_GANADOS = 2;

    public static UsuarioDTO combate(UsuarioDTO usuario1, UsuarioDTO usuario2) {
        int resultado = SimulaCombate.combate(usuario1.getNickname(), usuario2.getNickname());
        if (resultado < 0) {
            usuario1.agregarPuntos(PUNTOS_GANADOS);
            return usuario1;
        } else if(resultado > 0) {
            usuario2.agregarPuntos(PUNTOS_GANADOS);
            return usuario2;
        }else{
            return null;
        }
    }

}
