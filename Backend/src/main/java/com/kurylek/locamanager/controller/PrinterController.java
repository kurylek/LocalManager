package com.kurylek.locamanager.controller;

import com.kurylek.locamanager.model.Printer;
import com.kurylek.locamanager.service.PrinterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


@RestController
@RequiredArgsConstructor
@RequestMapping("/printer")
public class PrinterController {
    private final PrinterService printerService;

    @GetMapping("/get/{printerId}")
    public Printer getPrinter(@PathVariable Long printerId) {
        return printerService.getById(printerId);
    }

    @GetMapping("/all")
    public List<Printer> getPrinters() {
        return printerService.getAll();
    }

    @GetMapping("/ping/{printerId}")
    public Printer pingPrinter(@PathVariable Long printerId) throws IOException {
        return printerService.ping(printerId);
    }

    @PostMapping("/save")
    public Printer savePrinter(@RequestBody @Valid Printer printer) {
        return printerService.create(printer);
    }

    @PostMapping("/update")
    public Printer updatePrinter(@RequestBody @Valid Printer printer) {
        return printerService.update(printer);
    }

    @DeleteMapping("/delete/{printerId}")
    public Boolean deletePrinter(@PathVariable Long printerId) {
        return printerService.delete(printerId);
    }
}
