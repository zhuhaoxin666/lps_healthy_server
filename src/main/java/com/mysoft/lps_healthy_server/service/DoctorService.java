package com.mysoft.lps_healthy_server.service;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.mysoft.lps_healthy_server.dao.mapper.DepartmentMapper;
import com.mysoft.lps_healthy_server.dao.mapper.DoctorMapper;
import com.mysoft.lps_healthy_server.dao.mapper.HospitalMapper;
import com.mysoft.lps_healthy_server.dao.mapper.ReportRecordMapper;
import com.mysoft.lps_healthy_server.domain.entity.Department;
import com.mysoft.lps_healthy_server.domain.entity.Doctor;
import com.mysoft.lps_healthy_server.domain.entity.Hospital;
import com.mysoft.lps_healthy_server.domain.mydo.DoReportRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class DoctorService {

    @Autowired
    DoctorMapper doctorMapper;

    @Autowired
    UploadService uploadService;

    @Autowired
    ReportRecordMapper reportRecordMapper;

    public boolean modifyDoctorInfo(Doctor doctor) {
        if (doctor == null) return false;

        UpdateWrapper<Doctor> wrapper = new UpdateWrapper<>();
        wrapper.eq("doc_id", doctor.getDocId());
        int update = doctorMapper.update(doctor, wrapper);
        return update > 0;
    }

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    HospitalMapper hospitalMapper;



    public boolean addReport(Long docId, DoReportRecord reportRecord, MultipartFile file) {

        Long departId = doctorMapper.getDepartIdByDocId(docId);
        Department department = departmentMapper.selectDepartmentByDepartId(departId);
        reportRecord.setDepartName(department.getDepartName());
        Long hosId = departmentMapper.getHosIdByDepartId(departId);
        Hospital hospital = hospitalMapper.selectHospitalByHosId(hosId);
        reportRecord.setHosName(hospital.getHosName());

        reportRecord.setDoctorId(docId);
        String uploadImgUrl = uploadService.uploadImg(file);
        reportRecord.setReportUrl(uploadImgUrl);
        int add = reportRecordMapper.insertReportRecord(reportRecord);
        return add > 0;
    }
}
