package com.example.qualite.ControllerTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ClientControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("GET /clients should return 200 OK")
    void testGetAllClients() throws Exception {
        mockMvc.perform(get("/clients"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("GET /clients/{id} should return 4xx if not found")
    void testGetClientByIdNotFound() throws Exception {
        mockMvc.perform(get("/clients/9999")) // on suppose que 9999 n'existe pas
                .andExpect(status().is4xxClientError());
    }
}