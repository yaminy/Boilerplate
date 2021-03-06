package com.yaminy.boilerplate.data;

import android.content.Context;

import com.yaminy.boilerplate.data.network.ApiBaseCreator;
import com.yaminy.boilerplate.data.network.ApiHeader;
import com.yaminy.boilerplate.data.preferences.AppPreferences;

public class AppDataManager implements AppDataManagerHelper {

    private AppPreferences appPreferences;
    private static AppDataManager appDataManager;

    public static AppDataManager getInstance(Context context) {
        if (appDataManager == null) {
            appDataManager = new AppDataManager(AppPreferences.getInstance(context), ApiBaseCreator.getApiHeader(""));
        }
        return appDataManager;
    }

    public AppDataManager(AppPreferences appPreferences, ApiHeader apiHeader) {
        this.appPreferences = appPreferences;
    }

    public AppDataManager(Context context) {
        this.appPreferences = AppPreferences.getInstance(context);
    }
    //<<<<<<<<< API CALLS ARE HERE >>>>>>>>
//    @Override
//    public Call<LoginResponse> doLoginApiCall(String grantType, String userName, String password, String clientId, final Callback<LoginResponse> callback) {
//        Call<LoginResponse> call = ApiBaseCreator.getApiHeader("").loginPostRequest(grantType, userName, password, clientId);
//        call.enqueue(new Callback<LoginResponse>() {
//            @Override
//            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
//                if (response.isSuccessful()) {
//                }
//                callback.onResponse(call, response);
//
//            }
//
//            @Override
//            public void onFailure(Call<LoginResponse> call, Throwable t) {
//                callback.onFailure(call, t);
//
//            }
//
//        });
//        return call;
//    }

    //<<<<<<<<< SHARED PREFS ARE HERE >>>>>>>>
    @Override
    public void cleanAllThings() {
        appPreferences.clearAllThings();
    }


}
