package com.yzy.pmservice.mapper;


import com.yzy.pmservice.pojo.Kehu;
import com.yzy.pmservice.pojo.Kehu_a;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface KehuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Kehu record);



    int insertSelective(Kehu record);



    Kehu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Kehu record);

    int updateByPrimaryKey(Kehu record);

    List<Kehu> getKehuByPage(@Param("page") Integer page,@Param("size") Integer size,@Param("keyword") String keyword);

    List<Kehu> getMyKehuByPage(@Param("page") Integer page,@Param("size") Integer size,@Param("keyword") String keyword,@Param("keyid") Integer keyid);

    Long getTotal(@Param("keyword") String keyword);

    Integer maxWorkID();


    List<Kehu_a> getKehuAByKeHuId(String kehuid);

    int addKehuAByKehuId(Kehu_a record);
}
