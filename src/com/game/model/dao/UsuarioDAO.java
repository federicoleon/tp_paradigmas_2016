/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.model.dao;

import com.game.interfaces.ABMInterface.;
import com.game.model.Conexion;
import com.game.model.dto.UsuarioDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author fleon
 */
public class UsuarioDAO implements ABMInterface<UsuarioDTO>{
    
    @Override
    public UsuarioDTO Guardar(UsuarioDTO object) {
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO usuario(nickname, puntos, estado) VALUES(");
        query.append("'").append(object.getNickname()).append("'").append(", ");
        query.append(object.getPuntos()).append(", ");
        query.append(object.getEstado());
        query.append(");");
        try {
            Connection conn = Conexion.getInstancia().getConexion();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query.toString(),Statement.RETURN_GENERATED_KEYS);
            
            ResultSet rs= stmt.getGeneratedKeys();
            rs.first();
           
            object.setId(rs.getInt(1));
           
        } catch(Exception e) {
            System.out.println(e);
        }
        return object;
    }

    @Override
    public UsuarioDTO Actualizar(UsuarioDTO object) {
       StringBuilder query = new StringBuilder();
       query.append("Update usuario set puntos=");
       query.append(object.getPuntos());
       query.append(" ").append("where id=").append(object.getId());
       
       try {
            Connection conn = Conexion.getInstancia().getConexion();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query.toString());
        } catch(Exception e) {
            System.out.println(e);
        }
       return object;
    }

    @Override
    public UsuarioDTO Leer(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UsuarioDTO LeerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Borrar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList<UsuarioDTO> getTop10() {
        ArrayList<UsuarioDTO> resultado = new ArrayList<>();
        StringBuilder query = new StringBuilder();
        query.append("SELECT nickname, puntos FROM usuario ");
        query.append("ORDER BY puntos ASC LIMIT 10;");
        try {
            Connection conn = Conexion.getInstancia().getConexion();
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(query.toString());
            while(res.next()) {
                String nickname = res.getString("nickname");
                int puntos = res.getInt("puntos");
                UsuarioDTO usuario = new UsuarioDTO(nickname);
                usuario.agregarPuntos(puntos);
                resultado.add(usuario);
            }
            
        } catch(Exception e) {}
        return resultado;
    }
}
