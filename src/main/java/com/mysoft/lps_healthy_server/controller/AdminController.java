package com.mysoft.lps_healthy_server.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mysoft.lps_healthy_server.dao.mapper.AdminMapper;
import com.mysoft.lps_healthy_server.dao.mapper.DoctorMapper;
import com.mysoft.lps_healthy_server.domain.entity.Admin;
import com.mysoft.lps_healthy_server.domain.mydo.DoManageDocWorkTime;
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

@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminMapper adminMapper;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    DoctorMapper doctorMapper;

    @PostMapping("/updateDocWorkInfo")
    public ResponseResult manageDocInfo(@RequestBody DoManageDocWorkTime workTime){


        int update = doctorMapper.updateDocWorkTime(workTime);
        if(update > 0){
            return new ResponseResult(HttpStatus.OK.value(), "排班成功");
        }else {
            return new ResponseResult(HttpStatus.INTERNAL_SERVER_ERROR.value(), "排班失败，请稍后再试");
        }

    }

    @PostMapping("/test")
    public String test(){

        return "test";
    }


    @PostMapping("/login")
    public ResponseResult<Admin> Login(@RequestBody Admin request) {
        Admin admin = null;
        if (request.getUsername() != null && request.getPassword() != null) {
            QueryWrapper<Admin> wrapper = new QueryWrapper<>();
            wrapper.eq("username",request.getUsername());
            admin = adminMapper.selectOne(wrapper);

            if(admin == null){
                return new ResponseResult<Admin>(HttpStatus.UNAUTHORIZED.value(), "该用户不存在",admin);
            }

            boolean flag;
            if(flag = encoder.matches(request.getPassword(), admin.getPassword())){
                String jwt = JwtUtil.createJWT(String.valueOf(admin.getAdminId()),"admin",JwtUtil.JWT_TTL);
                admin.setToken(jwt);

                return new ResponseResult<Admin>(HttpStatus.OK.value(), "登录成功",admin);

            }else{
                return new ResponseResult<Admin>(HttpStatus.UNAUTHORIZED.value(), "用户名或密码错误",null);
            }
        }else {
            return new ResponseResult<Admin>(HttpStatus.UNAUTHORIZED.value(), "用户名或密码为空", null);
        }

    }

}
