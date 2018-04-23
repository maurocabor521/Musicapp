package com.example.andrescabal.musicapp.repository;

/**
 * Created by Andrés Cabal on 22/04/2018.
 */

public interface GeoRepository {
    String TopTracksResponse() throws Exception;
    String getTopTracks(String country_name) throws Exception;
}
