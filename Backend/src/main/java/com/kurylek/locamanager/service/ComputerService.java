package com.kurylek.locamanager.service;

import com.kurylek.locamanager.model.Computer;
import java.util.List;

public interface ComputerService {

    List<Computer> getAll();
    Computer getById(Long id);
    Computer create(Computer printer);
    Computer update(Computer printer);
    Boolean delete(Long id);
}
