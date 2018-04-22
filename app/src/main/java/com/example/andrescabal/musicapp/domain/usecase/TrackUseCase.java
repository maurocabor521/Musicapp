package com.example.andrescabal.musicapp.domain.usecase;

import com.example.andrescabal.musicapp.helpers.Callback;





public interface TrackUseCase {

    void love(String artist, String track, Callback<Boolean> callback);

    void unlove(String artist, String track, Callback<Boolean> callback);

}
