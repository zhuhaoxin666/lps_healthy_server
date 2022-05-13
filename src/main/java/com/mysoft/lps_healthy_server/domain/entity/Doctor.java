package com.mysoft.lps_healthy_server.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.yaml.snakeyaml.events.Event;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Doctor implements Serializable {


    private Long docId;

    private String nickName;

    private String docName;

    private String password;

    @TableField(exist = false)
    private String token;

    /**
     * 医生级别
     */
    private String docLevel;

    /**
     * 排班开始时间
     */
    private LocalDate beginWorkDate;


    /**
     * 排班结束时间
     */
    private LocalDate endWordDate;

    /**
     * 医生所属部门
     */
    private Department department;


    /**
     * 诊疗费用
     */
    private BigDecimal price;

    /**
     * 用户角色
     */
    private String roles = "doctor";


    /**
     * 余号：8：00 ~ 8：45
     */
    private Integer surplusNumEight;

    /**
     * 余号：9：00 ~ 9：45
     */
    private Integer surplusNumNine;

    /**
     * 余号：10：00 ~ 10：30
     */
    private Integer surplusNumTen;

    /**
     * 余号：14:00~15:00
     */
    private Integer surplusNumFourteen;

    /**
     * 余号：15:00~16:00
     */
    private Integer surplusNumFifteen;


    public Long getDocId() {
        return docId;
    }

    public void setDocId(Long docId) {
        this.docId = docId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getDocLevel() {
        return docLevel;
    }

    public void setDocLevel(String docLevel) {
        this.docLevel = docLevel;
    }

    public LocalDate getBeginWorkDate() {
        return beginWorkDate;
    }

    public void setBeginWorkDate(LocalDate beginWorkDate) {
        this.beginWorkDate = beginWorkDate;
    }

    public LocalDate getEndWordDate() {
        return endWordDate;
    }

    public void setEndWordDate(LocalDate endWordDate) {
        this.endWordDate = endWordDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public Integer getSurplusNumEight() {
        return surplusNumEight;
    }

    public void setSurplusNumEight(Integer surplusNumEight) {
        this.surplusNumEight = surplusNumEight;
    }

    public Integer getSurplusNumNine() {
        return surplusNumNine;
    }

    public void setSurplusNumNine(Integer surplusNumNine) {
        this.surplusNumNine = surplusNumNine;
    }

    public Integer getSurplusNumTen() {
        return surplusNumTen;
    }

    public void setSurplusNumTen(Integer surplusNumTen) {
        this.surplusNumTen = surplusNumTen;
    }

    public Integer getSurplusNumFourteen() {
        return surplusNumFourteen;
    }

    public void setSurplusNumFourteen(Integer surplusNumFourteen) {
        this.surplusNumFourteen = surplusNumFourteen;
    }

    public Integer getSurplusNumFifteen() {
        return surplusNumFifteen;
    }

    public void setSurplusNumFifteen(Integer surplusNumFifteen) {
        this.surplusNumFifteen = surplusNumFifteen;
    }
}
