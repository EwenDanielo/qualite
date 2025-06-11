package com.example.qualite.RepositoryTests;

import com.example.qualite.entity.Client;
import com.example.qualite.repository.ClientRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    @Test
    @DisplayName("Should save and retrieve a client")
    void testSaveAndFindById() {
        Client client = new Client();
        client.setFirstName("John");
        client.setLastName("Doe");
        client.setEmail("john.doe@example.com");
        client.setPhone("0123456789");

        Client saved = clientRepository.save(client);
        Optional<Client> found = clientRepository.findById(saved.getId());

        assertThat(found).isPresent();
        assertThat(found.get().getEmail()).isEqualTo("john.doe@example.com");
    }

    @Test
    @DisplayName("Should return empty list if no clients exist")
    void testFindAllEmpty() {
        List<Client> clients = clientRepository.findAll();
        assertThat(clients).isEmpty();
    }

    @Test
    @DisplayName("Should delete a client")
    void testDelete() {
        Client client = new Client();
        client.setFirstName("Jane");
        client.setLastName("Smith");
        client.setEmail("jane@example.com");
        client.setPhone("0987654321");

        Client saved = clientRepository.save(client);
        clientRepository.delete(saved);

        Optional<Client> found = clientRepository.findById(saved.getId());
        assertThat(found).isNotPresent();
    }
}
