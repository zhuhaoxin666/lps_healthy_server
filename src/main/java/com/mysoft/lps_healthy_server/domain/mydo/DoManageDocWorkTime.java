package com.mysoft.lps_healthy_server.domain.mydo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoManageDocWorkTime {

    private Long docId;

    private LocalDate beginWorkDate;

    private LocalDate endWorkDate;

    private BigDecimal decimal;

    private Integer surplusNumEight;

    private Integer surplusNumNine;

    private Integer surplusNumTen;

    private Integer surplusNumFourteen;

    private Integer surplusNumFifteen;
}
