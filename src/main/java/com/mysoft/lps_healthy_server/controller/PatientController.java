package com.mysoft.lps_healthy_server.controller;


import com.mysoft.lps_healthy_server.dao.mapper.OrderRecordMapper;
import com.mysoft.lps_healthy_server.domain.entity.OrderRecord;
import com.mysoft.lps_healthy_server.domain.entity.Patient;
import com.mysoft.lps_healthy_server.domain.entity.ReportRecord;
import com.mysoft.lps_healthy_server.domain.mydo.DoOrderRecord;
import com.mysoft.lps_healthy_server.domain.response.OrderRecordPatResponse;
import com.mysoft.lps_healthy_server.domain.response.ResponseResult;
import com.mysoft.lps_healthy_server.service.PatientService;
import com.mysoft.lps_healthy_server.util.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    @PostMapping("/addPatient")
    public ResponseResult<Patient> addPatient(@RequestBody Patient patient) {
        log.debug("注册病人信息===>>>{}", patient);
        boolean result = patientService.addPatient(patient);
        if (result) {
            return new ResponseResult<Patient>(HttpStatus.OK.value(), "注册成功", null);
        } else {
            return new ResponseResult<Patient>(HttpStatus.BAD_REQUEST.value(), "注册信息不完整，请重新输入", null);
        }
    }

    @GetMapping("/getPatientInfo")
    public ResponseResult<Patient> getPatInfo(HttpServletRequest request) {
        String token = request.getHeader("token");

        if (token == null) {
            return new ResponseResult<Patient>(HttpStatus.UNAUTHORIZED.value(), "用户未登录", null);
        }

        Claims parseJWT = null;
        try {
            parseJWT = JwtUtil.parseJWT(token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String IDDD = parseJWT.getId();
        log.debug("JWT转化的病人ID===>>>{}", IDDD);
        Patient patientInfo = patientService.getPatientInfo(Long.valueOf(IDDD));
        if (patientInfo != null) {
            patientInfo.setToken(token);
            return new ResponseResult<Patient>(HttpStatus.OK.value(), "查询病人信息成功", patientInfo);
        } else {
            return new ResponseResult<Patient>(HttpStatus.OK.value(), "查询病人信息失败", null);
        }
    }


    @PostMapping("/changePatientInfo")
    public ResponseResult<Patient> modifyPatientInfo(HttpServletRequest request, @RequestBody Patient patient) {


        String token = request.getHeader("token");

        if (token == null) {
            return new ResponseResult<Patient>(HttpStatus.UNAUTHORIZED.value(), "用户未登录", null);
        }

        Claims parseJWT = null;
        try {
            parseJWT = JwtUtil.parseJWT(token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        patient.setPatId(Long.valueOf(parseJWT.getId()));
        boolean flag = patientService.changePatientInfo(patient);

        if (flag) {
            return new ResponseResult<Patient>(HttpStatus.OK.value(), "修改病人信息成功", null);
        } else {
            return new ResponseResult<Patient>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "修改失败！", null);
        }
    }


    @PostMapping("/addOrder")
    public ResponseResult<OrderRecord> addOrderRecord(HttpServletRequest request, @RequestBody DoOrderRecord record) {


        String token = request.getHeader("token");

        if (token == null) {
            return new ResponseResult<OrderRecord>(HttpStatus.UNAUTHORIZED.value(), "用户未登录", null);
        }

        Claims parseJWT = null;


        try {
            parseJWT = JwtUtil.parseJWT(token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        record.setPatientId(Long.valueOf(parseJWT.getId()));

        boolean flag = patientService.addOrderRecord(record);

        if (flag) {
            return new ResponseResult<OrderRecord>(HttpStatus.OK.value(), "预约成功", null);
        } else {
            return new ResponseResult<OrderRecord>(HttpStatus.BAD_REQUEST.value(), "预约失败,该时段无号源", null);
        }
    }

    @PostMapping("/getOrder")
    public ResponseResult<List<OrderRecord>> getOrderRecord(HttpServletRequest request) {

        String token = request.getHeader("token");

        if (token == null) {
            return new ResponseResult<List<OrderRecord>>(HttpStatus.UNAUTHORIZED.value(), "用户未登录", null);
        }

        Claims parseJWT = null;

        try {
            parseJWT = JwtUtil.parseJWT(token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.debug("查询的病人ID------>>>>>>.{}", parseJWT.getId());

        Long patId = Long.valueOf(parseJWT.getId());
        log.debug("查询的病人ID------>>>>>>.{}", patId);

        List<OrderRecord> orderRecord = patientService.getOrderRecord(patId);

        return new ResponseResult<List<OrderRecord>>(HttpStatus.OK.value(), "查询病人预约记录成功", orderRecord);
    }

    @PostMapping("/getReport")
    public ResponseResult<List<ReportRecord>> getReport(HttpServletRequest request) {
        String token = request.getHeader("token");
        if (token == null)
            return new ResponseResult<List<ReportRecord>>(HttpStatus.UNAUTHORIZED.value(), "用户未登录", null);
        Claims claims = null;
        try {
            claims = JwtUtil.parseJWT(token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Long patId = Long.valueOf(claims.getId());
        List<ReportRecord> reportRecord = patientService.getReportRecord(patId);
        return new ResponseResult<List<ReportRecord>>(HttpStatus.OK.value(),"查询报告成功",reportRecord);
    }

}
