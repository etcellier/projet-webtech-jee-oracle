package com.project.service.address;

import com.project.dto.AddressDTO;
import com.project.entity.Address;
import com.project.repository.AddressRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AddressService {

    protected final AddressMapper addressMapper;
    protected final AddressRepository addressRepository;

    public AddressService(AddressMapper addressMapper, AddressRepository addressRepository) {
        this.addressMapper = addressMapper;
        this.addressRepository = addressRepository;
    }

    public List<Optional<AddressDTO>> list() {
        List<Optional<AddressDTO>> addressDTOList = new ArrayList<>();
        List<Address> addressList = addressRepository.findAll();
        for (Address address : addressList) {
            addressDTOList.add(Optional.ofNullable(addressMapper.map(address)));
        }
        return addressDTOList;
    }

    public Optional<AddressDTO> get(Long id) {
        Optional<Address> address = addressRepository.findById(id);
        return address.map(addressMapper::map);
    }

    public void create(AddressDTO addressDTO) {
        Address address = addressRepository.save(addressMapper.update(addressDTO, new Address()));
        addressRepository.save(address);
    }

    public void update(AddressDTO addressDTO) {
        Address address = addressRepository.findById(addressDTO.getId()).get();
        address = addressMapper.update(addressDTO, address);
        addressRepository.save(address);
    }

    public void delete(Long id) {
        addressRepository.deleteById(id);
    }
}
