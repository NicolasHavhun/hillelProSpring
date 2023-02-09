package ua.ithillel.hillelprospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.ithillel.hillelprospring.controller.dto.ClientDto;
import ua.ithillel.hillelprospring.controller.dto.IntegerDto;
import ua.ithillel.hillelprospring.controller.dto.StringDto;
import ua.ithillel.hillelprospring.controller.mapper.ClientMapper;
import ua.ithillel.hillelprospring.entity.Client;
import ua.ithillel.hillelprospring.service.ClientService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientService clientService;
    private final ClientMapper clientMapper;

    @Autowired

    public ClientController(final ClientService clientService, final ClientMapper clientMapper) {
        this.clientService = clientService;
        this.clientMapper = clientMapper;
    }

    //    @RequestMapping(path = "/all", method = RequestMethod.GET)
    @GetMapping()
    public ResponseEntity<List<ClientDto>> getAll() {
        return new ResponseEntity<>(clientService.getAll()
                .stream()
                .map(clientMapper::toDto)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(clientMapper.toDto(clientService.getById(id)));

    }

    @GetMapping("/{email}/{phone}")
    public ResponseEntity<ClientDto> returnByEmailAndPhone(
            @PathVariable String email,
            @PathVariable long phone) {
        return ResponseEntity.ok(clientMapper.toDto(clientService.returnByEmailAndPhone(email, phone)));
    }

    //    GET localhost:8080/clients/nina@gmail.com/80962345434
    @GetMapping("/filter")
    public ResponseEntity<ClientDto> returnByThreeParam(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) long phone,
            @RequestParam int age) {
        return ResponseEntity.ok(clientMapper.toDto(clientService.returnByThreeParam(name, phone, age)));

//        localhost:8080/clients/filter?age=18
    }

    @GetMapping("/email/{clientId}")
    public StringDto getEmailById(@PathVariable Integer clientId) {
        return new StringDto("nico@mail.ua");
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientDto> save(@RequestBody ClientDto clientDto) {
        return new ResponseEntity<>(
                clientMapper.toDto(
                        clientService.save(
                                clientMapper.toEntity(clientDto))),
                HttpStatus.CREATED);
    }
//    localhost:8080/clients
//    {
// "name": "Andrei",
// "age": 24
//}

    @PutMapping
    public ClientDto update(@RequestBody ClientDto clientDto) {
        return clientMapper.toDto(
                clientService.update(clientMapper.toEntity(clientDto)));

    }

    //    PUT localhost:8080/clients/0
//    {
//    "name": "Elsa"
//}
    @PutMapping("/{id}/{name}")
    public IntegerDto updateNameById(
            @PathVariable Integer id,
            @PathVariable String name
    ) {
        return new IntegerDto(clientService.updateNameById(name, id));
    }


    @DeleteMapping
    public Integer delete(@RequestParam Integer id) {
        return clientService.delete(id);
    }

    //    DELETE localhost:8080/clients?id=2

}
