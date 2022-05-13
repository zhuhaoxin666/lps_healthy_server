package com.mysoft.lps_healthy_server.controller;

import com.mysoft.lps_healthy_server.dao.mapper.DoctorMapper;
import com.mysoft.lps_healthy_server.domain.entity.Doctor;
import com.mysoft.lps_healthy_server.domain.request.DoctorLoginRequest;
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
@Slf4j
@RequestMapping("/doctor")
public class DoctorLoginController {

    @Autowired
    DoctorMapper doctorMapper;

    @Autowired
    PasswordEncoder encoder;

    @PostMapping("/login")
    public ResponseResult<Doctor> Login(@RequestBody DoctorLoginRequest request) {
        Doctor doctor = null;
        if (request.getNickName() != null && request.getPassword() != null) {
            doctor = doctorMapper.selectDoctorByDocNickName(request.getNickName());

            if(doctor == null){
                return new ResponseResult<Doctor>(HttpStatus.UNAUTHORIZED.value(), "该用户不存在",null);
            }

            boolean flag;
            if(flag = encoder.matches(request.getPassword(), doctor.getPassword())){
                String jwt = JwtUtil.createJWT(String.valueOf(doctor.getDocId()),"doctor",JwtUtil.JWT_TTL);
                doctor.setToken(jwt);

                return new ResponseResult<Doctor>(HttpStatus.OK.value(), "登录成功",doctor);

            }else{
                return new ResponseResult<Doctor>(HttpStatus.UNAUTHORIZED.value(), "用户名或密码错误",null);
            }
        }else {
            return new ResponseResult<Doctor>(HttpStatus.UNAUTHORIZED.value(), "用户名或密码为空", null);
        }

    }


}
