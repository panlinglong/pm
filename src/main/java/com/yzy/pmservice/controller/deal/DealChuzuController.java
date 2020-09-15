package com.yzy.pmservice.controller.deal;

import com.yzy.pmservice.pojo.Chuzudeal;
import com.yzy.pmservice.pojo.Empdeal;
import com.yzy.pmservice.pojo.RespBean;
import com.yzy.pmservice.pojo.RespPageBean;
import com.yzy.pmservice.service.ChuzudealService;
import com.yzy.pmservice.service.EmpdealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/deal/chuzu")
public class DealChuzuController {

    @Autowired
    private ChuzudealService chuzudealService;

    @GetMapping("/")
    public RespPageBean getChuzudealByPage(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10") Integer size,@RequestParam String keyword){
        return chuzudealService.getChuzudealByPage(page,size,keyword);
    }

    @PostMapping("/")
    public RespBean addChuzudeal(@RequestBody Chuzudeal chuzudeal){
        if (chuzudealService.addChuzudeal(chuzudeal)==1){
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteChuzudealByEid(@PathVariable Integer id){
        if (chuzudealService.deleteChuzudealByEid(id)==1){
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @PutMapping("/")
    public RespBean updateChuzudeal(@RequestBody Chuzudeal chuzudeal){
        if (chuzudealService.updateChuzudeal(chuzudeal)==1){
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }



    @GetMapping("/maxWorkID")
    public RespBean maxWorkID(){
        return RespBean.ok("",String.format("%08d",chuzudealService.maxWorkID()+1));
    }


}
