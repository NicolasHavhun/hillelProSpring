package ua.ithillel.hillelprospring.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClientDto {
    private String name;
    private Integer id;
    private int age;
    private String email;
    private long phone;
}
