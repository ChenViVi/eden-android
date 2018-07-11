package com.valorachen.me_android.http.service;

import com.valorachen.me_android.model.Issue;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

import static com.valorachen.me_android.MyApplication.REPOS;

public interface IssueService {

    @GET("repos/"+ REPOS + "/issues")
    Call<List<Issue>> get();
}
