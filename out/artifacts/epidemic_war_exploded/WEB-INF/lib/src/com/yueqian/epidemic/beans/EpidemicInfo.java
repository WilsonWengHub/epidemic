package com.yueqian.epidemic.beans;

import java.util.Date;

public class EpidemicInfo {
    private int serialId;
    private short dataYear,dataMonth,dataDay;
    private int provinceId;
    private int affirmed,suspected,cured,isolated,dead;
    private int userId;
    private Date inputDate;

    public int getSerialId() {
        return serialId;
    }

    public void setSerialId(int serialId) {
        this.serialId = serialId;
    }

    public short getDataYear() {
        return dataYear;
    }

    public void setDataYear(short dataYear) {
        this.dataYear = dataYear;
    }

    public short getDataMonth() {
        return dataMonth;
    }

    public void setDataMonth(short dataMonth) {
        this.dataMonth = dataMonth;
    }

    public short getDataDay() {
        return dataDay;
    }

    public void setDataDay(short dataDay) {
        this.dataDay = dataDay;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public int getAffirmed() {
        return affirmed;
    }

    public void setAffirmed(int affirmed) {
        this.affirmed = affirmed;
    }

    public int getSuspected() {
        return suspected;
    }

    public void setSuspected(int suspected) {
        this.suspected = suspected;
    }

    public int getCured() {
        return cured;
    }

    public void setCured(int cured) {
        this.cured = cured;
    }

    public int getIsolated() {
        return isolated;
    }

    public void setIsolated(int isolated) {
        this.isolated = isolated;
    }

    public int getDead() {
        return dead;
    }

    public void setDead(int dead) {
        this.dead = dead;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }
}
