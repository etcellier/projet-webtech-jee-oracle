package com.project.controllers;

import com.project.dto.AddressDTO;
import com.project.service.address.AddressService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/address")
    public void create(@RequestBody AddressDTO addressDTO) {
        addressService.create(addressDTO);
    }

    @PutMapping("/address")
    public void update(@RequestBody AddressDTO addressDTO) {
        addressService.update(addressDTO);
    }

    @DeleteMapping("/address/{id}")
    public void delete(@PathVariable String id) {
        addressService.delete(Long.parseLong(id));
    }
}
