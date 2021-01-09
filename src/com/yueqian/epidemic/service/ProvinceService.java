package com.yueqian.epidemic.service;

import com.yueqian.epidemic.beans.ProvinceInfo;


import java.util.List;



public interface ProvinceService {
    /**
     * 获取还未录入数据的省份
     * @return
     */
    List<ProvinceInfo> findNoDateProvinces(String date);
}
