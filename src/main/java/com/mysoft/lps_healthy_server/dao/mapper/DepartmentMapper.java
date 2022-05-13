package com.mysoft.lps_healthy_server.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mysoft.lps_healthy_server.domain.entity.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DepartmentMapper extends BaseMapper<Department> {

    void insertDepartment(@Param("depart") Department department,@Param("hospitalId") Long hosId);

    Long selectDepartmentIdByDepartNameAndHosId(@Param("departName") String departName,@Param("hosId") Long hosId);

    Department selectDepartmentByDepartId(@Param("departId") Long departId);

    List<Department> selectDepartmentsByHosId(Long hosId);

    int insertDepartmentWithHosId(@Param("hosId") Long hosId,@Param("departmentName") String departmentName);

    int updateDepartmentWithHosId(@Param("hosId")Long hosId,@Param("oldName") String oldName,@Param("newName")String newName);

    int deleteDepartmentByHosIdAndDepartmentName(@Param("hosId") Long hosId,@Param("departName") String departName);

    Long getHosIdByDepartId(@Param("departId") Long departId);
}