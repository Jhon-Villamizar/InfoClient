package com.pearls.InfoClient.repositories;

import org.springframework.data.repository.CrudRepository;

import com.pearls.InfoClient.model.Country;

public interface CountryRepository extends CrudRepository<Country, Integer> {

}
