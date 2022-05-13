package com.mysoft.lps_healthy_server.domain.entity;

import lombok.Data;

import java.time.LocalDate;

/**
 * 预约记录
 */

@Data
public class OrderRecord {

    /**
     * 记录id
     */
    private Long orderId;

    /**
     * 该记录对应的病人
     */
    private Patient patient;

    /**
     * 该记录对应的医生
     */
    private Doctor doctor;

    private Department department;

    private Hospital hospital;

    /**
     * 该记录的预约日期
     */
    private LocalDate orderDate;

    /**
     * 该记录对应的时段号码
     */
    private Integer surplusNum;

    private String hosName;

    private String departName;

}
