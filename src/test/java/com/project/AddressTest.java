package com.project;

import static org.junit.Assert.assertEquals;

import com.project.dto.AddressDTO;
import com.project.entity.Address;
import com.project.service.address.AddressMapper;
import org.junit.Before;
import org.junit.Test;

public class AddressTest {

    private AddressMapper addressMapper;

    @Before
    public void setUp() {
        addressMapper = new AddressMapper();
    }

    @Test
    public void testMap() {
        // Créer un objet Address fictif
        Address address = new Address();
        address.setId(1L);
        address.setStreet("123 Main St");
        address.setCity("Cityville");
        address.setZip("12345");
        address.setCountry("Countryland");

        // Appeler la méthode map de l'AddressMapper
        AddressDTO addressDTO = addressMapper.map(address);

        // Vérifier que le mapping est correct
        assertEquals(address.getId(), addressDTO.getId());
        assertEquals(address.getStreet(), addressDTO.getStreet());
        assertEquals(address.getCity(), addressDTO.getCity());
        assertEquals(address.getZip(), addressDTO.getZip());
        assertEquals(address.getCountry(), addressDTO.getCountry());
    }

    @Test
    public void testUpdate() {
        // Créer un objet Address fictif
        Address address = new Address();
        address.setId(1L);
        address.setStreet("123 Main St");
        address.setCity("Cityville");
        address.setZip("12345");
        address.setCountry("Countryland");

        // Créer un objet AddressDTO fictif
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setStreet("456 New St");
        addressDTO.setCity("NewCity");
        addressDTO.setZip("54321");
        addressDTO.setCountry("NewCountry");

        // Appeler la méthode update de l'AddressMapper
        Address updatedAddress = addressMapper.update(addressDTO, address);

        // Vérifier que la mise à jour est correcte
        assertEquals(address.getId(), updatedAddress.getId());
        assertEquals(addressDTO.getStreet(), updatedAddress.getStreet());
        assertEquals(addressDTO.getCity(), updatedAddress.getCity());
        assertEquals(addressDTO.getZip(), updatedAddress.getZip());
        assertEquals(addressDTO.getCountry(), updatedAddress.getCountry());
    }
}
