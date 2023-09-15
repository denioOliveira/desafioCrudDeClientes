package com.desafiocrud.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafiocrud.crud.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
