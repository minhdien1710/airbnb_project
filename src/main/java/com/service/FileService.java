package com.service;

import com.model.File;

public interface FileService {
    void save(File file);
    Iterable<File> findAllByHomeId(Long id);

}
