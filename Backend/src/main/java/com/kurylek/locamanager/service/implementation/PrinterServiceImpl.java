package com.kurylek.locamanager.service.implementation;

import com.kurylek.locamanager.enums.PrinterStatus;
import com.kurylek.locamanager.model.Printer;
import com.kurylek.locamanager.repository.PrinterRepository;
import com.kurylek.locamanager.service.PrinterService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class PrinterServiceImpl implements PrinterService {
    private final PrinterRepository printerRepository;

    @Override
    public List<Printer> getAll() {
        log.info("Fetching all printers");
        return printerRepository.findAll();
    }

    @Override
    public Printer getById(Long id) {
        log.info("Fetching printer by id: {}", id);
        return printerRepository.getReferenceById(id);
    }

    @Override
    public Printer ping(Long id) {
        Printer printer = printerRepository.getReferenceById(id);
        log.info("Pinging printer with IP: {}", printer.getIpAddress());

        printer.setPrinterStatus(getPrinterStatus(printer.getIpAddress()));
        printer = printerRepository.save(printer);

        return printer;
    }

    @Override
    public Printer create(Printer printer) {
        log.info("Adding new printer: {}", printer.getSerialNumber());
        printer.setPrinterStatus(getPrinterStatus(printer.getIpAddress()));
        return printerRepository.save(printer);
    }

    @Override
    public Printer update(Printer printer) {
        log.info("Updating  printer: {}", printer.getSerialNumber());
        return printerRepository.save(printer);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Deleting printer by id: {}", id);
        printerRepository.deleteById(id);
        return true;
    }

    private PrinterStatus getPrinterStatus(String ipAddress) {
        InetAddress address = null;
        try {
            address = InetAddress.getByName(ipAddress);
            return address.isReachable(10000) ? PrinterStatus.PRINTER_UP : PrinterStatus.PRINTER_DOWN;
        } catch (IOException e) {
            return PrinterStatus.PRINTER_DOWN;
        }
    }
}
