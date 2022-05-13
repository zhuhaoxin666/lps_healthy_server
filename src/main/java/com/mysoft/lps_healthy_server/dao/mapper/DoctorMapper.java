package com.mysoft.lps_healthy_server.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mysoft.lps_healthy_server.domain.entity.Doctor;
import com.mysoft.lps_healthy_server.domain.mydo.DoManageDocWorkTime;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DoctorMapper extends BaseMapper<Doctor> {

    int insertDoctor(@Param("doctor") Doctor doctor,@Param("departmentId") Long departmentId,@Param("hosId") Long hosId);

    Doctor selectDoctorByDocId(@Param("docId") Long docId);

    List<Doctor> selectDoctorByDepartId(@Param("departId") Long departId);

    /**删除整个科室的医生*/
    int deleteDoctorsByDepartmentId(@Param("departId") Long departId);

    int deleteOneDoctorByDocNickName(@Param("docNickName") String docNickName);

    Doctor selectDoctorByDocNickName(@Param("nickName") String nickName);

    int updateDocInfo(@Param("doctor") Doctor doctor);

    Long getDepartIdByDocId(@Param("docId") Long docId);

    int updateDocWorkTime(@Param("workTime")DoManageDocWorkTime workTime);
}
