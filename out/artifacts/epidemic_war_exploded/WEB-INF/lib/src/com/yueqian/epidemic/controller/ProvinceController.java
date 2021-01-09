package com.yueqian.epidemic.controller;

import com.yueqian.epidemic.beans.AjaxResponseInfo;
import com.yueqian.epidemic.beans.ProvinceInfo;
import com.yueqian.epidemic.service.ProvinceService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/province")
public class ProvinceController {
    private Logger logger = Logger.getLogger(ProvinceController.class);
    @Autowired
   private ProvinceService provinceService;

    @GetMapping("/ajax/noDataList")
    @ResponseBody//以json格式封装数据返回客户端
    public AjaxResponseInfo noDataProvince(String date){ //date从前端获取来的
        //输出日志
        logger.debug("date="+ date);

        //查找未被录入数据的省份
        List<ProvinceInfo> list = null;
        AjaxResponseInfo<List<ProvinceInfo>> responceInfo = new AjaxResponseInfo<>();
        if(!StringUtils.isEmpty(date)){
           list = this.provinceService.findNoDateProvinces(date);
           responceInfo.setData(list);
        }else {
            responceInfo.setCode(-1);
            responceInfo.setMsg("参数不足");
        }
        return  responceInfo;
    }

}
