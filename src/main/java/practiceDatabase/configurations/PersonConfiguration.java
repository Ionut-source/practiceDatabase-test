package practiceDatabase.configurations;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import practiceDatabase.entities.Person;
import practiceDatabase.repositories.PersonRepository;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class PersonConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(PersonRepository repository) {
        return args -> {
            Person mariaTomescu = new Person(
                    "Maria",
                    "Tomescu",
                    "maria@gmail.com",
                    "FEMALE",
                    LocalDate.of(2000, 8, 14),
                    "Romania"
            );
            Person cosminPopescu = new Person(
                    "Cosmin",
                    "Popescu",
                    "cosmin@yahoo.com",
                    "MALE",
                    LocalDate.of(2002, 5, 7),
                    "Austria"
            );

            repository.saveAll(List.of(mariaTomescu, cosminPopescu));

        };
    }
}
