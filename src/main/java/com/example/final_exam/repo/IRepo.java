package com.example.final_exam.repo;

import java.util.List;

public interface IRepo<T, ID> {
    List<T> findAll();

    T findByName(String name);

    void save(T data);

    void delete(ID id);

    void update(T data);
}
