package com.example.uts_project;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.content.DialogInterface;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class NowPlayingActivity extends AppCompatActivity {
    TextView songTitle;
    ImageView songAlbumArt;
    MediaPlayer mediaPlayer;
    private AlertDialog.Builder dialog;
    private LayoutInflater inflater;
    private View dialogView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dialog = new AlertDialog.Builder(NowPlayingActivity.this);
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.now_playing, null);
        dialog.setView(dialogView);
        dialog.setCancelable(true);
        setContentView(R.layout.now_playing);
        Intent listSongIntent = getIntent();
        mediaPlayer = new MediaPlayer();

        songTitle = findViewById(R.id.song_title_now);
        songAlbumArt = findViewById(R.id.song_album_art_now);

        String title = listSongIntent.getStringExtra("title");
        String artist = listSongIntent.getStringExtra("artist");
        String path = listSongIntent.getStringExtra("path");
        String thumbnail = listSongIntent.getStringExtra("album");

        songTitle.setText(title);
        Glide.with(this).load(thumbnail).placeholder(R.mipmap
                .music_art).error(R.mipmap.music_art)
                .crossFade().centerCrop().into(songAlbumArt);

        playMusic(path);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopMusic();
        mediaPlayer.release();
        mediaPlayer = null;
    }

    private void playMusic(String path){
        mediaPlayer.reset();
        try {
            mediaPlayer.setDataSource(path);
            mediaPlayer.prepare();
        }catch (Exception e){
            e.printStackTrace();
        }
        mediaPlayer.start();
    }

    private void stopMusic(){
        mediaPlayer.pause();
        mediaPlayer.stop();
    }
}