package com.example.app.builders;

import java.time.LocalDateTime;
import java.util.Map;

import lombok.Data;

@Data
public class ErrorResponse {
    private final LocalDateTime timeStamp = LocalDateTime.now();

    private int status;

    private Map<String, String> errors;

    private String ruta;

}
