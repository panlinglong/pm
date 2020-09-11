package com.yzy.pmservice.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class Kehu {
    /** id*/
    private Integer id;

    /** 客户姓名*/
    private String name;

    /** 性别*/
    private String gender;

    /**不用 */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date birthday;

    /** 需求*/
    private String demand;

    /** 跟进*/
    private String followup;

    /** 负责人id*/
    private String hrid;

    /** 电话*/
    private String phone;

    /** 性质*/
    private String xingz;

    /** 备注*/
    private String remarks;

    /** 编号*/
    private String kehuid;

    List<Kehu_a> kehuAs;



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

    public String getDemand() {
        return demand;
    }

    public void setDemand(String demand) {
        this.demand = demand == null ? null : demand.trim();
    }

    public String getFollowup() {
        return followup;
    }

    public void setFollowup(String followup) {
        this.followup = followup == null ? null : followup.trim();
    }

    public String getHrid() {
        return hrid;
    }

    public void setHrid(String hrid) {
        this.hrid = hrid == null ? null : hrid.trim();
    }


    public String getKehuid() {
        return kehuid;
    }

    public void setKehuid(String kehuid) {
        this.kehuid = kehuid == null ? null : kehuid.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Kehu_a> getKehuAs() {
        return kehuAs;
    }

    public void setKehuAs(List<Kehu_a> kehuAs) {
        this.kehuAs = kehuAs;
    }

}
