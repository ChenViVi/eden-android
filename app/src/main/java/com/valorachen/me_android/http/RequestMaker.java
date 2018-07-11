package com.valorachen.me_android.http;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class RequestMaker<T> {
    private Call<T> mCall;
    private Context mContext;
    private final String TAG = "response";

    public RequestMaker(Context context, Call<T> call) {
        onStart();
        mCall = call;
        mContext = context;
        Log.d(TAG, mCall.request().url().encodedPath() + "=>"+"url=" + mCall.request().url().toString());
        mCall.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                if (response.isSuccessful() && response.errorBody() == null) {
                        Gson gson = new Gson();
                        Log.d(TAG, mCall.request().url().encodedPath() + "=>"+"body=" + gson.toJson(response.body()));
                        onSuccess(response.body());
                } else {
                    Log.d(TAG, mCall.request().url().encodedPath() + "=>"+"error_code=" + response.code());
                    Log.d(TAG, mCall.request().url().encodedPath() + "=>"+"error_message=" + response.message());
                    Toast.makeText(mContext, "网络请求失败", Toast.LENGTH_LONG).show();
                    onFail(response.code(),response.message());
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                Log.e(TAG, mCall.request().url().encodedPath() + "=>" + "bug=" + t.getMessage());
                Toast.makeText(mContext, "网络连接失败", Toast.LENGTH_LONG).show();
            }
        });
    }

    protected void onStart(){}

    protected abstract void onSuccess(T response);

    protected void onFail(int code ,String message){
        Log.d(TAG, mCall.request().url().encodedPath() + "=>"+"code=" + code);
        Log.d(TAG, mCall.request().url().encodedPath() + "=>"+"message=" + message);
        Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();
    }
}
