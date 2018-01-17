package com.example.ilijaangeleski.lastfm.ui;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.ilijaangeleski.lastfm.MyApp;
import com.example.ilijaangeleski.lastfm.R;
import com.example.ilijaangeleski.lastfm.adapter.ArtistRecyclerViewAdapter;
import com.example.ilijaangeleski.lastfm.di.components.DaggerArtistActivityComponent;
import com.example.ilijaangeleski.lastfm.di.modules.ArtistActivityModule;
import com.example.ilijaangeleski.lastfm.model.Artist;
import com.example.ilijaangeleski.lastfm.presenter.ArtistPresenter;
import com.example.ilijaangeleski.lastfm.view.ArtistView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArtistActivity extends AppCompatActivity implements ArtistView {
    @BindView(R.id.artistRecyclerView)
    RecyclerView artistRecyclerView;
    @BindView(R.id.searchArtist)
    EditText searchArtist;

    @Inject
    ArtistPresenter presenter;
    private ArtistRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artist_main);
        ButterKnife.bind(this);
        createDependencies();
        initView();
        initListener();

    }

    private void initView() {

        adapter = new ArtistRecyclerViewAdapter(presenter.getArtists());
        artistRecyclerView.setAdapter(adapter);
    }

    private void initListener() {
        adapter.setOnArtistClick(new ArtistRecyclerViewAdapter.OnArtistClick() {
            @Override
            public void onArtistClick(Artist artist, ImageView profileImage) {
                openDetailsActivity(artist,profileImage);
            }
        });

        searchArtist.addTextChangedListener(new TextWatcher() {
            CountDownTimer timer = null;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (timer != null) {
                    timer.cancel();
                }
                timer = new CountDownTimer(500, 250) {
                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        presenter.onTextChange(searchArtist.getText().toString());
                    }
                }.start();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void createDependencies() {
        DaggerArtistActivityComponent
                .builder()
                .artistActivityModule(new ArtistActivityModule(this))
                .baseComponent(MyApp.getApp().getBaseComponent())
                .build()
                .inject(this);
    }

    private void openDetailsActivity(Artist artist, ImageView avatar) {
        Intent intent = new Intent(ArtistActivity.this, AlbumsActivity.class);
        intent.putExtra(AlbumsActivity.ARTIST_EXTRA,artist);
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(ArtistActivity.this, avatar, "profile");
        startActivity(intent, options.toBundle());
    }

    @Override
    public void updateView() {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showErrorGettingRepositories() {
        Toast.makeText(this, R.string.error_getting_artist_from_server, Toast.LENGTH_LONG).show();
    }
}
