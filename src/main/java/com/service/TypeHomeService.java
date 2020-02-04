package com.service;

import com.model.TypeHome;

import java.util.List;
import java.util.Optional;

public interface TypeHomeService {
    List<TypeHome> findAll();
    Optional<TypeHome> findById(Long id);
    TypeHome save(TypeHome typeHome);
    void delete(Long id);

}
