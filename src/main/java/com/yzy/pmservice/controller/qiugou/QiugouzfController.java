package com.yzy.pmservice.controller.qiugou;

import com.yzy.pmservice.pojo.Qiugoues;
import com.yzy.pmservice.pojo.Qiugouzf;
import com.yzy.pmservice.pojo.RespBean;
import com.yzy.pmservice.pojo.RespPageBean;
import com.yzy.pmservice.service.QiugouesService;
import com.yzy.pmservice.service.QiugouzfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/qiugou/zufang")
public class QiugouzfController {

    @Autowired
    private QiugouzfService qiugouzfService;

    @GetMapping("/")
    public RespPageBean getQiugouzfsByPage(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10") Integer size,@RequestParam String keyword){
        return qiugouzfService.getQiugouzfByPage(page,size,keyword);
    }

    @PostMapping("/")
    public RespBean addQiugoues(@RequestBody Qiugouzf qiugouzf){
        if (qiugouzfService.addQiugouzf(qiugouzf)==1){
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteQiugouzfByEid(@PathVariable Integer id){
        if (qiugouzfService.deleteQiugouzfByEid(id)==1){
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @PutMapping("/")
    public RespBean updateQiugouzf(@RequestBody Qiugouzf qiugouzf){
        if (qiugouzfService.updateQiugouzf(qiugouzf)==1){
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }



    @GetMapping("/maxWorkID")
    public RespBean maxWorkID(){
        return RespBean.ok("",String.format("%08d",qiugouzfService.maxWorkID()+1));
    }


}
