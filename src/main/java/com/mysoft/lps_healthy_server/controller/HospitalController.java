package com.mysoft.lps_healthy_server.controller;

import com.alibaba.fastjson.JSON;
import com.mysoft.lps_healthy_server.dao.mapper.DepartmentMapper;
import com.mysoft.lps_healthy_server.dao.mapper.DoctorMapper;
import com.mysoft.lps_healthy_server.dao.mapper.PatientMapper;
import com.mysoft.lps_healthy_server.domain.entity.Hospital;
import com.mysoft.lps_healthy_server.domain.request.AddDoctorRequest;
import com.mysoft.lps_healthy_server.domain.request.ModifyDepartRequest;
import com.mysoft.lps_healthy_server.domain.response.ResponseResult;
import com.mysoft.lps_healthy_server.service.HospitalService;
import com.mysoft.lps_healthy_server.service.UploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/hospital")
public class HospitalController {

    @Autowired
    HospitalService hospitalService;

    @GetMapping("/getAllHospital")
    public ResponseResult<List<Hospital>> getAllHospitalInfo() {

        List<Hospital> allHospital = hospitalService.getAllHospital();
        return new ResponseResult<List<Hospital>>(HttpStatus.OK.value(), "获取全部医院成功", allHospital);
    }

    @Autowired
    UploadService uploadService;

    @PostMapping("/addHospital")
    public ResponseResult<Hospital> addHospital(@RequestParam("hospital")
                                                        String json, @RequestParam("imgFile") MultipartFile imgFile) {
        Hospital hospital = JSON.parseObject(json, Hospital.class);
        boolean flag = false;
        if (hospital != null && imgFile != null) {
            //上传图片生成URL
            String uploadImgUrl = uploadService.uploadImg(imgFile);
            hospital.setHosImgUrl(uploadImgUrl);
            flag = hospitalService.addHospital(hospital);
        }
        if (flag) {
            return new ResponseResult<Hospital>(HttpStatus.OK.value(), "添加医院成功", null);
        } else {
            return new ResponseResult<Hospital>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "添加医院失败", null);
        }
    }


    @PostMapping("/addHospital2")
    public ResponseResult<Hospital> addHospital2(@RequestParam("hosName") String hosName,
                                                 @RequestParam("hosLevel") String hosLevel,
                                                 @RequestParam("hosNature") String hosNature,
                                                 @RequestParam("hosCategory") String hosCategory,
                                                 @RequestParam("hosAddress") String hosAddress,
                                                 @RequestParam("hosIntroduce") String hosIntroduce,
                                                 @RequestParam("hosTelephone") String hosTelephone,
                                                 @RequestParam("imgFile") MultipartFile imgFile) {
        Hospital hospital = new Hospital();
        hospital.setHosName(hosName);
        hospital.setHosLevel(hosLevel);
        hospital.setHosNature(hosNature);
        hospital.setHosCategory(hosCategory);
        hospital.setHosAddress(hosAddress);
        hospital.setHosIntroduce(hosIntroduce);
        hospital.setHosTelephone(hosTelephone);

        boolean flag = false;
        if (hospital != null && imgFile != null) {
            //上传图片生成URL
            String uploadImgUrl = uploadService.uploadImg(imgFile);
            hospital.setHosImgUrl(uploadImgUrl);
            flag = hospitalService.addHospital(hospital);
        }
        if (flag) {
            return new ResponseResult<Hospital>(HttpStatus.OK.value(), "添加医院成功", null);
        } else {
            return new ResponseResult<Hospital>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "添加医院失败", null);
        }
    }

    @PostMapping("/modifyHospital")
    public ResponseResult<Hospital> modifyHospital(@RequestBody Hospital hospital) {
        boolean flag = false;
        if (hospital != null) {
            flag = hospitalService.modifyHospital(hospital);
        }
        if (flag) {
            return new ResponseResult<Hospital>(HttpStatus.OK.value(), "修改医院信息成功", null);
        } else {
            return new ResponseResult<Hospital>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "修改失败", null);
        }
    }

    @PostMapping("/addDepart")
    public ResponseResult<Hospital> addDepartForHospital(@RequestParam("hosName") String hosName, @RequestParam("departName") String departName) {



        boolean flag = false;

        if (hosName != null && departName != null) {

            flag = hospitalService.addDepartment(hosName, departName);
        }
        if (flag) {
            return new ResponseResult<Hospital>(HttpStatus.OK.value(), "添加医院部门成功", null);
        } else {
            return new ResponseResult<Hospital>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "添加医院部门失败", null);
        }
    }

    @PostMapping("/modifyDepart")
    public ResponseResult modifyDepart(@RequestBody ModifyDepartRequest request) {
        boolean flag = false;

        if (request != null) {
            flag = hospitalService.modifyDepart(request);
        }

        if (flag) {
            return new ResponseResult(HttpStatus.OK.value(), "修改医院部门成功");
        } else {
            return new ResponseResult(HttpStatus.INTERNAL_SERVER_ERROR.value(), "修改医院部门失败");
        }

    }


    @Autowired
    DoctorMapper doctorMapper;

    @Autowired
    DepartmentMapper departmentMapper;

    @PostMapping("/addDoctor")
    public ResponseResult insertDoctor(@RequestBody AddDoctorRequest request) {
        boolean flag = false;

        if (request != null) {
            flag = hospitalService.addDoctor(request);
        }

        if (flag) {
            return new ResponseResult(HttpStatus.OK.value(), "添加医生成功");
        } else {
            return new ResponseResult(HttpStatus.INTERNAL_SERVER_ERROR.value(), "添加医生失败");
        }

    }

}

