package com.example.andrescabal.musicapp.domain.usecase;

import com.example.andrescabal.musicapp.domain.model.TopTrackResponse;
import com.example.andrescabal.musicapp.helpers.Callback;




public interface GeoUseCase {

    void getTopTracks(String country, Callback<TopTrackResponse> callback);

}
