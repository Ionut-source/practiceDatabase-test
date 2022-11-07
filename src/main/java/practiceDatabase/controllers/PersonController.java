package practiceDatabase.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import practiceDatabase.entities.Person;
import practiceDatabase.services.PersonService;

import java.util.List;

@RestController
@RequestMapping(path = "test/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getPersons() {
        return personService.getPersons();
    }

    @PostMapping
    public void registerNewPerson(@RequestBody Person person) {
        personService.addNewPerson(person);
    }

    @DeleteMapping(path = "{personId}")
    public void deletePerson(@PathVariable("personId") Long personId) {
        personService.deletePerson(personId);
    }

    @PutMapping(path = "{personId}")
    public void updatePerson(
            @PathVariable ("personId") Long personId,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String email){
    personService.updatePerson(personId, firstName, email);
    }

}

