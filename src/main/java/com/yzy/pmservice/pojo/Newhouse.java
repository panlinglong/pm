package com.yzy.pmservice.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class Newhouse {
    /** id*/
    private Integer id;

    /** 小区名称*/
    private String name;

    /** 面积*/
    private String mianji;

    /** 编号*/
    private String workid;

    /** 价格*/
    private String price;

    /** 学区*/
    private String xuequ;

    /** 户型*/
    private String huxing;

    /** 体量*/
    private String tiliang;

    /** 物业费*/
    private String wuye;

    /** 开盘时间*/
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date opentime;

    /** 预留1*/
    private String abc1;

    /** 预留2*/
    private String abc2;

    /** 上传者*/
    private String upname;

    /** 备注*/
    private String remarks;

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
        this.name = name;
    }

    public String getMianji() {
        return mianji;
    }

    public void setMianji(String mianji) {
        this.mianji = mianji;
    }

    public String getWorkid() {
        return workid;
    }

    public void setWorkid(String workid) {
        this.workid = workid;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getXuequ() {
        return xuequ;
    }

    public void setXuequ(String xuequ) {
        this.xuequ = xuequ;
    }

    public String getHuxing() {
        return huxing;
    }

    public void setHuxing(String huxing) {
        this.huxing = huxing;
    }

    public String getTiliang() {
        return tiliang;
    }

    public void setTiliang(String tiliang) {
        this.tiliang = tiliang;
    }

    public String getWuye() {
        return wuye;
    }

    public void setWuye(String wuye) {
        this.wuye = wuye;
    }

    public Date getOpentime() {
        return opentime;
    }

    public void setOpentime(Date opentime) {
        this.opentime = opentime;
    }

    public String getAbc1() {
        return abc1;
    }

    public void setAbc1(String abc1) {
        this.abc1 = abc1;
    }

    public String getAbc2() {
        return abc2;
    }

    public void setAbc2(String abc2) {
        this.abc2 = abc2;
    }

    public String getUpname() {
        return upname;
    }

    public void setUpname(String upname) {
        this.upname = upname;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
