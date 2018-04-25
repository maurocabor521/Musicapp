package com.example.andrescabal.musicapp.domain.usecase.impl;


import com.example.andrescabal.musicapp.domain.model.LoveTracksResponse;
import com.example.andrescabal.musicapp.domain.usecase.UserUseCase;
import com.example.andrescabal.musicapp.helpers.Callback;
import com.example.andrescabal.musicapp.helpers.ThreadExecutor;
import com.example.andrescabal.musicapp.repository.UserRepository;
import com.example.andrescabal.musicapp.repository.impl.UserRepositoryLastFm;

/**
 * Created by krlosf on 23/04/18.
 */

public class UserUseCaseImpl implements UserUseCase {

    private UserRepository userRepository;

    public UserUseCaseImpl() {
        this.userRepository = new UserRepositoryLastFm();
    }

    @Override
    public void getLovedTracks(final String user, final Callback<LoveTracksResponse> callback) {
        new ThreadExecutor<LoveTracksResponse>()
                .execute(new ThreadExecutor.Task<LoveTracksResponse>() {
                    @Override
                    public LoveTracksResponse execute() throws Exception {
                        return userRepository.getLovedTracks(user);
                    }

                    @Override
                    public void finish(Exception error, LoveTracksResponse result) {
                        if(error == null) {
                            callback.success(result);
                        } else {
                            callback.error(error);
                        }
                    }
                });
    }
}
