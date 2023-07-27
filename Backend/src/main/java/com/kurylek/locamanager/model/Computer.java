package com.kurylek.locamanager.model;

import com.kurylek.locamanager.enums.ComputerType;
import com.kurylek.locamanager.enums.Manufacturer;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Computer extends Device{

    @NotNull(message = "Computer type cannot be empty")
    private ComputerType computerType;

    @Column(unique = true)
    private String domainName;

    public Computer(Long deviceId, String serialNumber, String productNumber, Manufacturer manufacturer, String description, ComputerType computerType, String domainName) {
        super(deviceId, serialNumber, productNumber, manufacturer, description);
        this.computerType = computerType;
        this.domainName = domainName;
    }
}
