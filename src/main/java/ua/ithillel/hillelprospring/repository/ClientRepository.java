package ua.ithillel.hillelprospring.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ua.ithillel.hillelprospring.entity.Client;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClientRepository {

    private List<Client> clients = new ArrayList<>();


    @PostConstruct
    public void init() {
        clients.add(new Client("Nina", 0, 18, "nina@gmail.com", 80962345434L));
        clients.add(new Client("Anna", 1, 27, "anna@gmail.com", 80973452312L));
        clients.add(new Client("Aliotte", 2, 34, "aliotte@gmail.com", 80505648657L));
    }

    public List<Client> getAll() {
        return clients;
    }

    public Client getById(Integer id) {
        return clients.get(id);
    }

    public Client save(Client client) {
        clients.add(client);
        client.setId(clients.size());
        return client;
    }

    public Client update(Integer id, Client client) {
        final Client oldClient = clients.get(id);
        oldClient.setName(client.getName());
        //update fields....
        return clients.get(id);
    }

    public Integer delete(int id) {
        clients.remove(id);
        return id;
    }

    public Client returnByEmailAndPhone(String email, long phone) {
        return null;
    }

    public static Client returnByThreeParam(String name, String phone, int age) {
        return null;
    }
}
