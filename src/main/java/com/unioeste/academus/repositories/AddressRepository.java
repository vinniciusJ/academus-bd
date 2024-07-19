package com.unioeste.academus.repositories;

import com.unioeste.academus.models.entities.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
