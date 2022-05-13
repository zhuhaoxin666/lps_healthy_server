package com.mysoft.lps_healthy_server.domain.entity;

/**
 *  具体时间类
 * */
public enum TimeEnum {

    Eight(1,"8:00~8:45"),
    Nine(2,"9:00~9:45"),
    Ten(3,"10:00~10:30"),
    fourteen(4,"14:00~15:00"),
    fifteen(5,"15:00~16:00");


    TimeEnum(int timeNumber,String time){
            this.timeNumber = timeNumber;
            this.time = time;
    }

    private int timeNumber;
    private String time;


    public int getTimeNumber() {
        return timeNumber;
    }

    public String getTime() {
        return time;
    }
}
