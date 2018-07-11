package com.valorachen.me_android.http;

import com.valorachen.me_android.http.service.IssueService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceFactory {
    private static String baseUrl = "https://api.github.com/";

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static IssueService getIssueService() {
        return retrofit.create(IssueService.class);
    }
}
