package com.mysoft.lps_healthy_server.domain.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddDoctorRequest {

    private String hosName;

    private String departName;

    private String nickName;

    private String docName;

    private String password;

    private String docLevel;

    private String role;


}
