package com.mysoft.lps_healthy_server.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mysoft.lps_healthy_server.domain.entity.Hospital;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HospitalMapper extends BaseMapper<Hospital> {

    int insertHospital(Hospital hospital);

    Long selectHosIdByName(@Param("hosName") String hosName);

    Hospital selectHospitalByHosId(@Param("hosId") Long hosId);

    List<Hospital> getAllHospital();

    Hospital selectHosInfoByHosName(String hosName);

    int updateHospitalByHosId( Hospital hospital);
}
