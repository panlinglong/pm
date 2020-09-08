package com.yzy.pmservice.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Newinfo {
    /** id*/
    private Integer id;

    /** 客户姓名*/
    private String name1;

    /** 项目名称*/
    private String name2;

    /**时间 */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date dates;

    /** 对接人*/
    private String people2;

    /** 面积*/
    private String mianji;

    /** 带看人*/
    private String people1;

    /** 电话*/
    private String phone;

    /** 编号*/
    private String workid;

    /** 备注*/
    private String remarks;

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1 == null ? null : name1.trim();
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2 == null ? null : name2.trim();
    }

    public String getPeople1() {
        return people1;
    }

    public void setPeople1(String people1) {
        this.people1 = people1 == null ? null : people1.trim();
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }



    public String getMianji() {
        return mianji;
    }

    public void setMianji(String mianji) {
        this.mianji = mianji == null ? null : mianji.trim();
    }

    public String getPeople2() {
        return people2;
    }

    public void setPeople2(String people2) {
        this.people2 = people2 == null ? null : people2.trim();
    }

    public String getWorkid() {
        return workid;
    }

    public void setWorkid(String workid) {
        this.workid = workid == null ? null : workid.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
