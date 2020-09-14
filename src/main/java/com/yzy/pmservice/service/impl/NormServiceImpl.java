package com.yzy.pmservice.service.impl;

import com.yzy.pmservice.pojo.Chuzu;
import com.yzy.pmservice.service.NormService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:   实现 NormService 接口   复写NormService接口中的所有方法
 * Author:zlp
 * Date:2020/9/14 10:55
 */
@Service
@Slf4j
public class NormServiceImpl implements NormService {
    @Override
    public void sendRentDueMsg(List<Chuzu> chuzuList) {
        log.info("我是具体业务");
        log.info("#########展示数据：     {}#######",chuzuList.toString());
    }
}
