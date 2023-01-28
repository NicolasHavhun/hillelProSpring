package ua.ithillel.hillelprospring.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Client {
    private String name;
    private Integer id;
    private Integer age;

}
