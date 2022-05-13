package com.mysoft.lps_healthy_server.domain.mydo;

import lombok.*;

import java.io.Serializable;


public class ResponseLoginDto implements Serializable {

    public ResponseLoginDto() {
    }

    public ResponseLoginDto(String token, String roles) {
        this.token = token;
        this.roles = roles;
    }

    private String token;

    private String roles;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
