package com.example.qualite.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ApiResponse<T> {
    private T data;
    private String error;

    public ApiResponse(T data) {
        this.data = data;
    }

    public ApiResponse(String error) {
        this.error = error;
    }

}
