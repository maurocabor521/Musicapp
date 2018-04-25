package com.example.andrescabal.musicapp.domain.usecase.impl;

import android.content.pm.LauncherApps;

import com.example.andrescabal.musicapp.domain.model.MobileSessionResponse;
import com.example.andrescabal.musicapp.domain.usecase.LastFmAuthUseCase;
import com.example.andrescabal.musicapp.helpers.Callback;
import com.example.andrescabal.musicapp.helpers.ThreadExecutor;
import com.example.andrescabal.musicapp.repository.LastFmAuthRepository;
import com.example.andrescabal.musicapp.repository.impl.LastFmAuthRepositoryImpl;


/**
 * Created by krlosf on 15/04/18.
 */

public class LastFmAuthUseCaseImpl implements LastFmAuthUseCase {

    private LastFmAuthRepository lastFmAuthRepository;

    public LastFmAuthUseCaseImpl() {
        this.lastFmAuthRepository = new LastFmAuthRepositoryImpl();
    }

    @Override
    public void getMobileSession(final String username, final String password,
                                 final Callback<MobileSessionResponse> callback) {
        new ThreadExecutor<MobileSessionResponse>()
                .execute(new ThreadExecutor.Task<MobileSessionResponse>() {
                    @Override
                    public MobileSessionResponse execute() throws Exception {
                        return lastFmAuthRepository.getMobileSession(username, password);
                    }

                    @Override
                    public void finish(Exception error, MobileSessionResponse result) {
                        if(error == null) {
                            callback.success(result);
                        } else {
                            callback.error(error);
                        }
                    }
                });
    }
}
