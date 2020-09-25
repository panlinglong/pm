package com.yzy.pmservice.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class Employee {
    /** id*/
    private Integer id;

    /** 小区名称*/
    private String name;

    /** 是否满2*/
    private String gender;

    /**不用 */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date birthday;

    /** 房号*/
    private String idcard;

    /** 面积*/
    private String email;

    /** 接待人*/
    private String people;

    /** 电话*/
    private String phone2;

    /** 不用*/
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date begindate;

    /** 编号*/
    private String workid;

    /** 车库车位*/
    private String car;

    /** 装修毛坯*/
    private String reno;

    /** 价格*/
    private String price;

    /** 看房时间*/
    private String looktime;

    /** 上门介绍*/
    private String intr;

    /** 学区*/
    private String xuequ;

    /** 几室*/
    private String jsjt1;

    /** 几厅*/
    private String jsjt2;

    /** 几卫*/
    private String jsjt3;

    /** 房源状态*/
    private String xingz;

    /** 备注*/
    private String remarks;

    List<Imgpath> imgpaths;

    public List<Imgpath> getImgpaths() {
        return imgpaths;
    }

    public void setImgpaths(List<Imgpath> imgpaths) {
        this.imgpaths = imgpaths;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getXingz() {
        return xingz;
    }

    public void setXingz(String xingz) {
        this.xingz = xingz;
    }

    public String getJsjt2() {
        return jsjt2;
    }

    public void setJsjt2(String jsjt2) {
        this.jsjt2 = jsjt2;
    }

    public String getJsjt3() {
        return jsjt3;
    }

    public void setJsjt3(String jsjt3) {
        this.jsjt3 = jsjt3;
    }

    public String getXuequ() {
        return xuequ;
    }

    public void setXuequ(String xuequ) {
        this.xuequ = xuequ;
    }

    public String getJsjt1() {
        return jsjt1;
    }

    public void setJsjt1(String jsjt1) {
        this.jsjt1 = jsjt1;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getReno() {
        return reno;
    }

    public void setReno(String reno) {
        this.reno = reno;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLooktime() {
        return looktime;
    }

    public void setLooktime(String looktime) {
        this.looktime = looktime;
    }

    public String getIntr() {
        return intr;
    }

    public void setIntr(String intr) {
        this.intr = intr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people == null ? null : people.trim();
    }

    public Date getBegindate() {
        return begindate;
    }

    public void setBegindate(Date begindate) {
        this.begindate = begindate;
    }

    public String getWorkid() {
        return workid;
    }

    public void setWorkid(String workid) {
        this.workid = workid == null ? null : workid.trim();
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }
}
