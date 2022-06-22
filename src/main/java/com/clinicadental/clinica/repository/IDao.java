package com.clinicadental.clinica.repository;

import java.util.List;

public interface IDao<T>{
    T registrar(T t);
    T buscarPorId(int id);
    boolean eliminarPorId(int id);
    T modificar(T t);
    List<T> buscarTodos();
}
