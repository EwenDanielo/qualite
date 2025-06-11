package com.example.qualite.EntityTests;

import com.example.qualite.entity.Client;
import com.example.qualite.entity.Book;
import com.example.qualite.entity.Reservation;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class ReservationEntityTest {

    @Test
    void testReservationFields() {
        Client client = new Client();
        client.setId(1L);
        client.setFirstName("Alice");

        Book book = new Book();
        book.setId(2L);
        book.setTitle("Java for Dummies");

        Reservation reservation = new Reservation();
        reservation.setId(100L);
        reservation.setClient(client);
        reservation.setBook(book);
        reservation.setReservationDate(LocalDateTime.of(2024, 12, 25, 15, 0));
        reservation.setStatus("active");

        assertThat(reservation.getId()).isEqualTo(100);
        assertThat(reservation.getClient()).isEqualTo(client);
        assertThat(reservation.getBook()).isEqualTo(book);
        assertThat(reservation.getReservationDate()).isEqualTo(LocalDateTime.of(2024, 12, 25, 15, 0));
        assertThat(reservation.getStatus()).isEqualTo("active");
    }
}
