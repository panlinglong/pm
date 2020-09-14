package com.yzy.pmservice.schedule;

import com.yzy.pmservice.mapper.ChuzuMapper;
import com.yzy.pmservice.pojo.Chuzu;
import com.yzy.pmservice.pojo.RespPageBean;
import com.yzy.pmservice.service.ChuzuService;
import com.yzy.pmservice.service.NormService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description:
 * Author:zlp
 * Date:2020/9/14 9:10
 */
@Component
@Slf4j
public class RentDueTask {
    @Resource
    private ChuzuMapper chuzuMapper;
    @Resource
    private NormService normService;
   //每天凌晨零点零分执行   定时任务执行业务（处理数据或者发送消息），不进行返回数据
    @Scheduled(cron = "0 0 0 * * ?")
    public void scheduleNoticeRepair() {
        try{
            Date now = new Date();
            List<Chuzu> chuzuList = chuzuMapper.getChuzu();
            //需要返回的到期时间小于30天的数据  写法1开始（适合大量数据）
            List<Chuzu> reatDueResult = chuzuList.stream().filter(chuzuCopy -> {
                int intervalTime = (int) ((chuzuCopy.getEndDate().getTime() - now.getTime()) / (1000 * 3600 * 24));
                if (intervalTime <= 30) {
                    return true;
                } else {
                    return false;
                }
            }).collect(Collectors.toList());
           //写法1结束

//            //写法2开始（适合小量数据）
//            List<Chuzu> reatDueResult2 = new ArrayList<>();
//            for(Chuzu chuzuCopy:chuzuList){
//                int intervalTime = (int) ((chuzuCopy.getEndDate().getTime() - now.getTime()) / (1000 * 3600 * 24));
//                if (intervalTime <= 30) {
//                    reatDueResult2.add(chuzuCopy);
//                }
//            }
//            bean.setData(reatDueResult2);
//            //写法2结束



            //TODO 具体业务
            normService.sendRentDueMsg(reatDueResult);
        }catch (Exception e){
           log.info("#######RespPageBean_error#######",e);
        }

    }
}
