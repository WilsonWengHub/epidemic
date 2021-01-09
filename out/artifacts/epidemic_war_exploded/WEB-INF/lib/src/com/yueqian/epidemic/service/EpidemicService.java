package com.yueqian.epidemic.service;

import com.yueqian.epidemic.beans.DailyEpidemicInfo;
import com.yueqian.epidemic.beans.EpidemicDetailInfo;
import com.yueqian.epidemic.beans.ProvinceInfo;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface EpidemicService {
    /**
     * 保存当日的疫情数据，返回还没录入的省份列表
     */
    List<ProvinceInfo> saveData(DailyEpidemicInfo dailyEpidemicInfo,int userId);

    /**
     * 获取最新疫情数据
     * @return
     */
    List<EpidemicDetailInfo> findLastestDate();
}
