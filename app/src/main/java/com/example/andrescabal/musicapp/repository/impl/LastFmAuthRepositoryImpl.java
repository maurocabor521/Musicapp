package com.example.andrescabal.musicapp.repository.impl;

import com.example.andrescabal.musicapp.domain.model.MobileSessionResponse;
import com.example.andrescabal.musicapp.domain.usecase.SignCallUseCase;
import com.example.andrescabal.musicapp.domain.usecase.impl.SignCallUseCaseImpl;
import com.example.andrescabal.musicapp.helpers.Constants;
import com.example.andrescabal.musicapp.helpers.RetrofitSingleton;
import com.example.andrescabal.musicapp.repository.LastFmAuthRepository;

import java.util.HashMap;
import java.util.Map;


import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created by krlosf on 15/04/18.
 */

public class LastFmAuthRepositoryImpl implements LastFmAuthRepository {

    interface AuthServices {
        @POST("2.0/")
        Call<MobileSessionResponse> getMobileSession(@QueryMap Map<String, String> params);
    }

    @Override
    public MobileSessionResponse getMobileSession(String username, String password) throws Exception {
        Map<String, String> params = new HashMap<>(0);
        String method = "auth.getMobileSession";
        params.put("method", method);
        params.put("api_key", Constants.API_KEY);
        params.put("password", password);
        params.put("username", username);

        SignCallUseCase signCallUseCase = SignCallUseCaseImpl.getInstance();
        String apiSig = signCallUseCase.signature(method, params, Constants.SECRET);
        params.put("api_sig", apiSig);
        params.put("format", Constants.API_RESPONSE_FORMAT);

        AuthServices authServices = RetrofitSingleton.getInstance().create(AuthServices.class);

        Call<MobileSessionResponse> call = authServices.getMobileSession(params);
        Response<MobileSessionResponse> response = call.execute();

        if(response.isSuccessful()) {
            return response.body();
        } else {
            throw new Exception(response.message());
        }
    }
}
