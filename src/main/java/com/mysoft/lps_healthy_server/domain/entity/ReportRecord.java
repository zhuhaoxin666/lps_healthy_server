package com.mysoft.lps_healthy_server.domain.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReportRecord {

    private Long reportId;

    private Patient patient;

    private Doctor doctor;

    private String hosName;

    private String departName;

    /**
     * 就诊时间
     */
    private LocalDate treatmentDate;

    /**
     * 报告URL
     */
    private String reportUrl;

    /**
     * 诊断记录
     */
    private String treatmentRecord;

}