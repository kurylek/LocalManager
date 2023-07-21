package com.kurylek.locamanager.configuration;

import com.kurylek.locamanager.enums.Manufacturer;
import com.kurylek.locamanager.enums.PrinterType;
import com.kurylek.locamanager.model.Printer;
import com.kurylek.locamanager.repository.PrinterRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DataSeeding {
    private final PrinterRepository printerRepository;

    @PostConstruct
    void setUp() {
        printerRepository.save(new Printer(null, "10.3.10.1", "ABC123", "AAB#1", Manufacturer.HP, "Printer 1", PrinterType.COLOR));
        printerRepository.save(new Printer(null, "10.3.10.2", "ABC124", "AAB#1", Manufacturer.HP, "Printer 2", PrinterType.COLOR));
        printerRepository.save(new Printer(null, "10.3.10.3", "123ABC", "ABB#2", Manufacturer.KONICA_MINOLTA, "Printer 3", PrinterType.BLACK));
    }
}
