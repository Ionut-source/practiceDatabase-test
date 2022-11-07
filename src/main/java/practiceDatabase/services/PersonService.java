package practiceDatabase.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practiceDatabase.entities.Person;
import practiceDatabase.repositories.PersonRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    public void addNewPerson(Person person) {
        Optional<Person> personOptional = personRepository.findPersonByEmail(person.getEmail());
        if (personOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        personRepository.save(person);
    }

    public void deletePerson(Long personId) {
        boolean exists = personRepository.existsById(personId);
        if (!exists) {
            throw new IllegalStateException("person with id " + personId + " does not exists");
        }
        personRepository.deleteById(personId);
    }

    @Transactional
    public void updatePerson(Long personId, String firstName, String email) {
        Person person = personRepository.findById(personId).orElseThrow(() -> new IllegalStateException(
                "person with id " + personId + " does not exists"));
        if (firstName != null && firstName.length() > 0 && !Objects.equals(person.getFirstname(), firstName)) {
            person.setFirstname((firstName));
        }
        if (email != null && email.length() > 0 && !Objects.equals(person.getEmail(), email)) {
                Optional<Person> personOptional = personRepository.findPersonByEmail(email);
                if (personOptional.isPresent()) {
                    throw new IllegalStateException("email taken");
                }
                person.setEmail(email);
            }
        }
    }
