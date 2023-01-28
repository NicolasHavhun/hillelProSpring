package ua.ithillel.hillelprospring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ithillel.hillelprospring.entity.Client;
import ua.ithillel.hillelprospring.repository.ClientRepository;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.getAll();
    }
}
