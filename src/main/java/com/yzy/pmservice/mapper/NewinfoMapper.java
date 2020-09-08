package com.yzy.pmservice.mapper;


import com.yzy.pmservice.pojo.Chuzu;
import com.yzy.pmservice.pojo.Employee;
import com.yzy.pmservice.pojo.Newinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewinfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Newinfo record);

    int insertSelective(Newinfo record);

    Newinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Newinfo record);

    int updateByPrimaryKey(Newinfo record);

    List<Newinfo> getNewinfoByPage(@Param("page") Integer page,@Param("size") Integer size,@Param("keyword") String keyword);

    Long getTotal(@Param("keyword") String keyword);

    Integer maxWorkID();
}
