package com.yzy.pmservice.mapper;


import com.yzy.pmservice.pojo.Chuzudeal;
import com.yzy.pmservice.pojo.Empdeal;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChuzudealMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Chuzudeal record);

    int insertSelective(Chuzudeal record);

    Chuzudeal selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Chuzudeal record);

    int updateByPrimaryKey(Chuzudeal record);

    List<Chuzudeal> getChuzudealByPage(@Param("page") Integer page,@Param("size") Integer size,@Param("keyword") String keyword);

    Long getTotal(@Param("keyword") String keyword);

    Integer maxWorkID();
}
