package com.sda.claudiu.bookmanagement.repository;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<T> {
    Optional<T> findById(Integer id);

    Optional<T> findByTitle(String title);

    void create(T entity);

    void update(T entity);

    void delete(T entity);

    List<T> findAll();
}
