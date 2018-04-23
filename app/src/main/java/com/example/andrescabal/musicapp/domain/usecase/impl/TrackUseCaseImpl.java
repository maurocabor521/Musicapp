package com.example.andrescabal.musicapp.domain.usecase.impl;

import com.example.andrescabal.musicapp.domain.usecase.TrackUseCase;
import com.example.andrescabal.musicapp.helpers.Callback;
import com.example.andrescabal.musicapp.helpers.ThreadExecutor;
import com.example.andrescabal.musicapp.repository.TrackRepository;



/**
 * Created by krlosf on 15/04/18.
 */

public class TrackUseCaseImpl implements TrackUseCase {

    private TrackRepository trackRepository;

    public TrackUseCaseImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public void love(final String artist, final String track, final Callback<Boolean> callback) {
        new ThreadExecutor<Boolean>()
                .execute(new ThreadExecutor.Task<Boolean>() {
                    @Override
                    public Boolean execute() throws Exception {
                        return trackRepository.love(artist, track);
                    }

                    @Override
                    public void finish(Exception error, Boolean result) {
                        if(error == null) {
                            callback.success(result);
                        } else {
                            callback.error(error);
                        }
                    }
                });
    }

    @Override
    public void unlove(final String artist, final String track, final Callback<Boolean> callback) {
        new ThreadExecutor<Boolean>()
                .execute(new ThreadExecutor.Task<Boolean>() {
                    @Override
                    public Boolean execute() throws Exception {
                        return trackRepository.unlove(artist, track);
                    }

                    @Override
                    public void finish(Exception error, Boolean result) {
                        if(error == null) {
                            callback.success(result);
                        } else {
                            callback.error(error);
                        }
                    }
                });
    }
}
