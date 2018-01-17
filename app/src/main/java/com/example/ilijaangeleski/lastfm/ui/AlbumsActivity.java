package com.example.ilijaangeleski.lastfm.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ilijaangeleski.lastfm.MyApp;
import com.example.ilijaangeleski.lastfm.R;
import com.example.ilijaangeleski.lastfm.di.components.DaggerAlbumActivityComponent;
import com.example.ilijaangeleski.lastfm.di.modules.AlbumActivityModule;
import com.example.ilijaangeleski.lastfm.model.Artist;
import com.example.ilijaangeleski.lastfm.view.AlbumView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ilija Angeleski on 1/17/2018.
 */

public class AlbumsActivity extends AppCompatActivity implements AlbumView {
    public static final String ARTIST_EXTRA = "artist_extra";

    @BindView(R.id.artistName)
    TextView artistName;
    @BindView(R.id.avatar)
    ImageView avatar;

    private Artist artist;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.albums_activity);
        ButterKnife.bind(this);
        createDependencies();

        if (getIntent().getExtras() != null
                && getIntent().hasExtra(ARTIST_EXTRA)) {
            artist = (Artist) getIntent().getExtras().getSerializable(ARTIST_EXTRA);
        }
    }
    private void createDependencies(){
        DaggerAlbumActivityComponent
                .builder()
                .albumActivityModule(new AlbumActivityModule(this))
                .baseComponent(MyApp.getApp().getBaseComponent())
                .build()
                .inject(this);
    }
    private void initView(){
        artistName.setText(artist.getName());
    }

}
