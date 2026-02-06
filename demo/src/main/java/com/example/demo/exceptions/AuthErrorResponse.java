package com.example.demo.exceptions;

public record AuthErrorResponse(String timestamp, int status, String error, String message, String path) {
}
