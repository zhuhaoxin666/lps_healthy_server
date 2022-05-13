package com.mysoft.lps_healthy_server.controller;

import com.mysoft.lps_healthy_server.dao.mapper.PatientMapper;
import com.mysoft.lps_healthy_server.domain.entity.Patient;
import com.mysoft.lps_healthy_server.domain.request.PatientLoginRequest;
import com.mysoft.lps_healthy_server.domain.response.ResponseResult;
import com.mysoft.lps_healthy_server.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/patient")
@Slf4j
public class PatientLoginController {

    @Autowired
    PatientMapper patientMapper;

    @Autowired
    PasswordEncoder encoder;

    @PostMapping("/login")
    public ResponseResult<Patient> Login(@RequestBody PatientLoginRequest request) {

        log.debug("传入的信息: 用户名：==>> {},密码===>>>{}",request.getNickName(),request.getPassword());
        Patient patient = null;
        if (request.getNickName() != null && request.getPassword() != null) {
            patient = patientMapper.selectPatientInfoByNickName(request.getNickName());

            if(patient == null){
                return new ResponseResult<Patient>(HttpStatus.UNAUTHORIZED.value(), "该用户不存在",null);
            }

            log.debug("查询的病人信息: ===>>> {}",patient);
            boolean flag;
            if(flag = encoder.matches(request.getPassword(),patient.getPassword())){

                log.debug("flag ===>>> {}",flag);

                String jwt = JwtUtil.createJWT(String.valueOf(patient.getPatId()),"patient",JwtUtil.JWT_TTL);
                log.debug("token ===>>> {}");
                patient.setToken(jwt);

                log.debug("查询的病人信息: ===>>> {}",patient);

                return new ResponseResult<Patient>(HttpStatus.OK.value(), "登录成功",patient);
            }else{
                return new ResponseResult<Patient>(HttpStatus.UNAUTHORIZED.value(), "用户名或密码错误",null);
            }

        } else {
            return new ResponseResult<Patient>(HttpStatus.UNAUTHORIZED.value(), "用户名或密码为空", null);
        }
    }

}
