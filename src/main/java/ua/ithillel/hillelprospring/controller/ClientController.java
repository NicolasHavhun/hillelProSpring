package ua.ithillel.hillelprospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ua.ithillel.hillelprospring.entity.Client;
import ua.ithillel.hillelprospring.service.ClientService;

import java.util.List;

@Controller
public class ClientController {
    @Autowired
    private ClientService clientService;

    public List<Client> getAll() {
        return clientService.getAll();
    }

}
