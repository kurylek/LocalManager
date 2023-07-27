package com.kurylek.locamanager.controller;

import com.kurylek.locamanager.model.Computer;
import com.kurylek.locamanager.service.ComputerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/computer")
@CrossOrigin("*")
public class ComputerController {
    private final ComputerService computerService;

    @GetMapping("/get/{computerId}")
    public Computer getComputer(@PathVariable Long computerId) {
        return computerService.getById(computerId);
    }

    @GetMapping("/all")
    public List<Computer> getComputers() {
        return computerService.getAll();
    }

    @PostMapping("/save")
    public Computer saveComputer(@RequestBody @Valid Computer computer) {
        return computerService.create(computer);
    }

    @PostMapping("/update")
    public Computer updateComputer(@RequestBody @Valid Computer computer) {
        return computerService.update(computer);
    }

    @DeleteMapping("/delete/{computerId}")
    public Boolean deleteComputer(@PathVariable Long computerId) {
        return computerService.delete(computerId);
    }
}
