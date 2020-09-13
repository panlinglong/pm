package com.yzy.pmservice.mapper;


import com.yzy.pmservice.pojo.Chuzu;
import com.yzy.pmservice.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ChuzuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Chuzu record);

    int insertSelective(Chuzu record);

    Chuzu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Chuzu record);

    int updateByPrimaryKey(Chuzu record);

    List<Chuzu> getChuzuByPage(@Param("page") Integer page,@Param("size") Integer size,@Param("keyword") String keyword);

    List<Chuzu> getChuzu();

    Long getTotal(@Param("keyword") String keyword);
//DateDiff(dd,endDate,getdate())&lt;=30
    Integer maxWorkID();
}
