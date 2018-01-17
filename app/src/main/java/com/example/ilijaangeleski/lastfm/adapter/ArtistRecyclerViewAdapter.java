package com.example.ilijaangeleski.lastfm.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ilijaangeleski.lastfm.R;
import com.example.ilijaangeleski.lastfm.model.Artist;
import com.example.ilijaangeleski.lastfm.util.CircleTransform;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ilija Angeleski on 1/17/2018.
 */

public class ArtistRecyclerViewAdapter extends RecyclerView.Adapter<ArtistRecyclerViewAdapter.MyViewHolder> {
    private List<Artist> artist;
    private OnArtistClick listener;

    public ArtistRecyclerViewAdapter(List<Artist> artist) {
        this.artist = artist;
    }

    public interface OnArtistClick {
        void onArtistClick(Artist artist, ImageView profileImage);
    }

    @Override
    public ArtistRecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_artist, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ArtistRecyclerViewAdapter.MyViewHolder holder, int position) {
        final Artist current = artist.get(position);
        holder.artistName.setText(current.getName());
        /*Picasso.with(holder.avatar.getContext()).load()
                .transform(new CircleTransform()).placeholder(R.mipmap.ic_launcher_round).error(R.mipmap.ic_launcher_round)
                .into(holder.avatar);*/
    }

    @Override
    public int getItemCount() {
        return artist.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.avatar)
        ImageView avatar;
        @BindView(R.id.artistName)
        TextView artistName;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void setOnArtistClick(OnArtistClick listener) {
        this.listener = listener;
    }
}
