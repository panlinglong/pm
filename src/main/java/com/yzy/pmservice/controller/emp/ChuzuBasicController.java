package com.yzy.pmservice.controller.emp;

import com.yzy.pmservice.pojo.Chuzu;
import com.yzy.pmservice.pojo.Employee;
import com.yzy.pmservice.pojo.RespBean;
import com.yzy.pmservice.pojo.RespPageBean;
import com.yzy.pmservice.service.ChuzuService;
import com.yzy.pmservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chuzu/basic")
public class ChuzuBasicController {

    @Autowired
    private ChuzuService chuzuService;



    @GetMapping("/")
    public RespPageBean getChuzuByPage(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10") Integer size,@RequestParam String keyword){
        return chuzuService.getChuzuByPage(page,size,keyword);
    }

    @GetMapping("/endtime")
    public RespPageBean scheduledTask(){
        return chuzuService.scheduledTask();
    }

    @PostMapping("/")
    public RespBean addChuzu(@RequestBody Chuzu chuzu){
        if (chuzuService.addChuzu(chuzu)==1){
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteChuzuByEid(@PathVariable Integer id){
        if (chuzuService.deleteChuzuByEid(id)==1){
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @PutMapping("/")
    public RespBean updateChuzu(@RequestBody Chuzu chuzu){
        if (chuzuService.updateChuzu(chuzu)==1){
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }



    @GetMapping("/maxWorkID")
    public RespBean maxWorkID(){
        return RespBean.ok("",String.format("%08d",chuzuService.maxWorkID()+1));
    }


}
