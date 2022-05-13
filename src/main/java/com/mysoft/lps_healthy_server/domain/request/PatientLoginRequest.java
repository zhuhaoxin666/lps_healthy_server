package com.mysoft.lps_healthy_server.domain.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientLoginRequest {

    private String nickName;

    private String password;

}
