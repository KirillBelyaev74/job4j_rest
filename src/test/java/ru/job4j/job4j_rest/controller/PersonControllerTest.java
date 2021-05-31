package ru.job4j.job4j_rest.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ru.job4j.job4j_rest.Job4jRestApplication;
import ru.job4j.job4j_rest.model.Person;
import ru.job4j.job4j_rest.repository.PersonRepository;
import ru.job4j.job4j_rest.service.PersonService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@WebAppConfiguration
@RunWith(SpringRunner.class)
public class PersonControllerTest {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;
    private Person person = new Person("user", "uses");

    @Before
    public void setUp() {
        personRepository.deleteAll();
        personRepository.save(person);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void whenSavePerson() throws Exception {
        this.mockMvc.perform(post("/person/")
                .contentType("application/json")
                .content("{ \"login\": \"kirill\", \"password\": \"kirill\" }"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("login").value("kirill"));
    }

    @Test
    public void whenFindAllPerson() throws Exception {
        this.mockMvc.perform(get("/person/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.[0].login").value("user"));
    }

    @Test
    public void whenFindPersonById() throws Exception {
        this.mockMvc.perform(get("/person/{id}", person.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("login").value("user"));
    }

    @Test
    public void whenUpdatePersonById() throws Exception {
        this.mockMvc.perform(put("/person/")
                .contentType("application/json")
                .content("{ \"id\": \"" + person.getId() + "\", \"login\": \"kirill\", \"password\": \"kirill\" }"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void whenDeletePersonById() throws Exception {
        this.mockMvc.perform(delete("/person/{id}", person.getId()))
                .andDo(print())
                .andExpect(status().isOk());
    }
}