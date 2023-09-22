package com.desafiocrud.crud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.desafiocrud.crud.dto.ClientDTO;
import com.desafiocrud.crud.entities.Client;
import com.desafiocrud.crud.repositories.ClientRepository;
import com.desafiocrud.crud.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;


@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Client cli = repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Recurso não encontrado"));
		return new ClientDTO(cli);
	}
	@Transactional(readOnly = true)
	public Page<ClientDTO> findAll(Pageable pageable) {
		Page<Client> cli = repository.findAll(pageable);
		return cli.map(x -> new ClientDTO(x));
	}
	
	@Transactional
	public ClientDTO insert(ClientDTO dto) {
		Client cli = new Client();
		copyToEntity(dto, cli);
		cli = repository.save(cli);
		return new ClientDTO(cli);
	}
	
	@Transactional
	public ClientDTO upDate(Long id, ClientDTO dto) {
		try {
			Client cli = repository.getReferenceById(id);
			copyToEntity(dto, cli);
			cli = repository.save(cli);
			return new ClientDTO(cli);
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Recurso não encontrado");
		}
		
	}
	@Transactional
	public void delete(Long id) {
		if(!repository.existsById(id)) {
			throw new ResourceNotFoundException("Recurso não encontrado");
		}
		repository.deleteById(id);
	}
	
	private void copyToEntity(ClientDTO dto, Client entity) {
		entity.setName(dto.getName());
		entity.setCpf(dto.getCpf());
		entity.setIncome(dto.getIncome());
		entity.setBirthDate(dto.getBirthDate());
		entity.setChildren(dto.getChildren());
	}
}
