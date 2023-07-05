package com.example.klymovych.contactsBook.service.Impl;

import com.example.klymovych.contactsBook.exception.NullEntityReferenceException;
import com.example.klymovych.contactsBook.repository.UserRepository;
import com.example.klymovych.contactsBook.service.UserService;
import com.example.klymovych.contactsBook.model.User;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User create(User user) {
        if (user != null) {
            log.info("Creating user: {}", user);
            return userRepository.save(user);
        }
        throw new NullEntityReferenceException("User cannot be 'null'");
    }

    @Override
    public User readById(long id) {
        log.info("Fetching user by id: {}", id);
        return userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("User with id " + id + " not found"));
    }

    @Override
    public User update(User user) {
        if (user != null) {
            log.info("Updating user: {}", user);
            readById(user.getId());
            return userRepository.save(user);
        }
        throw new NullEntityReferenceException("User cannot be 'null'");
    }

    @Override
    public void delete(long id) {
        log.info("Deleting user by id: {}", id);
        User user = readById(id);
        userRepository.delete(user);
    }

    @Override
    public List<User> getAll() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }
}
