package com.example.mvvmretrofitgithubapi.retrofit;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmretrofitgithubapi.model.RequestModel;
import com.example.mvvmretrofitgithubapi.model.ResponseModel;

import org.json.JSONException;

public class RetrofitViewModel extends ViewModel {

    private RetrofitRepository retrofitRepository;

    public RetrofitViewModel() {
    }

    public void init() {

        if (retrofitRepository != null) {
            return;
        }
        retrofitRepository = RetrofitRepository.getInstance();
    }

    public LiveData<ResponseModel> getChatRepository(String username,String repo)  {
        return retrofitRepository.getGitRepo(username,repo);

    }


}
