package com.prueba.myhotel.empresa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.myhotel.empresa.dto.Locations;

public interface LocationsRepository extends JpaRepository<Locations, Long> {

}
