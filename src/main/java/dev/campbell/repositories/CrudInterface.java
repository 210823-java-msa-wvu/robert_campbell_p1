package dev.campbell.repositories;

import java.util.List;

public interface CrudInterface <T> {

    // Create
    T add(T t);

    // Read
    T getById(Integer id);

    // Update
    void update(T t);

    // Delete
    void delete(Integer id);

}
