package com.project.controllers;

import com.project.dto.AddressDTO;
import com.project.service.address.AddressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AddressController {

    protected final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/addresses")
    public List<Optional<AddressDTO>> list() {
        return addressService.list();
    }

    @GetMapping("/address/{id}")
    public Optional<AddressDTO> get(@PathVariable String id) {
        return addressService.get(Long.parseLong(id));
    }
}
