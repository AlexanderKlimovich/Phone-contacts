package com.example.klymovych.contactsBook.service.Impl;

import com.example.klymovych.contactsBook.exception.NullEntityReferenceException;
import com.example.klymovych.contactsBook.model.Role;
import com.example.klymovych.contactsBook.repository.RoleRepository;
import com.example.klymovych.contactsBook.service.RoleService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public Role create(Role role) {
        if (role != null) {
            log.info("Creating role: {}", role);
            return roleRepository.save(role);
        }
        throw new NullEntityReferenceException("Role cannot be 'null'");
    }

    @Override
    public Role readById(long id) {
        log.info("Fetching role by id: {}", id);
        return roleRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Role with id " + id + " not found"));
    }

    @Override
    public Role update(Role role) {
        if (role != null) {
            log.info("Updating role: {}", role);
            readById(role.getId());
            return roleRepository.save(role);
        }
        throw new NullEntityReferenceException("Role cannot be 'null'");
    }

    @Override
    public void delete(long id) {
        log.info("Deleting role by id: {}", id);
        Role role = readById(id);
        roleRepository.delete(role);
    }

    @Override
    public List<Role> getAll() {
        log.info("Fetching all roles");
        return roleRepository.findAll();
    }
}
