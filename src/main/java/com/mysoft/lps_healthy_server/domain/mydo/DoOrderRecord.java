package com.mysoft.lps_healthy_server.domain.mydo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoOrderRecord {

    private LocalDate orderDate;

    private Integer surplusNum;

    private Long patientId;

    private Long doctorId;

    private String hosName;

    private String departName;

}
