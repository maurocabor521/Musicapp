package com.example.andrescabal.musicapp.repository;

import com.example.andrescabal.musicapp.domain.model.MobileSessionResponse;



/**
 * Created by krlosf on 14/04/18.
 */

public interface LastFmAuthRepository {

    MobileSessionResponse getMobileSession(String username, String password) throws Exception;

}
