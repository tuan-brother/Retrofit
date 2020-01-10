package com.example.retrofit.remote.data;

import android.view.View;

public class ThongTin {
    String tenTP;
    String infoTP;
    String nhietDo;
    String doAm;
    String knm;
    View view;

    public ThongTin(String tenTP, String infoTP, String nhietDo, String doAm, String knm, View view) {
        this.tenTP = tenTP;
        this.infoTP = infoTP;
        this.nhietDo = nhietDo;
        this.doAm = doAm;
        this.knm = knm;
        this.view = view;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public String getTenTP() {
        return tenTP;
    }

    public void setTenTP(String tenTP) {
        this.tenTP = tenTP;
    }

    public String getInfoTP() {
        return infoTP;
    }

    public void setInfoTP(String infoTP) {
        this.infoTP = infoTP;
    }

    public String getNhietDo() {
        return nhietDo;
    }

    public void setNhietDo(String nhietDo) {
        this.nhietDo = nhietDo;
    }

    public String getDoAm() {
        return doAm;
    }

    public void setDoAm(String doAm) {
        this.doAm = doAm;
    }

    public String getKnm() {
        return knm;
    }

    public void setKnm(String knm) {
        this.knm = knm;
    }
}

