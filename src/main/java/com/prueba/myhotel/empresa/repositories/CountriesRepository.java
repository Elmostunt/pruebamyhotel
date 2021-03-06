package com.prueba.myhotel.empresa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.myhotel.empresa.dto.Countries;

public interface CountriesRepository extends JpaRepository<Countries, Long> {

}
