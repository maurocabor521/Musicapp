package com.example.andrescabal.musicapp.domain.usecase.impl;


import com.example.andrescabal.musicapp.domain.model.TopTrackResponse;
import com.example.andrescabal.musicapp.domain.usecase.GeoUseCase;
import com.example.andrescabal.musicapp.helpers.Callback;
import com.example.andrescabal.musicapp.helpers.ThreadExecutor;
import com.example.andrescabal.musicapp.repository.GeoRepository;
import com.example.andrescabal.musicapp.repository.impl.GeoRepositoryLastFm;

/**
 * Created by krlosf on 23/04/18.
 */

public class GeoUseCaseImpl implements GeoUseCase {

    private GeoRepository geoRepository;

    public GeoUseCaseImpl() {
        this.geoRepository = new GeoRepositoryLastFm();
    }

    @Override
    public void getTopTracks(final String country, final Callback<TopTrackResponse> callback) {
        new ThreadExecutor<TopTrackResponse>()
                .execute(new ThreadExecutor.Task<TopTrackResponse>() {
                    @Override
                    public TopTrackResponse execute() throws Exception {
                        return geoRepository.getTopTracks(country);
                    }

                    @Override
                    public void finish(Exception error, TopTrackResponse result) {
                        if(error == null) {
                            callback.success(result);
                        } else {
                            callback.error(error);
                        }
                    }
                });
    }
}
