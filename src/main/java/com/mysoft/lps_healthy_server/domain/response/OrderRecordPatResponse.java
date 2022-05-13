package com.mysoft.lps_healthy_server.domain.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRecordPatResponse {

    private Long id;

    private String hosName;

    private String department;

    private String patientName;

    private String doctorName;

    private LocalDate orderDate;

    private Integer surplusNum;


}
