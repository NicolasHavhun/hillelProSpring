package ua.ithillel.hillelprospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.ithillel.hillelprospring.configuration.CustomConfiguration;
import ua.ithillel.hillelprospring.controller.ClientController;
import ua.ithillel.hillelprospring.entity.Client;

import java.util.List;

@SpringBootApplication
public class HillelProSpringApplication {

    public static void main(String[] args) {
//        2. @Configuration & @Bean

//        SpringApplication.run(HillelProSpringApplication.class, args);
//        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CustomConfiguration.class);
//        final String stringBean = context.getBean("stringBean", String.class);
//        Client firstClient = context.getBean("getRandomClient", Client.class);
//        Client secondClient = context.getBean("getRandomClient", Client.class);
//        secondClient.setName("Nico");
//        secondClient.setId(3);
//        secondClient.setAge(34);
//        System.out.println(stringBean);
//        System.out.println(firstClient);
//        System.out.println(secondClient);

//        3. @Value

//        String getQueueName = context.getBean("getQueueName", String.class);
//        String getClientName = context.getBean("getClientName", String.class);
//        System.out.println(getQueueName);
//        System.out.println(getClientName);

//        5.

        ConfigurableApplicationContext applicationContext = SpringApplication.run(HillelProSpringApplication.class, args);
        ClientController clientController = applicationContext.getBean(ClientController.class);
        List<Client> allClients = clientController.getAll();
        System.out.println(allClients);

    }

}
