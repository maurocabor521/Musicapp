package com.example.andrescabal.musicapp.domain.usecase;

import com.example.andrescabal.musicapp.domain.model.MobileSessionResponse;
import com.example.andrescabal.musicapp.helpers.Callback;



/**
 * Created by krlosf on 14/04/18.
 */

public interface LastFmAuthUseCase {

    void getMobileSession(String username, String password, Callback<MobileSessionResponse> callback);

}
