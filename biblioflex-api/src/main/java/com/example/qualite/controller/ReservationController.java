package com.example.qualite.controller;

import com.example.qualite.entity.Book;
import com.example.qualite.entity.Client;
import com.example.qualite.entity.Reservation;
import com.example.qualite.repository.BookRepository;
import com.example.qualite.repository.ClientRepository;
import com.example.qualite.repository.ReservationRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationRepository reservationRepository;
    private final BookRepository bookRepository;
    private final ClientRepository clientRepository;

    public ReservationController(ReservationRepository reservationRepository, BookRepository bookRepository, ClientRepository clientRepository) {
        this.reservationRepository = reservationRepository;
        this.bookRepository = bookRepository;
        this.clientRepository = clientRepository;
    }

    @GetMapping
    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Reservation reservation) {
        Book book = bookRepository.findById(reservation.getBook().getId()).orElse(null);
        Client client = clientRepository.findById(reservation.getClient().getId()).orElse(null);

        if (book == null || client == null) {
            return ResponseEntity.badRequest().body("Book or Client not found");
        }

        reservation.setBook(book);
        reservation.setClient(client);
        reservation.setReservationDate(LocalDateTime.now());
        reservation.setStatus("active");

        book.setAvailable(false);
        bookRepository.save(book);

        return ResponseEntity.ok(reservationRepository.save(reservation));
    }
}