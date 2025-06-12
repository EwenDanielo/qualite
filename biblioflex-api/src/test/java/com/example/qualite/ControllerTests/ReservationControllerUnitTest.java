package com.example.qualite.ControllerTests;

import com.example.qualite.controller.ReservationController;
import com.example.qualite.entity.Book;
import com.example.qualite.entity.Client;
import com.example.qualite.entity.Reservation;
import com.example.qualite.repository.BookRepository;
import com.example.qualite.repository.ClientRepository;
import com.example.qualite.repository.ReservationRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ReservationController.class)
class ReservationControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReservationRepository reservationRepository;

    @MockBean
    private BookRepository bookRepository;

    @MockBean
    private ClientRepository clientRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("GET /reservations should return status OK and empty list")
    void testGetAll() throws Exception {
        when(reservationRepository.findAll()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/reservations"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("POST /reservations should return 400 if book or client not found")
    void testCreateReservationInvalid() throws Exception {
        Reservation reservation = new Reservation();
        Book book = new Book(); book.setId(1L);
        Client client = new Client(); client.setId(1L);
        reservation.setBook(book);
        reservation.setClient(client);

        when(bookRepository.findById(1L)).thenReturn(Optional.empty());
        when(clientRepository.findById(1L)).thenReturn(Optional.empty());

        mockMvc.perform(post("/reservations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(reservation)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Book or Client not found"));
    }

    @Test
    @DisplayName("POST /reservations should return 200 OK when created")
    void testCreateReservationSuccess() throws Exception {
        Book book = new Book(); book.setId(1L); book.setAvailable(true);
        Client client = new Client(); client.setId(1L);
        Reservation reservation = new Reservation();
        reservation.setBook(book);
        reservation.setClient(client);

        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
        when(clientRepository.findById(1L)).thenReturn(Optional.of(client));
        when(reservationRepository.save(any(Reservation.class))).thenAnswer(i -> {
            Reservation r = i.getArgument(0);
            r.setId(42L);
            return r;
        });

        mockMvc.perform(post("/reservations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(reservation)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").value(42));
    }
}
