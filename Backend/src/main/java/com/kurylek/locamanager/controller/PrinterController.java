package com.kurylek.locamanager.controller;

import com.kurylek.locamanager.model.Printer;
import com.kurylek.locamanager.service.PrinterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/printer")
@CrossOrigin("*")
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
