package ua.ithillel.hillelprospring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ithillel.hillelprospring.entity.Client;
import ua.ithillel.hillelprospring.repository.ClientRepository;

import java.util.List;

@Service
public class ClientService {
    @Autowired
//    private static FakeClientRepository clientRepository;

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    public Client getById(Integer id) {
        return clientRepository.findById(id).orElseThrow();
    }

    public Client returnByEmailAndPhone(String email, long phone) {
        return clientRepository.getClientByEmailAndPhone(email, phone);
    }

    public Client returnByThreeParam(String name, long phone, int age) {
        return clientRepository.getClientByNameOrPhoneOrAge(name, phone, age);
    }


    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public Client update(Client client) {
        return clientRepository.save(client);
    }

    public Integer updateNameById(String name, Integer id) {
        return clientRepository.update(name, id);
    }


    public Integer delete(Integer id) {
        clientRepository.deleteById(id);
        return id;
    }


}
