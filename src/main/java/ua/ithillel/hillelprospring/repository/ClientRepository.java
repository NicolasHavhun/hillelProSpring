package ua.ithillel.hillelprospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ua.ithillel.hillelprospring.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    @Transactional
    @Modifying
    @Query("update Client c set c.name = ?1 where c.id = ?1")
    Integer update(String name, Integer id);


    Client getClientByEmailAndPhone(String email, long phone);

    Client getClientByNameOrPhoneOrAge(String name, long phone, int age);
}
