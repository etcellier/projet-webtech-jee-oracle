package com.project.service.address;

import com.project.dto.AddressDTO;
import com.project.entity.Address;

public class AddressMapper {

    public AddressDTO map(Address address) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setId(address.getId());
        addressDTO.setStreet(address.getStreet());
        addressDTO.setCity(address.getCity());
        addressDTO.setZip(address.getZip());
        addressDTO.setCountry(address.getCountry());
        return addressDTO;
    }

    public Address update(AddressDTO addressDTO, Address address) {
        address.setStreet(addressDTO.getStreet());
        address.setCity(addressDTO.getCity());
        address.setZip(addressDTO.getZip());
        address.setCountry(addressDTO.getCountry());
        return address;
    }
}
