package com.example.qualite.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApiResponse<T> {
    private T data;
    private String error;

    public ApiResponse(T data) {
        this.data = data;
    }

    public ApiResponse(String error) {
        this.error = error;
    }

    public ApiResponse(T data, String error) {
        this.data = data;
        this.error = error;
    }
}