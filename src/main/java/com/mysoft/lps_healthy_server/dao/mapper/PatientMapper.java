package com.mysoft.lps_healthy_server.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mysoft.lps_healthy_server.domain.entity.Patient;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PatientMapper extends BaseMapper<Patient> {

    int insertPatientInfo(@Param("pat") Patient patient);

    int updatePatientInfoByNickName(@Param("patient") Patient patient);

    Patient selectPatientInfoByNickName(@Param("nickName") String nickName);

}
