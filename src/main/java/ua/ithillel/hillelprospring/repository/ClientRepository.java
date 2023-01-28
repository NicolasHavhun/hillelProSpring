package ua.ithillel.hillelprospring.repository;

import org.springframework.stereotype.Repository;
import ua.ithillel.hillelprospring.entity.Client;

import java.util.List;

@Repository
public class ClientRepository {
    public List<Client> getAll() {
        return List.of(
                new Client("Nina", 4, 18),
                new Client("Anna", 5, 27),
                new Client("Aliotte", 6, 34)
        );
    }
}
