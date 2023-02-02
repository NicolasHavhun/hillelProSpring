package ua.ithillel.hillelprospring.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import ua.ithillel.hillelprospring.entity.Client;

@Configuration
@ComponentScan("ua.ithillel.hillelprospring.configuration")
@PropertySource("classpath:application.properties")
public class CustomConfiguration {
    @Value("${queue.name}")
    private String queueName;


    @Value("${dbUsername}")
    private String clientName;

    @Bean
    public String getQueueName() {
        return queueName;
    }


    @Bean
    public String getClientName() {
        return clientName;
    }

    @Bean
//default singleton
    public String stringBean() {
        return "Some custom singleton string ";

    }

    @Bean
    @Scope("prototype")
    public Client getRandomClient() {
        return new Client("Paul", 1, 25, "paul@gmail.com", 80975674532L);
    }
}
