package com.example.qualite.RepositoryTests;

import com.example.qualite.entity.Book;
import com.example.qualite.entity.Client;
import com.example.qualite.entity.Reservation;
import com.example.qualite.repository.BookRepository;
import com.example.qualite.repository.ClientRepository;
import com.example.qualite.repository.ReservationRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ReservationRepositoryTest {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private BookRepository bookRepository;

    @Test
    @DisplayName("Should save and retrieve a reservation")
    void testSaveAndFindById() {
        Client client = new Client();
        client.setFirstName("Alice");
        client.setLastName("Wonder");
        client.setEmail("alice@wonder.com");
        client.setPhone("0606060606");
        client = clientRepository.save(client);

        Book book = new Book();
        book.setTitle("Le Livre");
        book.setAuthor("Auteur");
        book.setIsbn("1111111111111");
        book.setPublishedDate(LocalDate.now());
        book.setAvailable(true);
        book = bookRepository.save(book);

        Reservation reservation = new Reservation();
        reservation.setClient(client);
        reservation.setBook(book);
        reservation.setReservationDate(LocalDateTime.now());
        reservation.setStatus("active");

        Reservation saved = reservationRepository.save(reservation);
        Optional<Reservation> found = reservationRepository.findById(saved.getId());

        assertThat(found).isPresent();
        assertThat(found.get().getClient().getEmail()).isEqualTo("alice@wonder.com");
    }

    @Test
    @DisplayName("Should return empty list if no reservations exist")
    void testFindAllEmpty() {
        List<Reservation> reservations = reservationRepository.findAll();
        assertThat(reservations).isEmpty();
    }

    @Test
    @DisplayName("Should delete a reservation")
    void testDelete() {
        Client client = new Client();
        client.setFirstName("Bob");
        client.setLastName("Builder");
        client.setEmail("bob@builder.com");
        client.setPhone("0707070707");
        client = clientRepository.save(client);

        Book book = new Book();
        book.setTitle("Livre Test");
        book.setAuthor("Auteur Test");
        book.setIsbn("2222222222222");
        book.setPublishedDate(LocalDate.now());
        book.setAvailable(true);
        book = bookRepository.save(book);

        Reservation reservation = new Reservation();
        reservation.setClient(client);
        reservation.setBook(book);
        reservation.setReservationDate(LocalDateTime.now());
        reservation.setStatus("active");

        Reservation saved = reservationRepository.save(reservation);
        reservationRepository.delete(saved);

        Optional<Reservation> found = reservationRepository.findById(saved.getId());
        assertThat(found).isNotPresent();
    }
}
