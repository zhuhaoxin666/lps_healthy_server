package com.mysoft.lps_healthy_server.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mysoft.lps_healthy_server.dao.mapper.OrderRecordMapper;
import com.mysoft.lps_healthy_server.domain.entity.Doctor;
import com.mysoft.lps_healthy_server.domain.entity.OrderRecord;
import com.mysoft.lps_healthy_server.domain.mydo.DoReportRecord;
import com.mysoft.lps_healthy_server.domain.response.ResponseResult;
import com.mysoft.lps_healthy_server.service.DoctorService;
import com.mysoft.lps_healthy_server.util.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @Autowired
    PasswordEncoder encoder;

    @PostMapping("/modifyDoctorInfo")
    public ResponseResult modifyDoctorInfo(@RequestBody Doctor doctor, HttpServletRequest request) {
        String token = request.getHeader("token");
        if (token == null) {
            return new ResponseResult(HttpStatus.UNAUTHORIZED.value(), "用户未登录");
        }

        //更改密码
        if (doctor.getPassword() != null) {
            String encode = encoder.encode(doctor.getPassword());
            doctor.setPassword(encode);
        }

        Claims claims = null;
        Long doctorId = 0L;
        boolean flag = false;
        try {
            claims = JwtUtil.parseJWT(token);
            doctorId = Long.valueOf(claims.getId());
            doctor.setDocId(doctorId);
            flag = doctorService.modifyDoctorInfo(doctor);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (flag) {
            return new ResponseResult(HttpStatus.OK.value(), "修改医生信息成功");
        } else {
            return new ResponseResult(HttpStatus.INTERNAL_SERVER_ERROR.value(), "修改医生信息失败");
        }
    }


    @Autowired
    OrderRecordMapper mapper;

    @PostMapping("/getPatientOrder")
    public ResponseResult<List<OrderRecord>> getPatientOrder(HttpServletRequest request) {

        String token = request.getHeader("token");
        Claims claims = null;
        List<OrderRecord> orderRecords = null;
        try {
            claims = JwtUtil.parseJWT(token);
            Long docId = Long.valueOf(claims.getId());
            orderRecords = mapper.selectOrderRecordByDocId(docId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (orderRecords == null) {
            return new ResponseResult<List<OrderRecord>>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "暂无数据", null);
        }

        return new ResponseResult<List<OrderRecord>>(HttpStatus.OK.value(), "获取病人队列成功", orderRecords);
    }


    @PostMapping("/addRepot")
    public ResponseResult addReport(HttpServletRequest request, @RequestParam("reportRecord") String json, @RequestParam("file") MultipartFile file) {
        String token = request.getHeader("token");

        DoReportRecord reportRecord = JSON.parseObject(json, DoReportRecord.class);


        if (token == null) {
            return new ResponseResult(HttpStatus.UNAUTHORIZED.value(), "用户未登录");
        }

        Claims claims = null;

        try {
            claims = JwtUtil.parseJWT(token);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Long docId = Long.valueOf(claims.getId());

        if (file == null || reportRecord == null || token == null) {
            return new ResponseResult(HttpStatus.BAD_REQUEST.value(), "请求参数错误，文件未上传");
        }

        boolean addReport = doctorService.addReport(docId, reportRecord, file);
        if (addReport) {
            return new ResponseResult(HttpStatus.OK.value(), "提交报告成功");
        } else {
            return new ResponseResult(HttpStatus.INTERNAL_SERVER_ERROR.value(), "提交报告失败");
        }
    }

    @PostMapping("/addRepot2")
    public ResponseResult addReport2(HttpServletRequest request,
                                     @RequestParam("treatmentDate")String date,@RequestParam("treatmentRecord") String treatmentRecord,
                                     @RequestParam("patientId") String patientId,
                                     @RequestParam("file") MultipartFile file) {
        String token = request.getHeader("token");
        LocalDate localDate = LocalDate.parse(date);
        DoReportRecord reportRecord = new DoReportRecord();

        reportRecord.setTreatmentDate(localDate);
        reportRecord.setPatientId(Long.valueOf(patientId));
        reportRecord.setTreatmentRecord(treatmentRecord);

        if (token == null) {
            return new ResponseResult(HttpStatus.UNAUTHORIZED.value(), "用户未登录");
        }

        Claims claims = null;

        try {
            claims = JwtUtil.parseJWT(token);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Long docId = Long.valueOf(claims.getId());

        if (file == null || reportRecord == null || token == null) {
            return new ResponseResult(HttpStatus.BAD_REQUEST.value(), "请求参数错误，文件未上传");
        }

        boolean addReport = doctorService.addReport(docId, reportRecord, file);
        if (addReport) {
            return new ResponseResult(HttpStatus.OK.value(), "提交报告成功");
        } else {
            return new ResponseResult(HttpStatus.INTERNAL_SERVER_ERROR.value(), "提交报告失败");
        }
    }


}
