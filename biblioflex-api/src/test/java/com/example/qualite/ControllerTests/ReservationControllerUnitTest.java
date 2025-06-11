package com.example.qualite.ControllerTests;

import com.example.qualite.controller.ReservationController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ReservationController.class)
class ReservationControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("GET /reservations should return status OK")
    void testGetAll() throws Exception {
        mockMvc.perform(get("/reservations"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("GET /reservations/{id} should return client error (if not found)")
    void testGetByIdNotFound() throws Exception {
        mockMvc.perform(get("/reservations/9999"))
                .andExpect(status().is4xxClientError());
    }
}
