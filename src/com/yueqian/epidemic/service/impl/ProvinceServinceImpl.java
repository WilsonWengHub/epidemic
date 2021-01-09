package com.yueqian.epidemic.service.impl;

import com.yueqian.epidemic.beans.ProvinceInfo;
import com.yueqian.epidemic.mapper.ProvinceMapper;
import com.yueqian.epidemic.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServinceImpl implements ProvinceService {
    @Autowired
    private ProvinceMapper provinceMapper;
    @Override
    public List<ProvinceInfo> findNoDateProvinces(String date) {
        short year = 0,month = 0 ,day = 0;
        String array[] = date.split("-");
        List<ProvinceInfo> list = null;
        if(array.length>=3){
            year=Short.parseShort(array[0]);
            month=Short.parseShort(array[1]);
            day=Short.parseShort(array[2]);
            list = this.provinceMapper.findNoDataProvince(year,month,day);
        }
        return list;
    }
}
