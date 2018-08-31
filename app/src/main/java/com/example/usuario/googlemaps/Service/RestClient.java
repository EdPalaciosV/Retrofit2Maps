package com.example.usuario.googlemaps.Service;

import com.example.usuario.googlemaps.POJO.Values;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestClient {

    @GET("json?")
    Call<Values> getData(@Query("address") String direccion);
}
