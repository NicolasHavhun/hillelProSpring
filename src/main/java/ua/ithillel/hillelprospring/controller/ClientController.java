package ua.ithillel.hillelprospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.ithillel.hillelprospring.entity.Client;
import ua.ithillel.hillelprospring.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientService clientService;

    @Autowired

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    @GetMapping()
    public List<Client> getAll() {
        return clientService.getAll();
    }

    @GetMapping("/{id}")
    public Client getById(@PathVariable Integer id) {
        return ClientService.getById(id);

    }

    @PostMapping
    public Client save(@RequestBody Client client) {
        return clientService.save(client);
    }
//    localhost:8080/clients
//    {
// "name": "Andrei",
// "age": 24
//}

    @PutMapping("/{id}")
    public Client update(@PathVariable Integer id, @RequestBody Client client) {
        return clientService.update(id, client);
    }
//    PUT localhost:8080/clients/0
//    {
//    "name": "Elsa"
//}

    @DeleteMapping
    public Integer delete(@RequestParam Integer id) {
        return clientService.delete(id);
    }

    //    DELETE localhost:8080/clients?id=2
    @GetMapping("/{email}/{phone}")
    public Client returnByEmailAndPhone(
            @PathVariable String email,
            @PathVariable long phone) {
        return clientService.returnByEmailAndPhone(email, phone);
    }

    //    GET localhost:8080/clients/nina@gmail.com/80962345434
    @GetMapping("/filter")
    public Client returnByThreeParam(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String phone,
            @RequestParam(required = true) int age) {
        return ClientService.returnByThreeParam(name, phone, age);
//        В этом месте не уверен что правильно
//        localhost:8080/clients/filter?age=18

    }

}
