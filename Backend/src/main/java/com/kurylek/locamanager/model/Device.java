package com.kurylek.locamanager.model;

import com.kurylek.locamanager.enums.Manufacturer;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deviceId;

    @Column(unique = true)
    private String ipAddress;

    @Column(unique = true)
    @NotBlank(message = "Serial number cannot be empty")
    private String serialNumber;

    @NotBlank(message = "Product number cannot be empty")
    private String productNumber;

    @NotNull(message = "Manufacturer cannot be empty")
    private Manufacturer manufacturer;

    private String description;
}
