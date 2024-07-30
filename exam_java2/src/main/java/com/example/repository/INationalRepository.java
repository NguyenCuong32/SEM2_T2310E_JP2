package com.example.repository;

import java.util.List;

import com.example.entity.National;

public interface INationalRepository {
    void save(National national);
    void delete(Integer nationalId);
    National findById(Integer nationalId);
    List<National> findAll();

}
