package com.api.back.apiwebproject.service;

import com.api.back.apiwebproject.model.Administrateur;
import com.api.back.apiwebproject.model.Client;
import com.api.back.apiwebproject.repo.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepo clientRepo;

    @Autowired
    public ClientService(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    public Client addClient(Client client) {
        return clientRepo.save(client);
    }

    public List<Client> getAll(){
        return clientRepo.findAll();
    }

    public Client getClient(Long id) {
        return clientRepo.findById(id).orElse(null);
    }

    public Client getClientByEmail(String email) {
        return clientRepo.findByEmail(email);
    }

    public Client updateClient(Client client) {
        return clientRepo.save(client);
    }

    public void deleteClient(Long id) {
        clientRepo.deleteById(id);
    }
}
