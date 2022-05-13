package com.mysoft.lps_healthy_server.domain.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorLoginRequest {

    private String nickName;

    private String password;
}
