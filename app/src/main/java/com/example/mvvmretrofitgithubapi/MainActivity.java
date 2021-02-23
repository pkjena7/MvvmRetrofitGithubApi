package com.example.mvvmretrofitgithubapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.example.mvvmretrofitgithubapi.model.RequestModel;
import com.example.mvvmretrofitgithubapi.model.ResponseModel;
import com.example.mvvmretrofitgithubapi.retrofit.RetrofitViewModel;

import org.json.JSONException;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    public static final String USERNAME = "pkjena7";
    public static final String REPO = "CricCorner";

    Context context;
    RetrofitViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        viewModel = ViewModelProviders.of(this).get(RetrofitViewModel.class);
        viewModel.init();

            callApi();



    }

    private void callApi() {

        viewModel.getChatRepository(USERNAME,REPO).observe(this, new Observer<ResponseModel>() {
            @Override
            public void onChanged(ResponseModel responseModel) {

                Log.d(TAG, "onChanged: NAME: " + responseModel.getName());
                Log.d(TAG, "onChanged: FULL NAME: " + responseModel.getFull_name());
                Log.d(TAG, "onChanged: Created at: " + responseModel.getCreated_at());
                Log.d(TAG, "onChanged: Pushed at: " + responseModel.getPushed_at());

            }
        });

    }
}