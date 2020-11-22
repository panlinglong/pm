package com.yzy.pmservice.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Empdeal {
    /** id*/
    private Integer id;

    /** 坐落于*/
    private String place;

    /** 甲方*/
    private String jiafang;

    /**不用 */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date birthday;

    /** 乙方*/
    private String yifang;

    /** 甲方身份证*/
    private String jsfz;

    /** 乙方身份证*/
    private String ysfz;

    /** 甲方电话*/
    private String phone1;

    /** 乙方电话*/
    private String phone2;

    /** 成交时间*/
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date beginDate;

    /** 编号*/
    private String workid;

    /** 总价*/
    private String price1;

    /** 总付款*/
    private String price2;

    private String upname;

    /** 合同录入*/
    private String details;

    /** 应收佣金*/
    private String price3;

    /** 实收佣金*/
    private String price4;

    /** 是否退佣*/
    private String tuiyong;

    public String getTuiyong() {
        return tuiyong;
    }

    public void setTuiyong(String tuiyong) {
        this.tuiyong = tuiyong;
    }

    public String getUpname() {
        return upname;
    }

    public void setUpname(String upname) {
        this.upname = upname;
    }

    public String getPrice3() {
        return price3;
    }

    public void setPrice3(String price3) {
        this.price3 = price3;
    }

    public String getPrice4() {
        return price4;
    }

    public void setPrice4(String price4) {
        this.price4 = price4;
    }

    public String getJsfz() {
        return jsfz;
    }

    public void setJsfz(String jsfz) {
        this.jsfz = jsfz;
    }

    public String getYsfz() {
        return ysfz;
    }

    public void setYsfz(String ysfz) {
        this.ysfz = ysfz;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getJiafang() {
        return jiafang;
    }

    public void setJiafang(String jiafang) {
        this.jiafang = jiafang;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getYifang() {
        return yifang;
    }

    public void setYifang(String yifang) {
        this.yifang = yifang;
    }



    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public String getWorkid() {
        return workid;
    }

    public void setWorkid(String workid) {
        this.workid = workid;
    }

    public String getPrice1() {
        return price1;
    }

    public void setPrice1(String price1) {
        this.price1 = price1;
    }

    public String getPrice2() {
        return price2;
    }

    public void setPrice2(String price2) {
        this.price2 = price2;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
