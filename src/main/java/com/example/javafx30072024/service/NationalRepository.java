package com.example.javafx30072024.service;

import com.example.javafx30072024.dto.PlayerDTO;
import com.example.javafx30072024.entity.National;

import java.util.List;

public interface NationalRepository {
    void save(String name);
    void delete(Long nationalId);
}
