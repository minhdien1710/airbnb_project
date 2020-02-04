package com.security.service.impl;

import com.model.TypeHome;
import com.repository.TypeHomeRepository;
import com.security.service.TypeHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeHomeServiceImpl implements TypeHomeService {
    @Autowired
    TypeHomeRepository typeHomeRepository;
    @Override
    public List<TypeHome> findAll() {
        return typeHomeRepository.findAll();
    }

    @Override
    public Optional<TypeHome> findById(Long id) {
        return typeHomeRepository.findById(id);
    }

    @Override
    public TypeHome save(TypeHome typeHome) {
        return typeHomeRepository.save(typeHome);
    }

    @Override
    public void delete(Long id) {
        typeHomeRepository.deleteById(id);
    }
}
