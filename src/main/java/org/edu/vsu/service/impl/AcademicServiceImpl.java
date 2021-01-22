package org.edu.vsu.service.impl;

import org.edu.vsu.dao.AcademicRepository;
import org.edu.vsu.entity.Academic;
import org.edu.vsu.service.AcademicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcademicServiceImpl implements AcademicService {

    @Autowired
    AcademicRepository academicRepository;

    @Override
    public Academic create(Academic entity) {
        return this.academicRepository.saveAndFlush(entity);
    }

    @Override
    public Academic get(Long id) {
        return this.academicRepository.getOne(id);
    }

    @Override
    public Academic update(Academic entity) {
        return this.academicRepository.saveAndFlush(entity);
    }

    @Override
    public void delete(Long id) {
        this.academicRepository.deleteById(id);
    }

    @Override
    public List<Academic> getAll() {
        return this.academicRepository.findAll();
    }
}
