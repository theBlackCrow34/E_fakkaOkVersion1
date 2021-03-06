package com.example.sherif.e_fakkaokversion1.Networking;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {

    @FormUrlEncoded
    @POST("Company/insert_company.php")
    Call<ResponseBody> insertVendor(
            @Field("name") String name,
            @Field("phone") String phone,
            @Field("mail") String mail,
            @Field("username") String username,
            @Field("password") String password,
            @Field("indastry") String indastry,
            @Field("contacts") String contacts,
            @Field("encoded_photo") String encoded_photo
    );


    @GET("Company/login_company.php")
    Call<ResponseBody> logVendor(
            @Query("username") String username,
            @Query("password") String password
    );



    @FormUrlEncoded
    @POST("User/insert_user.php")
    Call<ResponseBody> insertuser(
            @Field("name") String name,
            @Field("phone") String phone,
            @Field("username") String username,
            @Field("password") String password,
            @Field("mail") String mail,
            @Field("created_by") String created_by,
            @Field("encoded_photo") String encoded_photo
    );

    @GET("User/login_user.php")
    Call<ResponseBody> loguser(
            @Query("username") String username,
            @Query("password") String password
    );



}
