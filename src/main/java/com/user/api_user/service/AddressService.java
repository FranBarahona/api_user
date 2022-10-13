package com.user.api_user.service;

import com.user.api_user.model.Address;
import com.user.api_user.model.Dto.AddressDto;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    List<Address> findAll();

    Optional<Address> findById(Long id);

    Address save(Address address);

    List<Address> getAddressUser(Long id);

    boolean delete(Long id);
}
