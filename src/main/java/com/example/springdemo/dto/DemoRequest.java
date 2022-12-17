package com.example.springdemo.dto;
import jakarta.validation.constraints.NotEmpty;

public record DemoRequest (
        @NotEmpty(message = "Name is required")
        String name
)
{}
