package com.mysoft.lps_healthy_server;

import com.mysoft.lps_healthy_server.dao.mapper.DoctorMapper;
import com.mysoft.lps_healthy_server.dao.mapper.PatientMapper;
import com.mysoft.lps_healthy_server.domain.entity.Doctor;
import com.mysoft.lps_healthy_server.domain.entity.Patient;
import com.mysoft.lps_healthy_server.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class JwtTest {

    @Autowired
    PatientMapper patientMapper;

    @Test
    void testJwt() throws Exception {
        Patient zhx = patientMapper.selectPatientInfoByNickName("zhx");
        System.out.println(zhx);
        String patient = JwtUtil.createJWT(zhx.getPatId().toString(), "patient", JwtUtil.JWT_TTL);
        System.out.println(patient);
        Claims claims = JwtUtil.parseJWT(patient);
        System.out.println(claims.getId());
        System.out.println(claims.getSubject());

    }

    @Test
    void test01(){
        int sum = 0;
        String str = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIzIiwic3ViIjoicGF0aWVudCIsImlzcyI6InNnIiwiaWF0IjoxNjUxNTkzNDI3LCJleHAiOjE2NTE1OTcwMjd9.SPOykwGSX9LkD3SOPU1VTq-lEPJhSSSCZdb4UuB9w6A";
        for(int i=0;i<str.length();i++){
            sum+=1;
        }
        System.out.println(sum);
    }


    @Autowired
    PasswordEncoder encoder;


    @Autowired
    DoctorMapper doctorMapper;

    @Test
    void test02(){

        Doctor doctor = doctorMapper.selectDoctorByDocNickName("wxy01");
        System.out.println(encoder.matches("123456", doctor.getPassword()));

    }
}
