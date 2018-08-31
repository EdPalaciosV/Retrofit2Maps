package com.example.usuario.googlemaps.Service;

import android.content.Context;
import android.util.Log;

import com.example.usuario.googlemaps.POJO.Values;
import com.example.usuario.googlemaps.showResults;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoadJson {

    String direecion;
    Context context;

    public LoadJson(Context context,String direecion){
        this.context=context;
        this.direecion=direecion;
    }

    public void getValues(){


        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://maps.googleapis.com/maps/api/geocode/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RestClient restClient=retrofit.create(RestClient.class);
        Call<Values> call=restClient.getData(direecion);

        call.enqueue(new Callback<Values>() {
            @Override
            public void onResponse(Call<Values> call, Response<Values> response) {

                double lat=response.body().getResults().get(0).getGeometry().getLocation().getLat();
                double lng=response.body().getResults().get(0).getGeometry().getLocation().getLng();

                ((showResults)context).getLatLong(lat,lng);
            }

            @Override
            public void onFailure(Call<Values> call, Throwable t) {

                t.printStackTrace();
            }
        });
    }

}
