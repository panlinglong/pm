package com.yzy.pmservice.controller.deal;

import com.yzy.pmservice.pojo.Empdeal;
import com.yzy.pmservice.pojo.Newhousedeal;
import com.yzy.pmservice.pojo.RespBean;
import com.yzy.pmservice.pojo.RespPageBean;
import com.yzy.pmservice.service.EmpdealService;
import com.yzy.pmservice.service.NewhousedealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/deal/newhouse")
public class DealNewhouseController {

    @Autowired
    private NewhousedealService newhousedealService;

    @GetMapping("/")
    public RespPageBean getNewhousedealByPage(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10") Integer size,@RequestParam String keyword){
        return newhousedealService.getNewhousedealByPage(page,size,keyword);
    }

    @PostMapping("/")
    public RespBean addNewhousedeal(@RequestBody Newhousedeal newhousedeal){
        if (newhousedealService.addNewhousedeal(newhousedeal)==1){
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteNewhousedealByEid(@PathVariable Integer id){
        if (newhousedealService.deleteNewhousedealByEid(id)==1){
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @PutMapping("/")
    public RespBean updateNewhousedeal(@RequestBody Newhousedeal newhousedeal){
        if (newhousedealService.updateNewhousedeal(newhousedeal)==1){
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }



    @GetMapping("/maxWorkID")
    public RespBean maxWorkID(){
        return RespBean.ok("",String.format("%08d",newhousedealService.maxWorkID()+1));
    }


}
