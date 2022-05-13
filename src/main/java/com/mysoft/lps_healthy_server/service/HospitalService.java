package com.mysoft.lps_healthy_server.service;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.mysoft.lps_healthy_server.dao.mapper.DepartmentMapper;
import com.mysoft.lps_healthy_server.dao.mapper.DoctorMapper;
import com.mysoft.lps_healthy_server.dao.mapper.HospitalMapper;
import com.mysoft.lps_healthy_server.domain.entity.Doctor;
import com.mysoft.lps_healthy_server.domain.entity.Hospital;
import com.mysoft.lps_healthy_server.domain.request.AddDoctorRequest;
import com.mysoft.lps_healthy_server.domain.request.ModifyDepartRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class HospitalService {

    @Autowired
    HospitalMapper hospitalMapper;

    public List<Hospital> getAllHospital() {
        return hospitalMapper.getAllHospital();
    }

    public boolean addHospital(Hospital hospital) {
        int count = hospitalMapper.insertHospital(hospital);
        return count > 0;
    }


    public boolean modifyHospital(Hospital hospital) {

        UpdateWrapper<Hospital> wrapper = new UpdateWrapper<>();
        wrapper.eq("hos_name", hospital.getHosName());

        int count = hospitalMapper.update(hospital, wrapper);
        return count > 0;
    }

    @Autowired
    DepartmentMapper departmentMapper;

    public boolean addDepartment(String hosName, String departName) {
        Long aLong = hospitalMapper.selectHosIdByName(hosName);
        int insert = 0;
        if (aLong != null) {
            insert = departmentMapper.insertDepartmentWithHosId(aLong, departName);
        }
        return insert > 0;
    }

    public boolean modifyDepart(ModifyDepartRequest request) {
        Long aLong = hospitalMapper.selectHosIdByName(request.getHosName());
        int update = 0;
        if (aLong != null) {
            update = departmentMapper.updateDepartmentWithHosId(aLong, request.getOldDepartName(), request.getNewDepartName());
        }
        return update > 0;
    }

    @Autowired
    DoctorMapper doctorMapper;

    @Autowired
    PasswordEncoder encoder;

    public boolean addDoctor(AddDoctorRequest request) {
        Long hosId = hospitalMapper.selectHosIdByName(request.getHosName());
        Long departId = departmentMapper.selectDepartmentIdByDepartNameAndHosId(request.getDepartName(), hosId);
        Doctor doctor = new Doctor();
        doctor.setNickName(request.getNickName());
        doctor.setDocName(request.getDocName());
        String password = request.getPassword();
        String encode = encoder.encode(password);
        doctor.setPassword(encode);
        doctor.setDocLevel(request.getDocLevel());
        doctor.setRoles(request.getRole());
        int insert = 0;
        if (hosId != null && departId != null) {
            insert = doctorMapper.insertDoctor(doctor, departId, hosId);
        }

        return insert > 0;
    }
}
