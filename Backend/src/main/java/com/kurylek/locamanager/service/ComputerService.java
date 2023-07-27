package com.kurylek.locamanager.service;

import com.kurylek.locamanager.model.Computer;
import java.util.List;

public interface ComputerService {

    List<Computer> getAll();
    Computer getById(Long id);
    Computer create(Computer computer);
    Computer update(Computer computer);
    Boolean delete(Long id);
}
