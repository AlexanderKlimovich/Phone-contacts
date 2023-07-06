package com.example.klymovych.contactsBook.service.Impl;

import com.example.klymovych.contactsBook.exception.NullEntityReferenceException;
import com.example.klymovych.contactsBook.model.Phone;
import com.example.klymovych.contactsBook.repository.PhoneRepository;
import com.example.klymovych.contactsBook.service.PhoneService;
import javax.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class PhoneServiceImpl implements PhoneService {
    private final PhoneRepository phoneRepository;

    @Override
    public Phone create(Phone phone) {
        if (phone != null) {
            Phone phoneFromDb = phoneRepository.findByPhoneNumber(phone.getPhoneNumber());
                if (phoneFromDb == null) {
                    log.info("Creating phone: {}", phone);
                    return phoneRepository.save(phone);
                } else {
                    log.info("Return phone from db");
                    return phoneFromDb;
                }
        }
        throw new NullEntityReferenceException("Phone cannot be 'null'");
    }

    @Override
    public Phone readById(long id) {
        log.info("Fetching phone by id: {}", id);
        return phoneRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Phone with id " + id + " not found"));
    }

    @Override
    public Phone update(Phone phone) {
        if (phone != null) {
            log.info("Updating phone: {}", phone);
            readById(phone.getId());
            return phoneRepository.save(phone);
        }
        throw new NullEntityReferenceException("Phone cannot be 'null'");
    }

    @Override
    public void delete(long id) {
        log.info("Deleting phone by id: {}", id);
        Phone phone = readById(id);
        phoneRepository.delete(phone);
    }

    @Override
    public List<Phone> getAll() {
        log.info("Fetching all phones");
        return phoneRepository.findAll();
    }

}
