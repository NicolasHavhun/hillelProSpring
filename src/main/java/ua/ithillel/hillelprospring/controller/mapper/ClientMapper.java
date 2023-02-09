package ua.ithillel.hillelprospring.controller.mapper;

import org.springframework.stereotype.Component;
import ua.ithillel.hillelprospring.controller.dto.ClientDto;
import ua.ithillel.hillelprospring.entity.Client;
@Component
public class ClientMapper {
    public ClientDto toDto(Client client){
        return new ClientDto(
                client.getName(),
                client.getId(),
                client.getAge(),
                client.getEmail(),
                client.getPhone()
        );
    }

    public Client toEntity(ClientDto clientDto) {
        return new Client(
                clientDto.getId(),
                clientDto.getName(),
                clientDto.getAge(),
                clientDto.getEmail(),
                clientDto.getPhone()
        );

    }
}
