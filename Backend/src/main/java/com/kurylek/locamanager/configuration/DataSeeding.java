package com.kurylek.locamanager.configuration;

import com.kurylek.locamanager.enums.ComputerType;
import com.kurylek.locamanager.enums.Manufacturer;
import com.kurylek.locamanager.enums.PrinterType;
import com.kurylek.locamanager.model.Computer;
import com.kurylek.locamanager.model.Printer;
import com.kurylek.locamanager.repository.PrinterRepository;
import com.kurylek.locamanager.service.ComputerService;
import com.kurylek.locamanager.service.PrinterService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DataSeeding {
    private final PrinterService printerService;
    private final ComputerService computerService;

    @PostConstruct
    void setUp() {
        printerService.create(new Printer(null, "127.0.0.1", "ABC123", "AAB#1", Manufacturer.HP, "Printer 1", PrinterType.COLOR));
        printerService.create(new Printer(null, "192.168.1.1", "ABC124", "AAB#1", Manufacturer.HP, "Printer 2", PrinterType.COLOR));
        printerService.create(new Printer(null, "10.3.10.3", "123ABC", "ABB#2", Manufacturer.KONICA_MINOLTA, "Printer 3", PrinterType.BLACK));

        computerService.create(new Computer(null, "AA11c", "1234#ABCD", Manufacturer.HP, "Room 1", ComputerType.DESKTOP,"23001D"));
        computerService.create(new Computer(null, "AA11dd", "1234#DCBA", Manufacturer.HP, "Room 2", ComputerType.LAPTOP,"23002L"));
    }
}
