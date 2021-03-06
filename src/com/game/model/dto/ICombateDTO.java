/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.model.dto;

import com.game.interfaces.IcombateInterface;
import com.game.adapter.IcombateAdapter;

/**
 *
 * @author fleon
 */
public class ICombateDTO implements IcombateInterface {

    private UsuarioDTO usuario1;
    private int ptosUsuario1;

    private UsuarioDTO usuario2;
    private int ptosUsuario2;

    public ICombateDTO(UsuarioDTO usuario1, UsuarioDTO usuario2) {
        this.usuario1 = usuario1;
        this.usuario2 = usuario2;
    }

    @Override
    public void setUsuario1(UsuarioDTO usuario1) {
        this.usuario1 = usuario1;
    }

    @Override
    public void setUsuario2(UsuarioDTO usuario2) {
        this.usuario2 = usuario2;
    }

    @Override
    public UsuarioDTO getUsuario1() {
        return usuario1;
    }

    @Override
    public UsuarioDTO getUsuario2() {
        return usuario2;
    }

    @Override
    public int getPtosUsuario1() {
        return ptosUsuario1;
    }

    @Override
    public int getPtosUsuario2() {
        return ptosUsuario2;
    }

    @Override
    public UsuarioDTO combate() {
        usuario1.setEstado(UsuarioDTO.ESTADO_COMBATIENDO);
        usuario2.setEstado(UsuarioDTO.ESTADO_COMBATIENDO);
        
        UsuarioDTO ganador = IcombateAdapter.combate(usuario1, usuario2);
        if (ganador == null) {
            usuario1.setEstado(UsuarioDTO.ESTADO_LIBRE);
            usuario2.setEstado(UsuarioDTO.ESTADO_LIBRE);
            return null;
        }

        if (ganador.equals(usuario1)) {
            this.ptosUsuario1 = IcombateAdapter.PUNTOS_GANADOS;
        } else if (ganador.equals(usuario2)) {
            this.ptosUsuario2 = IcombateAdapter.PUNTOS_GANADOS;
        }

        usuario1.setEstado(UsuarioDTO.ESTADO_LIBRE);
        usuario2.setEstado(UsuarioDTO.ESTADO_LIBRE);
        return ganador;
    }

    public UsuarioDTO getGanador() {
        if (ptosUsuario1 > ptosUsuario2) {
            return usuario1;
        } else if (ptosUsuario2 > ptosUsuario1) {
            return usuario2;
        } else {
            return null;
        }
    }
}
