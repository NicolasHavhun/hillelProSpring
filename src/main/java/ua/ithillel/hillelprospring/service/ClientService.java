package ua.ithillel.hillelprospring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ithillel.hillelprospring.entity.Client;
import ua.ithillel.hillelprospring.repository.ClientRepository;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private static ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    public List<Client> getAll() {
        return clientRepository.getAll();
    }

    public static Client getById(Integer id) {
        return clientRepository.getById(id);
    }

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public Client update(Integer id, Client client) {
        return clientRepository.update(id, client);
    }

    public Integer delete(Integer id) {
        return clientRepository.delete(id);
    }

    public Client returnByEmailAndPhone(String email, long phone) {
        return clientRepository.returnByEmailAndPhone(email, phone);
    }

    public static Client returnByThreeParam(String name, String phone, int age) {
        return ClientRepository.returnByThreeParam(name, phone, age);
    }

}
