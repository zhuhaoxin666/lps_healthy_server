package com.mysoft.lps_healthy_server.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.mysoft.lps_healthy_server.dao.mapper.*;
import com.mysoft.lps_healthy_server.domain.entity.*;
import com.mysoft.lps_healthy_server.domain.mydo.DoOrderRecord;
import com.mysoft.lps_healthy_server.domain.response.OrderRecordPatResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PatientService {


    @Autowired
    PatientMapper patientMapper;

    @Autowired
    DoctorMapper doctorMapper;

    @Autowired
    PasswordEncoder encoder;

    public boolean addPatient(Patient patient) {
        int count = 0;
        if (patient.getNickName() != null && patient.getPassword() != null && patient.getUsername() != null
                && patient.getIdCard() != null && patient.getPhone() != null && patient.getSex() != null
                && patient.getAge() != null) {

            //  加密密码，存入数据库
            String encodedPassword = encoder.encode(patient.getPassword());
            patient.setPassword(encodedPassword);
            count = patientMapper.insertPatientInfo(patient);
        }
        return count > 0;
    }

    public Patient getPatientInfo(Long patId) {
        if (patId != null) {
            QueryWrapper<Patient> wrapper = new QueryWrapper<>();
            wrapper.eq("pat_id", patId);
            Patient patient = patientMapper.selectOne(wrapper);
            return patient;
        }
        return null;
    }

    public boolean changePatientInfo(Patient patient) {
        Integer count = 0;
        if (patient != null) {
            count = patientMapper.updatePatientInfoByNickName(patient);
        }
        return count > 0;
    }

    @Autowired
    OrderRecordMapper orderRecordMapper;

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    HospitalMapper hospitalMapper;

    public boolean addOrderRecord(DoOrderRecord record) {

        Doctor doctor = doctorMapper.selectDoctorByDocId(record.getDoctorId());

        if (record.getOrderDate().isBefore(doctor.getBeginWorkDate()) || record.getOrderDate().isAfter(doctor.getEndWordDate())) {
            return false;
        }

        Long departId = doctorMapper.getDepartIdByDocId(record.getDoctorId());
        Department department = departmentMapper.selectDepartmentByDepartId(departId);
        record.setDepartName(department.getDepartName());
        Long hosId = departmentMapper.getHosIdByDepartId(departId);
        Hospital hospital = hospitalMapper.selectHospitalByHosId(hosId);
        record.setHosName(hospital.getHosName());
        switch (record.getSurplusNum()) {
            case 1:
                if (doctor.getSurplusNumEight() == 0) {
                    return false;
                }
                doctor.setSurplusNumEight(doctor.getSurplusNumEight() - 1);
                doctorMapper.updateDocInfo(doctor);
                break;
            case 2:
                if (doctor.getSurplusNumNine() == 0) {
                    return false;
                }
                doctor.setSurplusNumNine(doctor.getSurplusNumNine() - 1);
                doctorMapper.updateDocInfo(doctor);
                break;
            case 3:
                if (doctor.getSurplusNumTen() == 0) {
                    return false;
                }
                doctor.setSurplusNumTen(doctor.getSurplusNumTen() - 1);
                doctorMapper.updateDocInfo(doctor);
                break;
            case 4:
                if (doctor.getSurplusNumFourteen() == 0) {
                    return false;
                }
                doctor.setSurplusNumFourteen(doctor.getSurplusNumFourteen() - 1);
                doctorMapper.updateDocInfo(doctor);
                break;
            case 5:
                if (doctor.getSurplusNumFifteen() == 0) {
                    return false;
                }
                doctor.setSurplusNumFifteen(doctor.getSurplusNumFifteen() - 1);
                doctorMapper.updateDocInfo(doctor);
                break;
        }
        int add = orderRecordMapper.insertOrderRecord(record);
        return add > 0;
    }

    public List<OrderRecord> getOrderRecord(Long patId) {

        List<OrderRecord> orderRecords = orderRecordMapper.selectOrderRecordByPatId(patId);
        return orderRecords;
    }

    @Autowired
    ReportRecordMapper reportRecordMapper;
    public List<ReportRecord> getReportRecord(Long patId) {

        List<ReportRecord> orderRecords = reportRecordMapper.selectAllReportRecordByPatId(patId);
        return orderRecords;

    }
}
