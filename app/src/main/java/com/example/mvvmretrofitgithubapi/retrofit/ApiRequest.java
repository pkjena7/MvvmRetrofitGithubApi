package com.example.mvvmretrofitgithubapi.retrofit;

import com.example.mvvmretrofitgithubapi.model.RequestModel;
import com.example.mvvmretrofitgithubapi.model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiRequest {


    @Headers({
            "X-GitHub-Media-Type: github.v3; param=full; format=json"
    })

    @GET("/repos/{username}/{repo_}")
    Call<ResponseModel> getGitRepo(@Path(value = "username", encoded = true) String username1,@Path(value = "repo_", encoded = true) String repo);

}
