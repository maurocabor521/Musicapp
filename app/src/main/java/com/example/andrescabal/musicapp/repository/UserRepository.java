package com.example.andrescabal.musicapp.repository;

/**
 * Created by Andrés Cabal on 22/04/2018.
 */

public interface UserRepository {
    String LovedTracksResponse() throws Exception;
    String getLovedTracks(String username) throws Exception;
}
