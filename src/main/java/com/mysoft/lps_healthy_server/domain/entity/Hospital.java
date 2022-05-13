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
public class Hospital implements Serializable {

    /**
     * 医院id
     */
    private Long hosId;

    /**
     * 医院名称
     */
    private String hosName;

    /**
     * 医院等级（三甲、三乙、二甲、二乙）
     */
    private String hosLevel;

    /**
     * 医院性质（公立，私立）
     */
    private String hosNature;

    /**
     * 医院类别（综合，专科）
     */
    private String hosCategory;

    /**
     * 医院地址
     */
    private String hosAddress;


    /**
     * 医院科室
     */

    private List<Department> departments;

    /**
     * 医院介绍
     */
    private String hosIntroduce;

    /**
     * 医院图片
     */
    private String hosImgUrl;

    /**
     *  医院电话
     */
    private String hosTelephone;

}
