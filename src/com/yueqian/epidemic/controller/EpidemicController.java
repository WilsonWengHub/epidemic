package com.yueqian.epidemic.controller;

import com.yueqian.epidemic.beans.*;

import com.yueqian.epidemic.service.EpidemicService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/epidemicData")
public class EpidemicController {
    @Autowired
    private EpidemicService epidemicService;

    private  static Logger logger = Logger.getLogger(EpidemicController.class);


    @PostMapping("ajax/input")
    @ResponseBody
    //让springMVC把数据转化成 DailyEpidemicInfo类型 [{date,list<epidemicInfo>}]
    public AjaxResponseInfo inputData(@RequestBody DailyEpidemicInfo dailyEpidemicInfo,HttpSession session,Model model){
        AjaxResponseInfo responseInfo = new AjaxResponseInfo();
        logger.debug(dailyEpidemicInfo);
        //从Session中取得当前登录系统的用户信息
        UserInfo user =(UserInfo) session.getAttribute("loginedUser");//返回类型为Object
        if(user == null){
            responseInfo.setCode(-2);
            responseInfo.setMsg("你还没有登陆");
        }else{
            //将数据保存 并返回未录入数据
            List<ProvinceInfo> list = this.epidemicService.saveData(dailyEpidemicInfo,user.getUserId());
            responseInfo.setData(list);
        }
        return  responseInfo;
    }

    @GetMapping("/ajax/lastestData")
    @ResponseBody//让SrpingMVC将数据返回json格式
    public AjaxResponseInfo findLastestDate(){

        AjaxResponseInfo responseInfo = new AjaxResponseInfo();

        List<EpidemicDetailInfo> list =this.epidemicService.findLastestDate();
        responseInfo.setData(list);
        return responseInfo;

    }
}
