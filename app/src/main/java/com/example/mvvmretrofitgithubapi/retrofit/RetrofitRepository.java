package com.example.mvvmretrofitgithubapi.retrofit;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvmretrofitgithubapi.model.RequestModel;
import com.example.mvvmretrofitgithubapi.model.ResponseModel;
import com.google.gson.Gson;

import org.json.JSONException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RetrofitRepository {

    private static RetrofitRepository retrofitRepository;

    public static RetrofitRepository getInstance() {
        if (retrofitRepository == null) {
            retrofitRepository = new RetrofitRepository();
        }
        return retrofitRepository;
    }

    private ApiRequest apiRequest;

    Retrofit retrofitClient;

    public RetrofitRepository() {

        apiRequest = RetrofitRequest.cteateService(ApiRequest.class);
        retrofitClient = RetrofitRequest.getRetrofitClient();

    }


    public MutableLiveData<ResponseModel> getGitRepo(String username,String repo) {

        final MutableLiveData<ResponseModel> homeData = new MutableLiveData<>();

//        Gson gson = new Gson();
//        String json = gson.toJson(requestModel);
//        Log.d("git_repo_api", "request:: " + json);

        Call<ResponseModel> call = apiRequest.getGitRepo(username,repo);

        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {

                if (!response.isSuccessful()) {
                    Log.d("git_repo_api", "onError: Code " + response.code() + response.message());
                    return;
                }

                Gson gson = new Gson();
                String json = gson.toJson(response.body());
                Log.d("git_repo_api", "onResponse: Body " + json);

                homeData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Log.d("git_repo_api", "onFailure: " + t.getMessage());
                homeData.setValue(null);
            }
        });
        return homeData;
    }



}
