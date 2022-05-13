package com.mysoft.lps_healthy_server.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mysoft.lps_healthy_server.dao.mapper.AdminMapper;
import com.mysoft.lps_healthy_server.dao.mapper.DoctorMapper;
import com.mysoft.lps_healthy_server.domain.entity.Admin;
import com.mysoft.lps_healthy_server.domain.entity.Doctor;
import com.mysoft.lps_healthy_server.domain.mydo.ResponseLoginDto;
import com.mysoft.lps_healthy_server.domain.request.DoctorLoginRequest;
import com.mysoft.lps_healthy_server.domain.request.LoginRequest;
import com.mysoft.lps_healthy_server.domain.response.ResponseResult;
import com.mysoft.lps_healthy_server.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/user")
@RestController
public class LoginController {

    @Autowired
    AdminMapper adminMapper;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    DoctorMapper doctorMapper;

    @PostMapping("/login")
    public ResponseResult<ResponseLoginDto> login(@RequestBody LoginRequest loginForm) {

        //管理员
        if (loginForm.getUsername().equals("admin")) {
            Admin admin = null;
            ResponseLoginDto responseLoginDto = new ResponseLoginDto();
            QueryWrapper<Admin> wrapper = new QueryWrapper<>();
            wrapper.eq("username", loginForm.getUsername());
            admin = adminMapper.selectOne(wrapper);
            if (admin == null) {
                return new ResponseResult<ResponseLoginDto>(HttpStatus.UNAUTHORIZED.value(), "该用户不存在", null);
            }
            if (encoder.matches(loginForm.getPassword(), admin.getPassword())) {
                String jwt = JwtUtil.createJWT(String.valueOf(admin.getAdminId()), "admin", JwtUtil.JWT_TTL);
                responseLoginDto.setToken(jwt);
                responseLoginDto.setRoles("admin");
                return new ResponseResult<ResponseLoginDto>(HttpStatus.OK.value(), "登录成功", responseLoginDto);
            } else {
                return new ResponseResult<ResponseLoginDto>(HttpStatus.UNAUTHORIZED.value(), "用户名或密码错误", null);
            }

        } else { //医生
            Doctor doctor = doctorMapper.selectDoctorByDocNickName(loginForm.getUsername());

            ResponseLoginDto dto = new ResponseLoginDto();

            if (doctor == null) {
                return new ResponseResult<ResponseLoginDto>(HttpStatus.UNAUTHORIZED.value(), "用户名或密码错误", null);
            }

            if (encoder.matches(loginForm.getPassword(), doctor.getPassword())) {
                String jwt = JwtUtil.createJWT(String.valueOf(doctor.getDocId()), "doctor", JwtUtil.JWT_TTL);
                dto.setToken(jwt);
                dto.setRoles("doctor");
                return new ResponseResult<ResponseLoginDto>(HttpStatus.OK.value(), "登录成功", dto);
            } else {
                return new ResponseResult<ResponseLoginDto>(HttpStatus.UNAUTHORIZED.value(), "用户名或密码错误", null);
            }

        }
    }
}
