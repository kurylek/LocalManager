package com.kurylek.locamanager.service.implementation;

import com.kurylek.locamanager.model.Computer;
import com.kurylek.locamanager.repository.ComputerRepository;
import com.kurylek.locamanager.service.ComputerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ComputerServiceImpl implements ComputerService {
    private final ComputerRepository computerRepository;

    @Override
    public List<Computer> getAll() {
        log.info("Fetching all computers");
        return computerRepository.findAll();
    }

    @Override
    public Computer getById(Long id) {
        log.info("Fetching computer by id: {}", id);
        return computerRepository.getReferenceById(id);
    }

    @Override
    public Computer create(Computer computer) {
        log.info("Adding new computer: {}", computer.getSerialNumber());
        return computerRepository.save(computer);
    }

    @Override
    public Computer update(Computer computer) {
        log.info("Updating  computer: {}", computer.getSerialNumber());
        return computerRepository.save(computer);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Deleting computer by id: {}", id);
        computerRepository.deleteById(id);
        return true;
    }
}
