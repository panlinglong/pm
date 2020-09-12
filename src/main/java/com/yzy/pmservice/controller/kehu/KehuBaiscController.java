package com.yzy.pmservice.controller.kehu;

import com.yzy.pmservice.pojo.*;
import com.yzy.pmservice.service.EmployeeService;
import com.yzy.pmservice.service.KehuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kehu/basic")
public class KehuBaiscController {

    @Autowired
    private KehuService kehuService;



    @GetMapping("/")
    public RespPageBean getKehuByPage(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10") Integer size,@RequestParam String keyword){
        return kehuService.getKehuByPage(page,size,keyword);
    }

    @PostMapping("/")
    public RespBean addKehu(@RequestBody Kehu kehu){
        if (kehuService.addKehu(kehu)==1){
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @PostMapping("/kehua")
    public RespBean addKehuA(@RequestBody Kehu_a kehu_a){
        if (kehuService.addKehuA(kehu_a) == 1){
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败！");
    }



    @DeleteMapping("/{id}")
    public RespBean deleteKehuByEid(@PathVariable Integer id){
        if (kehuService.deleteKehuByEid(id)==1){
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @DeleteMapping("/kehua/{id}")
    public RespBean deleteKehuaByEid(@PathVariable Integer id){
        if (kehuService.deleteKehuaByEid(id)==1){
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }


    @PutMapping("/")
    public RespBean updateKehu(@RequestBody Kehu kehu){
        if (kehuService.updateKehu(kehu)==1){
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }



    @GetMapping("/maxWorkID")
    public RespBean maxWorkID(){
        return RespBean.ok("",String.format("%08d",kehuService.maxWorkID()+1));
    }


}
