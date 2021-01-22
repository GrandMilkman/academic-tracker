package org.edu.vsu.service.impl;

import org.edu.vsu.dao.RoleRepository;
import org.edu.vsu.entity.Role;
import org.edu.vsu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role create(Role entity) {
        return this.roleRepository.saveAndFlush(entity);
    }

    @Override
    public Role get(Long id) {
        return this.roleRepository.getOne(id);
    }

    @Override
    public Role update(Role entity) {
        return this.roleRepository.saveAndFlush(entity);
    }

    @Override
    public void delete(Long id) {
        this.roleRepository.deleteById(id);
    }

    @Override
    public List<Role> getAll() {
        return this.roleRepository.findAll();
    }
}
