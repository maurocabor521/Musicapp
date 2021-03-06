package com.example.andrescabal.musicapp.presentation.view.activity.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.andrescabal.musicapp.R;
import com.example.andrescabal.musicapp.presentation.contract.TopTrackContract;
import com.example.andrescabal.musicapp.presentation.presenter.TopTracksPresenter;
import com.example.andrescabal.musicapp.presentation.view.activity.adapter.TopTracksAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopTracksFragment extends Fragment implements TopTrackContract.View {

    private TopTrackContract.Presenter presenter;
    private RecyclerView rvTopTracks;

    public TopTracksFragment() {
        // Required empty public constructor
    }

    public static TopTracksFragment getInstance() {
        return new TopTracksFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top_tracks, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = getView();

        if (view != null) {
            presenter = new TopTracksPresenter(this);

            rvTopTracks = view.findViewById(R.id.rvTopTracks);
            LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            rvTopTracks.setLayoutManager(layoutManager);

            TopTracksAdapter topTracksAdapter = new TopTracksAdapter(null);
            rvTopTracks.setAdapter(topTracksAdapter);

            presenter.loadTracks();
        }
    }

    @Override
    public void showLoadingIndicator() {
        //TODO IMPLEMENTAR INDICATOR
    }

    @Override
    public void hideLoadingIndicator() {
        //TODO IMPLEMENTAR INDICATOR
    }

    @Override
    public void refreshTracks() {
        //Fuerza que se refresque la lista de items del RecyclreView
        rvTopTracks.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void showLoginErrorMessage(Throwable error) {
        //TODO MOSTRAR ERROR
    }
}
