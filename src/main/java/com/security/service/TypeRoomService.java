package com.security.service;

import com.model.TypeRoom;

import java.util.List;
import java.util.Optional;

public interface TypeRoomService {
    List<TypeRoom> findAll();
    Optional<TypeRoom> findById(Long id);
    TypeRoom save(TypeRoom typeRoom);
    void delete(Long id);
}
