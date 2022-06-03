package com.marufalam.simplerestfulapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("posts")
    Call<List<ResponseModel>> getResponse();
    @GET("photos")
    Call<List<PhotoModel>> getPhotos();

}
