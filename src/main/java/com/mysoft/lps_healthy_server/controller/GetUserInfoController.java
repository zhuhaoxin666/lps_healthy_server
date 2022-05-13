package com.mysoft.lps_healthy_server.controller;

import com.mysoft.lps_healthy_server.dao.mapper.DoctorMapper;
import com.mysoft.lps_healthy_server.domain.entity.Admin;
import com.mysoft.lps_healthy_server.domain.entity.Doctor;
import com.mysoft.lps_healthy_server.domain.response.ResponseResult;
import com.mysoft.lps_healthy_server.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class GetUserInfoController {

    @Autowired
    DoctorMapper doctorMapper;

    @PostMapping("/getInfo")
    public ResponseResult getUserInfo(HttpServletRequest request) {
        String token = request.getHeader("token");
        Claims claims = null;
        try {
            claims = JwtUtil.parseJWT(token);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String subject = claims.getSubject();

        if (subject.equals("admin")) {
            Admin admin = new Admin();
            admin.setAdminId(1L);
            admin.setUsername("admin");
            admin.setRoles("admin");
            return new ResponseResult<Admin>(HttpStatus.OK.value(), "获取管理员信息成功", admin);
        } else {
            Long docId = Long.valueOf(claims.getId());
            if (docId == null) {
                return new ResponseResult(HttpStatus.INTERNAL_SERVER_ERROR.value(), "内部错误");
            }
            Doctor doctor = doctorMapper.selectDoctorByDocId(docId);
            if(doctor == null)
                return new ResponseResult(HttpStatus.BAD_REQUEST.value(), "未查询到相关医生信息");

            return new ResponseResult<Doctor>(HttpStatus.OK.value(), "查询医生信息成功",doctor);

        }
    }

}
