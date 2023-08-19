package org.jmresler.hr.aw.svcs.services;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

import org.jmresler.hr.aw.svcs.domain.Shift;
import org.jmresler.hr.aw.svcs.domain.repo.ShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ShiftService {

    @Autowired
    protected ShiftRepository repository;

    public Optional<Shift> getShiftById(final Short id) {
        log.debug("received id {} in {}#getShiftById", id, getClass().getName());
        return repository.findById(id);
    }

}
