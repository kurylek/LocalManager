package com.kurylek.locamanager.configuration;

import com.kurylek.locamanager.enums.Manufacturer;
import com.kurylek.locamanager.enums.PrinterType;
import com.kurylek.locamanager.model.Printer;
import com.kurylek.locamanager.repository.PrinterRepository;
import com.kurylek.locamanager.service.PrinterService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DataSeeding {
    private final PrinterService printerService;

    @PostConstruct
    void setUp() {
        printerService.create(new Printer(null, "127.0.0.1", "ABC123", "AAB#1", Manufacturer.HP, "Printer 1", PrinterType.COLOR));
        printerService.create(new Printer(null, "192.168.1.1", "ABC124", "AAB#1", Manufacturer.HP, "Printer 2", PrinterType.COLOR));
        printerService.create(new Printer(null, "10.3.10.3", "123ABC", "ABB#2", Manufacturer.KONICA_MINOLTA, "Printer 3", PrinterType.BLACK));
    }
}
