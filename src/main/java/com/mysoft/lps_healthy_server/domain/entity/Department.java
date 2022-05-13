package com.mysoft.lps_healthy_server.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Department implements Serializable {

    /**
     *  科室id
    */
    private Long departId;

    /**
     *  科室名称
    */
    private String departName;

    /**
     *  所属医院
     */
    private Hospital hospital;

    /**
     *  科室医生
     */
    private List<Doctor> doctors;

}
