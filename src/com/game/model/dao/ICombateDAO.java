/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.model.dao;

import com.game.interfaces.ABMInterface;
import com.game.model.Conexion;
import com.game.model.dto.ICombateDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author fleon
 */
public class ICombateDAO implements ABMInterface<ICombateDTO>{

    @Override
    public ICombateDTO Guardar(ICombateDTO object) {
        StringBuilder q = new StringBuilder();
        q.append("INSERT INTO combate ");
        q.append("(usuario1, ptosUsuario1, usuario2, ptosUsuario2) ");
        q.append("VALUES(");
        q.append("'").append(object.getUsuario1().getNickname()).append("', ");
        q.append(object.getPtosUsuario1()).append(", ");
        q.append("'").append(object.getUsuario2().getNickname()).append("', ");
        q.append(object.getPtosUsuario2());
        q.append(");");
        try {
            Connection conn = Conexion.getInstancia().getConexion();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(q.toString());
        } catch(Exception e) {
            System.err.println("Ocurrió un error al tratar de guardar el combate.");
            System.err.println(e);
        }
        return object;
    }

    @Override
    public ICombateDTO Actualizar(ICombateDTO object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ICombateDTO Leer(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ICombateDTO LeerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Borrar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
