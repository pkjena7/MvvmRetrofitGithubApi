package com.example.mvvmretrofitgithubapi.model;

public class RequestModel {

  private String direction;

    public RequestModel() {
    }

    public RequestModel(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
