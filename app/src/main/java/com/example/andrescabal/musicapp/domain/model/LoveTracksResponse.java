package com.example.andrescabal.musicapp.domain.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Andrés Cabal on 20/04/2018.
 */

public class LoveTracksResponse {

    public LovedTracks getLovedTracks() {
        return lovedTracks;
    }

    public void setLovedTracks(LovedTracks lovedTracks) {
        this.lovedTracks = lovedTracks;
    }

    @SerializedName("lovedtracks")
    private LovedTracks lovedTracks;

    public class LovedTracks {
        @SerializedName("track")
        private List<Track> tracks;

        public List<Track> getTracks() {
            return tracks;
        }

        public void setTracks(List<Track> tracks) {
            this.tracks = tracks;
        }
    }

    //representa cada cancion
    public class Track {
        private String name;
        private String url;
        @SerializedName("image")
        private List<Image> images;
        private List<Artist> artists;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public List<Image> getImages() {
            return images;
        }

        public void setImages(List<Image> images) {
            this.images = images;
        }

        public List<Artist> getArtists() {
            return artists;
        }

        public void setArtists(List<Artist> artists) {
            this.artists = artists;
        }
    }

    public class Artist {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public class Image {
        private String size;
        @SerializedName("#text")
        private String url;

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
