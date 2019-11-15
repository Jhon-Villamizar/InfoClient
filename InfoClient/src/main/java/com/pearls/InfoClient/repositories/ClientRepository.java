package com.pearls.InfoClient.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pearls.InfoClient.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
