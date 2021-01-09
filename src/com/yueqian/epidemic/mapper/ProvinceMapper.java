package com.yueqian.epidemic.mapper;

import com.yueqian.epidemic.beans.ProvinceInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


import java.util.List;

@Mapper


public interface ProvinceMapper {
@Select(value = "Select p.*  from provinces p  " +
        "where(p.del_flag is null or p.del_flag =0) and p.province_id   " +
        " NOT IN (select e.province_id from epidemics e  " +
        "  where e.data_year = #{arg0} and e.data_month =#{arg1} and e.data_day=#{arg2}) " +
        "    ORDER BY p.province_id " +
        " LIMIT 0,6;")//限制条数 按照编号来排序
     List<ProvinceInfo> findNoDataProvince(short year ,short month ,short day);
}
