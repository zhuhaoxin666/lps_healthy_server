package com.mysoft.lps_healthy_server;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Test{

    public static void main(String[] args){

        String str = "2022-5-8";

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date parse = dateFormat.parse(str);
            String format = dateFormat.format(parse);
            System.out.println(parse);
            System.out.println(format);
            LocalDate parse1 = LocalDate.parse(format);
            System.out.println(parse1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


}