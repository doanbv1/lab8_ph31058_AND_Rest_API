package com.example.lab8.Interface;

import com.example.lab8.Modal.District;
import com.example.lab8.Modal.DistrictRequest;
import com.example.lab8.Modal.Province;
import com.example.lab8.Modal.ResponeGHN;
import com.example.lab8.Modal.Ward;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Interface {


    @GET("/shiip/public-api/master-data/province")
    Call<ResponeGHN<ArrayList<Province>>> getListProvince();

    @POST("/shiip/public-api/master-data/district")
    Call<ResponeGHN<ArrayList<District>>> getListDistrict(@Body DistrictRequest districtRequest);

    @GET("/shiip/public-api/master-data/ward")
    Call<ResponeGHN<ArrayList<Ward>>> getListWard(@Query("district_id") int district_id);

}
