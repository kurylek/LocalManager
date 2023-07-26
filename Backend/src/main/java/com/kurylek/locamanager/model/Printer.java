package com.kurylek.locamanager.model;

import com.kurylek.locamanager.enums.Manufacturer;
import com.kurylek.locamanager.enums.PrinterStatus;
import com.kurylek.locamanager.enums.PrinterType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Printer extends Device{

    @Column(unique = true)
    private String ipAddress;
    private PrinterType printerType;
    private PrinterStatus printerStatus;

    public Printer(Long deviceId, String ipAddress, String serialNumber, String productNumber, Manufacturer manufacturer, String description, PrinterType printerType) {
        super(deviceId, serialNumber, productNumber, manufacturer, description);
        this.printerType = printerType;
        this.ipAddress = ipAddress;
    }
}
