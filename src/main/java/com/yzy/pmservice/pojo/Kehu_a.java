package com.yzy.pmservice.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Kehu_a {
    /** id*/
    private Integer id;

    /**日期 */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date kfdate;

    /** 内容*/
    private String kfjl;

    /** 编号*/
    private String kehuid;


    public Date getKfdate() {
        return kfdate;
    }

    public void setKfdate(Date kfdate) {
        this.kfdate = kfdate;
    }
    public String getKehuid() {
        return kehuid;
    }

    public void setKehuid(String kehuid) {
        this.kehuid = kehuid == null ? null : kehuid.trim();
    }

    public String getKfjl() {
        return kfjl;
    }

    public void setKfjl(String kfjl) {
        this.kfjl = kfjl;
    }
}
