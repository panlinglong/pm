package com.yzy.pmservice.pojo;

public class Hximg {
    /** id*/
    private Integer id;

    /** 编号*/
    private String workid;

    /** 看房记录*/
    private String imagepath;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorkid() {
        return workid;
    }

    public void setWorkid(String workid) {
        this.workid = workid == null ? null : workid.trim();
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath == null ? null : imagepath.trim();
    }


}