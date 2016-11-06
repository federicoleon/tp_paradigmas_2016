/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.interfaces;

import com.game.model.dto.UsuarioDTO;

/**
 *
 * @author Alexia
 */
public interface IcombateInterface {

    public void setUsuario1(UsuarioDTO usuario1);

    public void setUsuario2(UsuarioDTO usuario2);

    public UsuarioDTO getUsuario1();

    public UsuarioDTO getUsuario2();

    public int getPtosUsuario1();

    public int getPtosUsuario2();

    public UsuarioDTO combate();

}
