package com.mysoft.lps_healthy_server.handler;

import com.mysoft.lps_healthy_server.domain.response.ResponseResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MyExceptionHandler {

//    @ExceptionHandler(value =Exception.class)
//    @ResponseBody
//    public ResponseResult exceptionHandler(Exception e){
//        System.out.println("全局异常捕获>>>:"+e);
//        if(e.getMessage().contains("patient_id_card_uindex")){
//            return new ResponseResult(HttpStatus.BAD_REQUEST.value(), "该身份证已注册");
//        }else if(e.getMessage().contains("patient_nick_name_uindex")){
//            return new ResponseResult(HttpStatus.BAD_REQUEST.value(), "该用户名已注册");
//        }
//        return  new ResponseResult(HttpStatus.BAD_REQUEST.value(), "出错了，稍后再来试试吧！");
//    }

}
