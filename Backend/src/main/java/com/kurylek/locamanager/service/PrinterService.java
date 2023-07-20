package com.kurylek.locamanager.service;

import com.kurylek.locamanager.model.Printer;

import java.io.IOException;
import java.util.List;

public interface PrinterService {
    List<Printer> getAll();
    Printer getById(Long id);
    Printer ping(Long id) throws IOException;
    Printer create(Printer printer);
    Printer update(Printer printer);
    Boolean delete(Long id);
}
