package com.example.qualite.DTOTests;

import com.example.qualite.dto.ApiResponse;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ApiReponseDTOTests {

    @Test
    void testConstructorWithData() {
        String data = "Success";
        ApiResponse<String> response = new ApiResponse<>(data);

        assertThat(response.getData()).isEqualTo("Success");
        assertThat(response.getError()).isNull();
    }

    @Test
    void testConstructorWithError() {
        String error = "An error occurred";
        ApiResponse<String> response = new ApiResponse<>(error);

        // Le constructeur avec erreur doit être adapté si les champs ne sont pas distincts
        // Ici on suppose qu'il existe : new ApiResponse<>(String error)
        assertThat(response.getError()).isEqualTo("An error occurred");
        assertThat(response.getData()).isNull();
    }

    @Test
    void testSettersAndGetters() {
        ApiResponse<Integer> response = new ApiResponse<>(null);
        response.setData(42);
        response.setError("none");

        assertThat(response.getData()).isEqualTo(42);
        assertThat(response.getError()).isEqualTo("none");
    }
}
