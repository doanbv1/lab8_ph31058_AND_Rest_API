package com.example.lab8.Modal;

public class DistrictRequest {
    private int province_ic;

    public DistrictRequest(int province_ic) {
        this.province_ic = province_ic;
    }

    public int getProvince_ic() {
        return province_ic;
    }

    public void setProvince_ic(int province_ic) {
        this.province_ic = province_ic;
    }
}
