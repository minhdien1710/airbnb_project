package com.security.service.impl;

import com.model.File;
import com.repository.FileRepository;
import com.security.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    FileRepository fileRepository;
    @Override
    public void save(File file) {
        fileRepository.save(file);
    }

    @Override
    public Iterable<File> findAllByHomeId(Long id) {
        return fileRepository.findAllByHomeId(id);
    }
}
