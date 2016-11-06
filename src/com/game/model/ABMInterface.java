/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.model;

/**
 *
 * @author fleon
 * @param <T>
 */
public interface ABMInterface<T> {
    
    public T Guardar(T object);
    public T Actualizar(T object);
    public T Leer(int id);
    public T LeerTodos();
    public boolean Borrar(int id);
}
