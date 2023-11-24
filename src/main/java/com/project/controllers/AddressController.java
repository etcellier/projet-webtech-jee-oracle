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

    // Méthode list() qui liste les adresses
    @GetMapping("/addresses")
    public List<Optional<AddressDTO>> list() {
        return addressService.list();
    }

    // Méthode get() qui récupère une adresse en fonction de son id
    @GetMapping("/address/{id}")
    public Optional<AddressDTO> get(@PathVariable String id) {
        return addressService.get(Long.parseLong(id));
    }

    // Méthode create() qui crée une adresse grâce au body de la requête
    @PostMapping("/address")
    public void create(@RequestBody AddressDTO addressDTO) {
        addressService.create(addressDTO);
    }

    // Méthode update() qui met à jour une adresse grâce au body de la requête
    @PutMapping("/address")
    public void update(@RequestBody AddressDTO addressDTO) {
        addressService.update(addressDTO);
    }

    // Méthode delete() qui supprime une adresse en fonction de son id
    @DeleteMapping("/address/{id}")
    public void delete(@PathVariable String id) {
        addressService.delete(Long.parseLong(id));
    }
}
