package com.yueqian.epidemic.beans;

public class ProvinceInfo {
    private  int provinceId;
    private String provinceName;
    private String provincePy;
    private  int delFlag;

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getProvincePy() {
        return provincePy;
    }

    public void setProvincePy(String provincePy) {
        this.provincePy = provincePy;
    }

    public int getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(int delFlag) {
        this.delFlag = delFlag;
    }
}
