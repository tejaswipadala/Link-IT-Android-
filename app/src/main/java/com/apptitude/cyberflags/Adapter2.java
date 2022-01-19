package com.apptitude.cyberflags;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apptitude.cyberflags.R;
import com.devbrackets.android.exomedia.ui.widget.VideoView;
import com.google.android.exoplayer2.Player;

import java.net.URI;
import java.util.ArrayList;

public class Adapter2 extends RecyclerView.Adapter<Adapter2.ViewHolder> {

    private ArrayList<String> uris;
    private Context context;

    Adapter2(Context context, ArrayList<String> uris) {
        this.context = context;
        this.uris = uris;
    }

    @NonNull
    @Override
    public Adapter2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item2, parent, false);
        return new Adapter2.ViewHolder((view));
    }

    @Override
    public void onBindViewHolder(@NonNull final Adapter2.ViewHolder holder, final int position) {

        Uri uri= Uri.parse(uris.get(position));
        holder.videoView.setRepeatMode(Player.REPEAT_MODE_ONE);
        holder.videoView.setVideoURI(uri);
    }

    @Override
    public int getItemCount() {
        return uris.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        VideoView videoView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            videoView=itemView.findViewById(R.id.video_view);
            videoView.setOnPreparedListener(() -> videoView.start());
        }
    }
}