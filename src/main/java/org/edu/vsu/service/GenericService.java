package org.edu.vsu.service;

import java.util.List;

public interface GenericService<T, N> {
    T create(T entity);
    T get(N id);
    T update(T entity);
    void delete(N id);
    List<T> getAll();
}
