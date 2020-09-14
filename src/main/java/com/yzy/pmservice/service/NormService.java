package com.yzy.pmservice.service;

import com.yzy.pmservice.pojo.Chuzu;

import java.util.List;

/**
 * Description:    规范业务方法实例    Service写成接口   impl写具体实现
 * Author:zlp
 * Date:2020/9/14 10:53
 */
public interface NormService {

    void   sendRentDueMsg(List<Chuzu> chuzuList);
}
