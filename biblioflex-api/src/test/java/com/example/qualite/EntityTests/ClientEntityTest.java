package com.example.qualite.EntityTests;

import com.example.qualite.entity.Client;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ClientEntityTest {

    @Test
    void testClientFields() {
        Client client = new Client();
        client.setId(10L);
        client.setFirstName("Marie");
        client.setLastName("Curie");
        client.setEmail("marie.curie@example.com");
        client.setPhone("0612345678");

        assertThat(client.getId()).isEqualTo(10);
        assertThat(client.getFirstName()).isEqualTo("Marie");
        assertThat(client.getLastName()).isEqualTo("Curie");
        assertThat(client.getEmail()).isEqualTo("marie.curie@example.com");
        assertThat(client.getPhone()).isEqualTo("0612345678");
    }
}
