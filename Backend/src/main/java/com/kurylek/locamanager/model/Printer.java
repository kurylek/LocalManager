package com.kurylek.locamanager.model;

import com.kurylek.locamanager.enums.PrinterType;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Printer extends Device{
    private PrinterType printerType;

}
