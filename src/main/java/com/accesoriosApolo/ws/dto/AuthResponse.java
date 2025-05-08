package com.accesoriosApolo.ws.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Respuesta con el token JWT tras autenticación exitosa")
public class AuthResponse {

    @Schema(description = "Token JWT", example = "eyJhbGciOiJIUzI1NiIsInR...")
    private String token;

    public AuthResponse() {
    }

    public AuthResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
