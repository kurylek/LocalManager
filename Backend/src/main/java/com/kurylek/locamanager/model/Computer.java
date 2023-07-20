package com.kurylek.locamanager.model;

import com.kurylek.locamanager.enums.ComputerType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Computer extends Device{

    @NotBlank(message = "Computer type cannot be empty")
    private ComputerType computerType;

    @Column(unique = true)
    private String domainName;
    
}
