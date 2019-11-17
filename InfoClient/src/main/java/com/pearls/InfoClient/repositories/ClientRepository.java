package com.pearls.InfoClient.repositories;

import org.springframework.data.repository.CrudRepository;

import com.pearls.InfoClient.model.Client;

public interface ClientRepository extends CrudRepository<Client, Integer> {

}
